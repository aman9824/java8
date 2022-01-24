package FunctionalProgramming;

import java.util.Random;
import java.util.function.Supplier;

public class _Supplier {
    public static void main(String[] args) {
        // Supplier get method
        System.out.println(randomInt.get());
    }

    // Supplier Functional Interface
    static Supplier<Integer> randomInt = () -> {return new Random().nextInt(1000);};
}
