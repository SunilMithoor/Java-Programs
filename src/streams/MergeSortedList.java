package streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class MergeSortedList {
    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(1, 3, 5, 7, 9, 3, 9, 4, 2);
        List<Integer> list2 = Arrays.asList(2, 4, 6, 8, 10, 0, 4, 6, 1);

        List<Integer> output = Stream.concat(list1.stream(), list2.stream())
                .distinct()
                .sorted()
                .toList();

        System.out.println("MergeSortedList-->" + output);
    }
}
