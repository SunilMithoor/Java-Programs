package array;

import java.util.Arrays;
import java.util.Comparator;

public class ThirdHighest {

    static void main() {
        int[] input = {5, 22, 8, 4, 9, 10, 34};
        System.out.println("Result-->" +
                thirdHighestBruteForce(input));
        System.out.println("Result-->" +
                thirdHighestStream(input));
    }

    static int thirdHighestBruteForce(int[] input) {

        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        int third = Integer.MIN_VALUE;

        for (int num : input) {
            if (num > first) {
                third = second;
                second = first;
                first = num;
            } else if (num > second && num < first) {
                third = second;
                second = num;
            } else if (num > third && num < second) {
                third = num;
            }
        }

        return third;
    }

    static int thirdHighestStream(int[] input) {

        return Arrays.stream(input).boxed()
                .sorted(Comparator.reverseOrder())
                .skip(2)
                .findFirst()
                .orElse(-1);
    }
}
