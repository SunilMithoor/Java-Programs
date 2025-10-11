package dsa;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 10, 40};
        int x = 10;

        System.out.println("Result-->" + searchIndex(arr, x));
        System.out.println("Result-->" + searchIndexRecursive(arr, x, 0, arr.length - 1));
    }

    static int searchIndex(int[] arr, int target) {

        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }

        }
        return -1;
    }

    static int searchIndexRecursive(int[] arr, int target, int left, int right) {

        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                return searchIndexRecursive(arr, target, mid + 1, right);
            } else {
                return searchIndexRecursive(arr, target, left, right - 1);
            }
        }
        return -1;
    }
}
