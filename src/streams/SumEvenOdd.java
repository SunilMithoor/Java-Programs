package streams;

import java.util.Arrays;
import java.util.List;

public class SumEvenOdd {
    public static void main(String[] args) {

        List<Integer> input = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        int even = input.stream()
                .mapToInt(Integer::intValue)
                .filter(x -> x % 2 == 0)
                .sum();
        System.out.println("sum even-->" + even);
        int odd = input.stream()
                .mapToInt(Integer::intValue)
                .filter(x -> x % 2 != 0)
                .sum();
        System.out.println("sum odd-->" + odd);

        int even1 = input.stream()
                .filter(x -> x % 2 == 0)
                .reduce(0, Integer::sum);
        System.out.println("sum even-->" + even1);

        int odd1 = input.stream()
                .filter(x -> x % 2 != 0)
                .reduce(0, Integer::sum);
        System.out.println("sum odd-->" + odd1);
    }
}

