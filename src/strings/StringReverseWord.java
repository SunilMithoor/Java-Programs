package strings;

import java.util.Arrays;
import java.util.stream.Collectors;

public class StringReverseWord {

    static String regex = "[,\\s\\.\\*]";

    static void main() {
        String input = "java is*a programming.language";
        System.out.println("Reverse string-->" + reverseWord(input));
        System.out.println("Reverse string-->" + reverseWordStream(input));
        System.out.println("Reverse string-->" + reverseWordTwoPointer(input));
        System.out.println("Reverse string-->" + reverseChar(input));
        System.out.println("Reverse string-->" + reverseCharStream(input));
        System.out.println("Reverse string-->" + reverseCharTwoPointer(input));
    }

    static String reverseWord(String input) {
        String[] inputData = input.split(regex);
        StringBuilder sb = new StringBuilder();
        for (int i = inputData.length - 1; i >= 0; i--) {
            sb.append(inputData[i]).append(" ");
        }
        return sb.toString().trim();
    }

    static String reverseWordStream(String input) {

//        return Arrays.stream(input.split(regex))
//                .collect(Collectors.collectingAndThen(
//                        Collectors.toList(),
//                        list -> {
//                            Collections.reverse(list);
//                            return String.join(" ", list);
//                        }
//                ));


        return Arrays.stream(input.split(regex))
                .reduce("", (a, b) -> b + " " + a).trim();
    }

    static String reverseWordTwoPointer(String input) {
        String[] inputData = input.split(regex);
        StringBuilder sb = new StringBuilder();
        int left = 0;
        int right = inputData.length - 1;
        while (left <= right) {
            if (inputData[left].equals(" ")) {
                left++;
            } else if (inputData[right].equals(" ")) {
                right--;
            } else {
                String temp = inputData[left];
                inputData[left] = inputData[right];
                inputData[right] = temp;
                left++;
                right--;
            }
        }
        for (String data : inputData) {
            sb.append(data).append(" ");
        }

        return sb.toString();

    }


    static String reverseChar(String input) {
        String[] inputData = input.split(regex);
        StringBuilder sb = new StringBuilder();
        for (String data : inputData) {
            for (int j = data.length() - 1; j >= 0; j--) {
                sb.append(data.charAt(j));
            }
            sb.append(" ");
        }
        return sb.toString().trim();
    }

    static String reverseCharStream(String input) {
        return Arrays.stream(input.split(regex))
                .map(word -> word.chars()
                        .mapToObj(c -> String.valueOf((char) c))
                        .reduce("", (a, b) -> b + a))
                .collect(Collectors.joining(" "));

    }

    static String reverseCharTwoPointer(String input) {
        String[] inputData = input.split(regex);
        StringBuilder sb = new StringBuilder();
        for (String data : inputData) {
            char[] str = data.toCharArray();
            int left = 0;
            int right = str.length - 1;
            while (left <= right) {
                if (str[left] == ' ') {
                    left++;
                } else if (str[right] == ' ') {
                    right--;
                } else {
                    char temp = str[left];
                    str[left] = str[right];
                    str[right] = temp;
                    left++;
                    right--;
                }
            }
            sb.append(str).append(" ");
        }
        return sb.toString();
    }
}
