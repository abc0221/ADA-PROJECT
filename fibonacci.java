import java.util.Scanner;
public class fibonacci {
    static int recursionSteps = 0;
    public static long fibonacciRecursive(int n) {
        recursionSteps++;
        if (n == 0) return 0; if (n == 1) return 1;
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of terms: ");
        int n = sc.nextInt();
        System.out.println("\n--- Fibonacci Series (Iterative) ---");
        long a = 0, b = 1;
        int iterationSteps = 0;
        for (int i = 0; i < n; i++) {
            System.out.print(a + " ");
            long next = a + b;
            a = b;
            b = next;
            iterationSteps++;
        }

        System.out.println("\n\n--- Fibonacci Series (Recursive) ---");
        recursionSteps = 0;
        for (int i = 0; i < n; i++) {System.out.print(fibonacciRecursive(i) + " ");}

        System.out.println("\n\nIteration steps: " + iterationSteps); System.out.println("Total recursive calls: " + recursionSteps);
        sc.close();
    }
}
