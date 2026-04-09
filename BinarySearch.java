public class BinarySearch {
    static int stepCount = 0;
    static int binarySearchIterative(int[] arr, int key) { stepCount = 0; int low = 0; int high = arr.length - 1;
        while (low <= high) { stepCount++; int mid = (low + high) / 2;
            if (arr[mid] == key) return mid;
            else if (arr[mid] < key) low = mid + 1;
            else high = mid - 1;
        } return -1;
    }
    static int binarySearchRecursive(int[] arr, int low, int high, int key) { stepCount++;
        if (low > high) return -1; int mid = (low + high) / 2;
        if (arr[mid] == key) return mid;
        else if (arr[mid] < key) return binarySearchRecursive(arr, mid + 1, high, key);
        else return binarySearchRecursive(arr, low, mid - 1, key);
    }
    public static void main(String[] args) { int[] arr = { 7, 12, 22, 35, 48 }; int key = 22; int result1 = binarySearchIterative(arr, key);
        if (result1 != -1) System.out.println("Iterative: Element found at index " + result1);
        else
            System.out.println("Iterative: Element not found");
        System.out.println("Step Count (Iterative): " + stepCount);
        stepCount = 0;
        int result2 = binarySearchRecursive(arr, 0, arr.length - 1, key);
        if (result2 != -1)
            System.out.println("Recursive: Element found at index " + result2);
        else
            System.out.println("Recursive: Element not found"); System.out.println("Step Count (Recursive): " + stepCount);
    }
}