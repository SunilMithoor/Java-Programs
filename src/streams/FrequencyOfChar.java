package streams;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FrequencyOfChar {

    public static void main(String[] args) {

        String input = "sample data";

        Map<String, Long> output = Arrays.stream(input.split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println("FrequencyOfChar-->" + output);

    }
}
