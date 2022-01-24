package Lambdas;

import java.util.ArrayList;
import java.util.List;

public class main {

    public static void main(String[] args) {

        // Lambda Expression using interface
        MyLambda myLambdaFunction = () -> System.out.println("Hello World");
        myLambdaFunction.foo();

        // Another expression
        MyAdd addFunction = (int a, int b) -> a + b;
        System.out.println(addFunction.add(3,4));

        // For Each Lambda expression
        List<String> pointList = new ArrayList();
        pointList.add("1");
        pointList.add("2");
        pointList.forEach( p ->  { System.out.println(p); } );

        // Using function Interface
        @FunctionalInterface
        interface Operator<T> {
            T process(T a, T b);
        }
        //Using lambda expression
        Operator<Integer> addOperation = (a, b) -> a + b;
        //Using anonymous class
        Operator<Integer> addOperationAnonymous = new Operator<Integer>() {
            @Override
            public Integer process(Integer a, Integer b) {
                return a + b;
            }
        };
        System.out.println("Functional Interface: " + addOperation.process(3,4) + " Anonymous class: " + addOperationAnonymous.process(3, 4));

    }

}

interface MyLambda {
    void foo();
}

interface MyAdd {
    int add(int x, int y);
}