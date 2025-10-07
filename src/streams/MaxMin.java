package streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class MaxMin {
    public static void main(String[] args) {
        List<Integer> input = Arrays.asList(1, 17, 54, 14, 14, 33, 45, -11);

        Optional<Integer> max = input.stream()
                .max(Integer::compare);
        System.out.println("Max-->" + max);

        Optional<Integer> min = input.stream()
                .min(Integer::compare);
        System.out.println("Min-->" + min);
    }
}
