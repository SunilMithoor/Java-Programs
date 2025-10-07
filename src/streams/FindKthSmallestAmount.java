package streams;

import java.util.Arrays;

public class FindKthSmallestAmount {
    public static void main(String[] args) {
        int[] array = {4, 2, 7, 1, 5, 3, 6};
        int k = 3; // Find the 3rd smallest element

        int smallest = Arrays.stream(array)
                .sorted()
                .skip(k - 1)
                .findFirst()
                .orElse(-1);

        System.out.println("FindKthSmallestAmount-->" + smallest);
    }
}

