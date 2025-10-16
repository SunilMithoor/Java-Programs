package strings;

import java.util.stream.IntStream;

public class RepeatPattern {

    static void main() {
        String input = "abcd";
        System.out.println("Result-->" +
                repeatPatternBruteForce(input));

        System.out.println("Result-->" +
                repeatPatternStream(input));
    }

    static String repeatPatternBruteForce(String input) {

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            for (int j = 0; j <= i; j++) {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    static String repeatPatternStream(String input) {
        return IntStream.range(0, input.length())
                .mapToObj(i -> String.valueOf(input.charAt(i)).repeat(i + 1))
                .reduce("", String::concat);
    }
}
