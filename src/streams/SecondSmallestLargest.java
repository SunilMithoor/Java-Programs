package streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SecondSmallestLargest {
    public static void main(String[] args) {
        List<Integer> input = Arrays.asList(1, 17, 54, 14, 14, 33, 45, -11);

        Integer secondSmallest = input.stream()
                .distinct()
                .sorted()
                .skip(1)
                .findFirst()
                .orElse(null);

        System.out.println("Second smallest-->" + secondSmallest);

        Integer secondLargest = input.stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst()
                .orElse(null);

        System.out.println("Second largest-->" + secondLargest);
    }
}
