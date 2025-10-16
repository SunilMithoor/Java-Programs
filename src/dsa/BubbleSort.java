package dsa;

/**
 * This class demonstrates the implementation of the Bubble Sort algorithm.
 */
public class BubbleSort {

    /**
     * The main method to test the bubble sort implementation.
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};

        System.out.println("Original array:");
        printArray(arr);

        // Sort the array using bubble sort
        bubbleSort(arr);

        System.out.println("Sorted array:");
        printArray(arr);
    }

    /**
     * Sorts an array of integers using the bubble sort algorithm.
     * In each pass, it steps through the list, compares adjacent elements,
     * and swaps them if they are in the wrong order.
     * @param arr The array to be sorted.
     */
    static void bubbleSort(int[] arr) {
        int n = arr.length;
        // Outer loop for the number of passes
        for (int i = 0; i < n - 1; i++) {
            // Inner loop for comparing adjacent elements
            // The last i elements are already in place, so we don't need to check them
            for (int j = 0; j < n - i - 1; j++) {
                // If the element found is greater than the next element, then swap
                if (arr[j] > arr[j + 1]) {
                    // Swap arr[j] and arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    /**
     * A utility function to print the elements of an array.
     * @param arr The array to be printed.
     */
    static void printArray(int[] arr) {
        for (int val : arr) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
}
