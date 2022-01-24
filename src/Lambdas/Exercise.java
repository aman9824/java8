package Lambdas;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Exercise {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("Charles", "Dickens", 60),
                new Person("Lewis", "Carroll", 60),
                new Person("Thomas", "Carolyne", 60),
                new Person("Charlotte", "Bronte", 60),
                new Person("Matthew", "Arnold", 60)
        );

        // Sort list by last name
        people = people.stream().sorted(Comparator.comparing(Person::getlName)).collect(Collectors.toList());

        // Print Names in the sorted list
        people.forEach(System.out::println);

        // Match last name which start with C
        people.forEach(p -> System.out.println(p.getlName().startsWith("C")? p.getlName() : ""));
    }
}
