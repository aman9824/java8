package Lambdas;

import java.util.function.BiConsumer;

public class ExceptionHandling {
    public static void main(String[] args) {
        int [] someNum = {1,2,3,4,5};
        int key = 0;
        process(someNum, key++, wrapperLambda((v,k) -> System.out.println(v/k)));
        process(someNum, key, wrapperLambda((v,k) -> System.out.println(v/k)));
    }

    private static void process (int[] someNum, int key, BiConsumer<Integer, Integer> consumer) {
        for(int i : someNum)
            consumer.accept(i, key);
    }

    private static BiConsumer<Integer, Integer> wrapperLambda (BiConsumer<Integer, Integer> consumer) {
        return (v, k) -> {
            try {
                consumer.accept(v,k);
            } catch (ArithmeticException e) {
                System.out.println("Arithmetic Error happened");
            }
        };
    }
}
