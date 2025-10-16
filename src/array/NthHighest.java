package array;

import java.util.Arrays;
import java.util.Comparator;

public class NthHighest {

    static void main() {
        int[] input = {5, 22, 8, 4, 9, 10, 23, 34, 78, 23, 4, 6, 9, 23};

        int[] result = nthHighestBruteForce(input, 4);
        System.out.println("Result-->" + Arrays.toString(result));
        int data = result[result.length - 1];
        System.out.println("Result-->" + data);
        System.out.println("Result-->" +
                nthHighestStream(input, 4));
    }

    static int[] nthHighestBruteForce(int[] input, int n) {
        if (input == null || input.length < n)
            throw new IllegalArgumentException("Array must have " + n + "elements");

        // --- Remove duplicates manually ---
        int[] temp = new int[input.length];
        int uniquecount = 0;
        for (int i = 0; i < input.length; i++) {
            boolean isDuplicate = false;
            for (int j = 0; j < i; j++) {
                if (input[i] == input[j]) {
                    isDuplicate = true;
                    break;
                }
            }
            if (!isDuplicate) {
                temp[uniquecount++] = input[i];
            }
        }


        int[] arr = Arrays.copyOf(temp, uniquecount);
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            int max = Integer.MIN_VALUE;
            int maxIndex = -1;

            for (int j = 0; j < arr.length; j++) {
                if (arr[j] > max) {
                    max = arr[j];
                    maxIndex = j;
                }
            }
            result[i] = max;
            arr[maxIndex] = Integer.MIN_VALUE;
        }

        return result;
    }

    static int nthHighestStream(int[] input, int n) {

        return Arrays.stream(input).boxed()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(n - 1)
                .findFirst()
                .orElse(-1);

    }
}
