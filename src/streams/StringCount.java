package streams;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StringCount {

    public static void main(String[] args) {

        List<String> words = Arrays.asList(
                "apple", "banana", "apple", "cherry", "banana", "apple");

        Map<String, Integer> countMap = new HashMap<>();

        for (String word : words) {
            countMap.put(word, countMap.getOrDefault(word, 0) + 1);
        }

        System.out.println(countMap);

    }


}

