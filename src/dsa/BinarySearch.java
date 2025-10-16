package dsa;

/**
 * This class demonstrates the implementation of Binary Search, both iteratively and recursively.
 */
public class BinarySearch {

    /**
     * The main method to test the binary search implementations.
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        // Sorted array for binary search
        int[] arr = {2, 3, 4, 10, 40};
        // Element to be searched
        int x = 10;

        // Calling the iterative binary search method
        System.out.println("Result of iterative search-->" + searchIndex(arr, x));
        // Calling the recursive binary search method
        System.out.println("Result of recursive search-->" + searchIndexRecursive(arr, x, 0, arr.length - 1));
    }

    /**
     * Performs an iterative binary search to find the index of a target element in a sorted array.
     * @param arr The sorted array to be searched.
     * @param target The element to be searched for.
     * @return The index of the target element if found, otherwise -1.
     */
    static int searchIndex(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        // Loop until the left pointer is greater than the right pointer
        while (left <= right) {
            // Calculate the middle index to avoid potential overflow
            int mid = left + (right - left) / 2;

            // If the middle element is the target, return its index
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                // If the target is greater, ignore the left half
                left = mid + 1;
            } else {
                // If the target is smaller, ignore the right half
                right = mid - 1;
            }
        }
        // Return -1 if the element is not found
        return -1;
    }

    /**
     * Performs a recursive binary search to find the index of a target element in a sorted array.
     * @param arr The sorted array to be searched.
     * @param target The element to be searched for.
     * @param left The starting index of the search range.
     * @param right The ending index of the search range.
     * @return The index of the target element if found, otherwise -1.
     */
    static int searchIndexRecursive(int[] arr, int target, int left, int right) {
        // Base case: If the search range is invalid, the element is not present
        if (left <= right) {
            // Calculate the middle index
            int mid = left + (right - left) / 2;

            // If the middle element is the target, return its index
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                // If the target is greater, search in the right half
                return searchIndexRecursive(arr, target, mid + 1, right);
            } else {
                // If the target is smaller, search in the left half
                return searchIndexRecursive(arr, target, left, mid - 1);
            }
        }
        // Return -1 if the element is not found
        return -1;
    }
}
