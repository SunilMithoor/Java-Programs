package streams;

import java.util.Arrays;
import java.util.List;

public class AverageAge {

    public static void main(String[] args) {
        List<Person> input = Arrays.asList(
                new Person("Alice", 26),
                new Person("Bob", 30),
                new Person("Charlie", 36)
        );

        double output = input.stream()
                .mapToInt(Person::getAge)
                .average()
                .orElse(0);

        System.out.println("AverageAge-->" + output);

    }

    static class Person {
        private final String name;
        private final int age;

        public Person(String name, int age) {
            this.age = age;
            this.name = name;
        }

        public int getAge() {
            return age;
        }
    }
}
