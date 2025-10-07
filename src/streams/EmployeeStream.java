package streams;

import java.util.*;
import java.util.stream.Collectors;

public class EmployeeStream {

    public static void main(String[] args) {

        List<Employee> input = Arrays.asList(
                new Employee(1, "red", "HR", 40000),
                new Employee(2, "green", "HR", 80000),
                new Employee(3, "black", "IT", 60000),
                new Employee(4, "blue", "IT", 80000),
                new Employee(5, "white", "HR", 70000),
                new Employee(6, "purple", "SALES", 30000),
                new Employee(7, "pink", "SALES", 50000),
                new Employee(8, "darkblue", "IT", 70000),
                new Employee(9, "violet", "IT", 70000),
                new Employee(10, "cyan", "SALES", 70000)
        );


//        Optional<Employee> secondHighest = input.stream()
//                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed()) // sort by salary desc
//                .skip(1) // skip highest
//                .findFirst(); // get 2nd highest
//
//        if (secondHighest.isPresent()) {
//            System.out.println("Second highest salary employee: " + secondHighest.get().name);
//        } else {
//            System.out.println("Not enough employees to find second highest.");
//        }


        Map<String, List<Employee>> output = input.stream()
                .collect(Collectors.groupingBy(Employee::getDept,
                        Collectors.collectingAndThen(Collectors.toList(), emplist ->
                                {
                                    List<Double> salaries = emplist.stream()
                                            .map(Employee::getSalary)
                                            .distinct()
                                            .sorted(Comparator.reverseOrder())
                                            .toList();

                                    if (salaries.size() < 2) return Collections.emptyList();
                                    return emplist.stream()
                                            .filter(emp -> emp.salary == salaries.get(1))
                                            .toList();

                                }
                        )));

        output.forEach((dept,empList)->
        {
            empList.forEach(emp -> System.out.println("Dept-->" +emp.dept +",Name-->" +emp.name +",Salary-->" +emp.salary));
        });

    }


    static class Employee {
        private int id;
        private String name;
        private String dept;
        private double salary;

        public Employee(int id, String name, String dept, double salary) {
            this.id = id;
            this.name = name;
            this.dept = dept;
            this.salary = salary;
        }

        public double getSalary() {
            return salary;
        }

        public String getName() {
            return name;
        }

        public String getDept() {
            return dept;
        }
    }
}
