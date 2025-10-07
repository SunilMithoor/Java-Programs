package streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TransactionSumByDate {

    public static void main(String[] args) {

        List<Transaction> transactions = Arrays.asList(
                new Transaction("2022-01-01", 100),
                new Transaction("2022-01-01", 200),
                new Transaction("2022-01-02", 300),
                new Transaction("2022-01-02", 400),
                new Transaction("2022-01-03", 500)
        );

        Map<String, Integer> output = transactions.stream()
                .collect(Collectors.groupingBy(Transaction::date,
                        Collectors.summingInt(Transaction::amount)));

        System.out.println("TransactionSumByDate->" + output);

        for (Map.Entry<String, Integer> data : output.entrySet()) {
            System.out.println("Key->" + data.getKey() + " Value->" + data.getValue());
        }

    }

    record Transaction(String date, int amount) {
    }

}
