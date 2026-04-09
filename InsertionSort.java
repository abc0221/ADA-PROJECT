import java.util.Scanner;

public class InsertionSort {

    public static void insertionSort(int[] arr) {
        int n = arr.length;
        int comparisons = 0;
        int shifts = 0;
        int outerIterations = 0;

        for (int i = 1; i < n; i++) {
            outerIterations++;

            int key = arr[i];
            int j = i - 1;

            while (j >= 0) {
                comparisons++;

                if (arr[j] > key) {
                    arr[j + 1] = arr[j];
                    shifts++;
                    j--;
                } else {
                    break;
                }
            }

            arr[j + 1] = key;
        }

        // Output
        System.out.println("\nSorted Array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }

        System.out.println("\n\nOuter Iterations: " + outerIterations);
        System.out.println("Total Comparisons: " + comparisons);
        System.out.println("Total Shifts: " + shifts);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        insertionSort(arr);
        sc.close();
    }
}