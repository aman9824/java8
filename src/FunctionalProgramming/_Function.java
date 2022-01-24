package FunctionalProgramming;

import java.util.function.BiFunction;
import java.util.function.Function;

public class _Function {
    public static void main(String[] args) {
        int i = increment(10);
        System.out.println(i);

        // Increment By Function
        System.out.println(incrementByFunction.apply(i));

        // Function Chaining
        Function<Integer, Integer> temp = incrementByFunction.andThen(multiplyByFunction);
        System.out.println(temp.apply(i));

        // BiFunction Multiply
        System.out.println(multiplyTwoNumbers.apply(100, 4));
    }

    // Function (Functional Programing)
    static Function<Integer, Integer> incrementByFunction = number -> ++number;

    static Function<Integer, Integer> multiplyByFunction = number -> number * 10;

    // BiFunction: Multiply Two Numbers
    static BiFunction<Integer, Integer, Integer> multiplyTwoNumbers = (i, j) -> i * j;

    // Normal Function
    static int increment (int num) {
        return ++num;
    }
}
