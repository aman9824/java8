package FunctionalProgramming;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
    public static void main (String[] args) {
        List<Person> people = List.of(
                new Person("Aman", "Male"),
                new Person("Umang", "Male"),
                new Person("Mahir", "Male"),
                new Person("Rima", "Female"),
                new Person("Dhaval", "Male"),
                new Person("Dhara", "Female")
        );

        // Imperative Approach

        System.out.println("Imperative Approach");

        List<Person> females = new ArrayList<>();

        for(Person person: people) {
            if(person.getGender().equals("Female")) {
                females.add(person);
            }
        }

        for(Person female: females) {
            System.out.println(female.toString());
        }

        // Declarative Approach

        System.out.print("Declarative Approach \n");

        // Predicate Functional Interface -> returns boolean value (True i.e. False)
        Predicate<Person> personPredicate = person -> person.getGender().equals("Female");

        // Use of Stream Filter
        people.stream()
                .filter(personPredicate)
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }

    static class Person {
        private final String name;
        private final String gender;

        Person(String name, String gender) {
            this.name = name;
            this.gender = gender;
        }

        public String getName() {
            return name;
        }

        public String getGender() {
            return gender;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", gender='" + gender + '\'' +
                    '}';
        }
    }
}
