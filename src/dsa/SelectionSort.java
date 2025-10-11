package dsa;

public class SelectionSort {

    public static void main(String[] args) {

        int[] arr = {64, 25, 12, 22, 11};

        for (int data : arr) {
            System.out.println("Original arr-->" + data);
        }

        sortArray(arr);

        for (int data : arr) {
            System.out.println("Sorted arr-->" + data);
        }

    }

    static void sortArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minIdx = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] > arr[minIdx]) {
                    minIdx = j;
                }
            }

            int temp = arr[i];
            arr[i] = arr[minIdx];
            arr[minIdx] = temp;
        }
    }
}
