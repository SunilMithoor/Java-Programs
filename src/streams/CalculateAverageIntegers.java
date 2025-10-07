package streams;


//1. Calculate average of integers using streams
//
//Write a Java program to calculate the average of a list of integers using streams.

import java.util.Arrays;
import java.util.List;

class CalculateAverageIntegers {

    public static void main(String[]  args)
    {
        List<Integer> input= Arrays.asList(1, 3, 6, 8, 10, 18, 36);

        double output=input.stream()
                .mapToDouble(Integer::doubleValue)
                .average()
                .orElse(0.0);

        System.out.println("Average-->" +output);
    }
}