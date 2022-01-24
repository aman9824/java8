package FunctionalProgramming;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class _Consumer {
    public static void main(String[] args) {
        Customer c1 = new Customer("Aman", "9409665444");
        Customer c2 = new Customer("Umang", "9409665444");

        // Consumer Functional Interface
        greetCustomerConsumer.accept(new Customer("Aman", "9409665444"));

        // BiConsumer Functional Interface
        greetTwoCustomer.accept(c1, c2);
    }

    // Consumer Functional Interface
    static Consumer<Customer> greetCustomerConsumer = c -> System.out.println("Hello " + c.customerName + ", thanks for registering phone number " + c.phoneNumber);

    // BiConsumer Functional Interface
    static BiConsumer<Customer, Customer> greetTwoCustomer = (c1, c2) -> {
        System.out.println("Hello " + c1.customerName + ", thanks for registering phone number " + c1.phoneNumber);
        System.out.println("Hello " + c2.customerName + ", thanks for registering phone number " + c2.phoneNumber);
    };

    static void  greetCustomer (Customer c) {
        System.out.println("Hello " + c.customerName + ", thanks for registering phone number " + c.phoneNumber);
    }

    static class Customer {
        private final String customerName;
        private final String phoneNumber;

        public Customer(String customerName, String phoneNumber) {
            this.customerName = customerName;
            this.phoneNumber = phoneNumber;
        }
    }
}
