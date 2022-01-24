package FunctionalProgramming;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

public class _BinaryOperator {
    public static void main(String[] args) {

        List<Salary> salaryList = new ArrayList<>();
        salaryList.add(new Salary(120000, "IT"));
        salaryList.add(new Salary(80000, "IT"));
        salaryList.add(new Salary(120000, "IT"));
        salaryList.add(new Salary(110000, "Account"));
        salaryList.add(new Salary(60000, "Account"));

        Comparator<Salary> salaryComparator = Comparator.comparing(Salary::getVal);

        // Stream -> Collect, Collectors
        // Max and Min Binary Operator
        Map<String, Optional<Salary>> salaryByDept = salaryList.stream().collect(Collectors.groupingBy(Salary::getDepartment, Collectors.reducing(BinaryOperator.maxBy(salaryComparator))));

        salaryByDept.forEach((dept,sal) -> {
            System.out.println(dept);
            System.out.println(sal.toString());
        });

        // Binary Operator
        System.out.println(sum.apply(1, 2));

        // Binary Operator Chaining
        BiFunction<Integer,Integer, Integer> res = sum.andThen(multiply);
        System.out.println(res.apply(20, 30));

    }

    static BinaryOperator<Integer> sum = (arg1, arg2) -> arg1 + arg2;

    static Function<Integer, Integer> multiply = arg1 -> arg1 * 10;

    static class Salary {
        private int val;
        private String department;

        public Salary(int val, String department) {
            this.val = val;
            this.department = department;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public String getDepartment() {
            return department;
        }

        public void setDepartment(String department) {
            this.department = department;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "Salary=" + val +
                    ", department='" + department + '\'' +
                    '}';
        }
    }
}
