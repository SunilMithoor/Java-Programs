package dsa;

/**
 * This class demonstrates the implementation of the Selection Sort algorithm.
 */
public class SelectionSort {

    /**
     * The main method to test the selection sort implementation.
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {

        int[] arr = {64, 25, 12, 22, 11};

        System.out.println("Original array:");
        printArray(arr);

        // Sort the array using selection sort
        sortArray(arr);

        System.out.println("\nSorted array:");
        printArray(arr);
    }

    /**
     * Sorts an array of integers using the selection sort algorithm.
     * The algorithm repeatedly finds the minimum element from the unsorted part
     * and puts it at the beginning.
     * @param arr The array to be sorted.
     */
    static void sortArray(int[] arr) {
        int n = arr.length;
        // One by one move the boundary of the unsorted subarray
        for (int i = 0; i < n - 1; i++) {
            // Find the minimum element in the unsorted array
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }

            // Swap the found minimum element with the first element
            // of the unsorted part.
            int temp = arr[i];
            arr[i] = arr[minIdx];
            arr[minIdx] = temp;
        }
    }

    /**
     * A utility function to print the elements of an array.
     * @param arr The array to be printed.
     */
    static void printArray(int[] arr) {
        for (int data : arr) {
            System.out.print(data + " ");
        }
    }
}
