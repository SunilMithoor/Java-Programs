package programs;

public class Plaindrome {

    public static void main(String[] args) {
        boolean ispalin = checkPalindrome("aba");
        System.out.println("Palindrome-->" + ispalin);

        boolean isNopalin = checkPalindrome(121);
        System.out.println("Palindrome-->" + isNopalin);
    }

    static Boolean checkPalindrome(String input) {
        char[] c = input.toCharArray();
        StringBuilder rev = new StringBuilder();
        for (int i = c.length - 1; i >= 0; i--) {
            rev.append(c[i]);
        }
        
        return input.contentEquals(rev);
    }

    public static Boolean checkPalindrome(int num) {
        int reversed = 0;

        while (num != 0) {
            int digit = num % 10;
            reversed = reversed * 10 + digit;
            num = num / 10;
        }
        return num == reversed;
    }

}


