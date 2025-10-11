package programs;

public class FibonacciSeries {
    public static void main(String[] args) {

        fibonnaci(10);
    }

    static void fibonnaci(int num) {
        int num1 = 0, num2 = 1;
        for (int i = 2; i < num; i++) {
            System.out.print(num1 + " ");
            int num3 = num1 + num2;
            num1 = num2;
            num2 = num3;
        }
    }
}
