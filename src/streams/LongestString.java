package streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class LongestString {
    public static void main(String[] args) {

        List<String> input = Arrays
                .asList("apple", "banana", "cherry", "date", "grapefruit");

        Optional<String> output = input.stream()
                .max(Comparator.comparing(String::length));

        System.out.println("LongestString-->" + output);
    }
}
