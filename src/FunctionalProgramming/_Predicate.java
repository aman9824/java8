package FunctionalProgramming;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class _Predicate {
    public static void main(String[] args) {
        System.out.println(isPhoneNumberValid("4168282451"));

        // Predicate
        System.out.println(isPhoneNumberValidPredicate.test("4168282451"));

        // BiPredicate
        System.out.println(areTwoNumberSame.test("4168282451", "4168282451"));

        // Using AND / OR condition with Predicate
        System.out.println(
                "Phone Numbers Valid and contains 5 = " + isPhoneNumberValidPredicate.and(containsFive).test("4168282451")
        );
    }

    // Predicate
    static Predicate<String> isPhoneNumberValidPredicate = phoneNumber -> phoneNumber.startsWith("41") && phoneNumber.length() == 10;

    static Predicate<String> containsFive = phoneNumber -> phoneNumber.contains("5");

    // BiPredicate
    static BiPredicate<String, String> areTwoNumberSame = (phoneNumber1, phoneNumber2) -> phoneNumber1.equals(phoneNumber2);

    static boolean isPhoneNumberValid (String phoneNumber) {
        return phoneNumber.startsWith("41") && phoneNumber.length() == 10;
    }
}
