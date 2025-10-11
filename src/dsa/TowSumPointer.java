package dsa;

import java.util.ArrayList;
import java.util.List;

public class TowSumPointer {

    public static void main(String[] args) {
        int[] arr = {1, 4, 6, 7, 9, 10};
        int target = 10;
        System.out.println("result-->" + twoSum(arr, target));
        System.out.println("result-->" + twoSumTwoPointer(arr, target));

    }

    static boolean twoSum(int[] arr, int target) {

        List<Integer> data = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == target) {
                    data.add(arr[i]);
                    data.add(arr[j]);

                    System.out.println("result-->" + data);
                    return true;
                }
            }
        }

        return false;
    }

    static boolean twoSumTwoPointer(int[] arr, int target) {

        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int sum = arr[left] + arr[right];
            if (sum == target) {
                System.out.println("result-->" + arr[left] + "," + arr[right]);
                return true;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        return false;

    }
}
