package array;

import java.util.Arrays;
import java.util.Comparator;

public class SecondHighest {

    static void main() {
        int[] input = {5, 22, 8, 4, 9, 10};
        System.out.println("Reverse string-->" +
                secondHighestBruteForce(input));
        System.out.println("Reverse string-->" +
                secondHighestStream(input));
    }

    static int secondHighestBruteForce(int[] input) {

        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;

        for (int num : input) {
            if (num > first) {
                second = first;
                first = num;
            } else if (num > second && num < first) {
                second = num;
            }
        }

        return second;
    }

    static int secondHighestStream(int[] input) {
        return Arrays.stream(input)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst()
                .orElse(null);
    }
}
