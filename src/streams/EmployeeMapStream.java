//package streams;
//
//import java.util.Comparator;
//import java.util.HashMap;
//import java.util.LinkedHashMap;
//import java.util.Map;
//import java.util.stream.Collectors;
//
//public class EmployeeMapStream {
//
//    public static void main(String[] args) {
//
//        Map<Integer, Employee> map = new HashMap<>();
//        map.put(1, new Employee("Alice", 50000));
//        map.put(2, new Employee("Bob", 70000));
//        map.put(3, new Employee("Charlie", 40000));
//
//        Map<Integer, Employee> output = map.entrySet().stream()
//                .sorted(Comparator.comparing(Map.Entry::getValue).reversed())
//                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
//                        (e1, e2) -> e1, LinkedHashMap::new));
//
//        System.out.println("output-->" + output);
//
//        Map<Integer, String> asc = map.entrySet().stream()
//                .sorted(Map.Entry.comparingB()) // ascending by default
//                .collect(Collectors.toMap(
//                        Map.Entry::getKey, Map.Entry::getValue,
//                        (e1, e2) -> e1, LinkedHashMap::new));
//
//        System.out.println("Ascending by Value: " + asc);
//
//        // Descending order by value
//        Map<Integer, String> desc = map.entrySet().stream()
//                .sorted(Map.Entry.<Integer, String>comparingByValue().reversed())
//                .collect(Collectors.toMap(
//                        Map.Entry::getKey, Map.Entry::getValue,
//                        (e1, e2) -> e1, LinkedHashMap::new));
//
//        System.out.println("Descending by Value: " + desc);
//
//    }
//
//    static class Employee {
//        String name;
//        int salary;
//
//        Employee(String n, int s) {
//            name = n;
//            salary = s;
//        }
//
//        public int getSalary() {
//            return salary;
//        }
//
//        public String toString() {
//            return name + "=" + salary;
//        }
//    }
//}
