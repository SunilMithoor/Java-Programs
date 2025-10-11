package programs;

public class PrimeNumber {

    public static void main(String[] args) {

        boolean prime = isPrime(9);
        System.out.println("Prime-->" + prime);
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
