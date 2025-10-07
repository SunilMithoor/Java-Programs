package streams;

import java.util.Arrays;
import java.util.List;

public class ConvertStringUpperLower {

    public static void main(String[] args) {

        List<String> input= Arrays.asList("RED", "grEEn", "white", "Orange", "pink");

        List<String> output=input.stream()
                .map(String :: toUpperCase)
                .toList();

        System.out.println("List upper-->" +output);

        List<String> output1=input.stream()
                .map(String:: toLowerCase)
                .toList();

        System.out.println("List lower-->" +output1);

    }
}
