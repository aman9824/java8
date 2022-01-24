import Lambdas.Person;

import java.util.Optional;

public class Optionals {

    public static void main(String[] args) {
        // 3 Ways to create Optional
        Optional<Integer> possible = Optional.empty();
        Optional<Integer> possible1 = Optional.of(5);
        Optional<Integer> possible2 = Optional.ofNullable(null);
        Optional<Integer> possible3 = Optional.ofNullable(5);

        // Do something If Optional value is present
        possible1.ifPresent(System.out::println);

        //Assume this value has returned from a method
        Optional<Person> companyOptional = Optional.of(new Person("Lewis", "Carroll", 60)); // Nullable can be used in case we need to throw IllegalStateException
        Optional<Person> companyOptional1 = Optional.empty();

        //Now check optional; if value is present then return it,
        //else create a new Company object and return it
        Person company = companyOptional.orElse(new Person());

        //OR you can throw an exception as well
        Person person1 = companyOptional.orElseThrow(IllegalStateException::new);

        // Rejecting certain values using the filter method
        companyOptional.filter(p -> p.getlName().startsWith("C")).ifPresent((s) -> System.out.print("Company Optional: " + s));
        companyOptional1.filter(p -> p.getlName().startsWith("C")).ifPresent((s) -> System.out.print("Company Optional1: " + s));
    }
}
