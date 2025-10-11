package strings;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StringReverse {

    //    Reverse a string without using built-in functions.
//    Example: "hello" → "olleh"
    public static void main(String[] args) {
        String input = "hello world";
        System.out.println("Reverse string-->" + reverseStringWithoutBuiltIn(input));
        System.out.println("Reverse string-->" + reverseStringBuilder(input));
        System.out.println("Reverse string-->" + reverseStringBuffer(input));
        System.out.println("Reverse string-->" + reverseStringTwoPointer(input));
        System.out.println("Reverse string-->" + reverseRecursive(input));
        System.out.println("Reverse string-->" + reverseStream(input));
    }

    static String reverseStringWithoutBuiltIn(String input) {
        char[] c = input.toCharArray();
        String rev = "";
        for (int i = c.length - 1; i >= 0; i--) {
            rev = rev + c[i];
        }
        return rev;
    }

    static String reverseStringBuilder(String input) {
        StringBuilder sb = new StringBuilder();
        for (int i = input.length() - 1; i >= 0; i--) {
            sb.append(input.charAt(i));
        }
        return sb.toString();
    }

    static String reverseStringBuffer(String input) {
        StringBuffer sb = new StringBuffer();
        for (int i = input.length() - 1; i >= 0; i--) {
            sb.append(input.charAt(i));
        }
        return sb.toString();
    }

    static String reverseStringTwoPointer(String input) {
        int left = 0;
        int right = input.length() - 1;
        char[] str = input.toCharArray();

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
        return String.valueOf(str);
    }

    static String reverseRecursive(String input) {
        if (input.isEmpty()) {
            return input;
        }
        return reverseRecursive(input.substring(1)) + input.charAt(0);
    }

    static Object reverseStream(String input) {
        return IntStream.range(0, input.length())
                .mapToObj(i -> String.valueOf(input.charAt(input.length() - i - 1)))
                .collect(Collectors.joining());
    }


}
