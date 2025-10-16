package dsa;

public class InsertionSort {

    public static void main(String[] args) {

        // Initialize an integer array with some unsorted values.
        int[] arr = {64, 25, 12, 22, 11};
        System.out.println("Original array:");
        // Print the original unsorted array.
        printArray(arr);

        // Sort the array using the insertion sort algorithm.
        sortArray(arr);

        System.out.println("\nSorted array:");
        // Print the sorted array.
        printArray(arr);
    }

    /**
     * Sorts an array of integers in ascending order using the insertion sort algorithm.
     *
     * @param arr The array to be sorted.
     */
    static void sortArray(int[] arr) {

        // Iterate over the array from the second element to the end.
        for (int i = 1; i < arr.length; i++) {
            // The 'key' is the element to be positioned correctly in the sorted subarray.
            int key = arr[i];
            // 'j' is the index of the last element in the sorted subarray.
            int j = i - 1;

            /*
             * Move elements of the sorted subarray (arr[0..i-1]) that are greater than the key
             * to one position ahead of their current position.
             * This loop shifts elements to the right to make space for the key.
             */
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            // Place the key at its correct position in the sorted subarray.
            arr[j + 1] = key;
        }
    }

    /**
     * A utility function to print the elements of an array.
     *
     * @param arr The array to be printed.
     */
    static void printArray(int[] arr) {
        for (int data : arr) {
            System.out.print(data + " ");
        }
    }
}
