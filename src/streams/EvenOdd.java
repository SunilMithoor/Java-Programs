package streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EvenOdd {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

        Map<Boolean, List<Integer>> output = numbers.stream()
                .collect(Collectors.partitioningBy(x -> x % 2 == 0));

        System.out.println("Even-->" + output.get(true));
        System.out.println("Odd-->" + output.get(false));


        Map<String, List<Integer>> output1 = numbers.stream()
                .collect(Collectors.groupingBy(x -> x % 2 == 0 ? "Even" : "Odd"));

        System.out.println("Result-->" + output1);
    }
}
