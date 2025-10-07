package streams;

import java.util.Arrays;
import java.util.List;

public class ListIntersection {

    public static void main(String[] args) {

        List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> list2 = Arrays.asList(3, 4, 5, 6, 7);

        List<Integer> output = list1.stream()
                .filter(list2::contains)
                .toList();

        System.out.println("ListIntersection-->" + output);
    }
}
