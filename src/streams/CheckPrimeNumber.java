package streams;

import java.util.Arrays;
import java.util.List;

public class CheckPrimeNumber {

    public static void main(String[] args) {

        List<Integer> input = Arrays.asList(1, 2, 4, 6, 8, 10, 11, 12, 13, 14, 15);

        List<Integer> output = input.stream()
                .filter(CheckPrimeNumber::isPrime)
                .toList();

        System.out.println("Prime no-->" + output);
    }

    static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}

