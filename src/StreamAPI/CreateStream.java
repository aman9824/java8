package StreamAPI;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CreateStream {

    public static void main(String[] args) {

        // Stream of a fixed number of integers.
        Stream<Integer> stream = Stream.of(1,2,3,4,5,6,7,8,9);
        stream.forEach(p -> System.out.println(p));

        // Stream from the array
        Stream<Integer> stream1 = Stream.of( new Integer[]{1,2,3,4,5,6,7,8,9} );
        stream1.forEach(p -> System.out.println(p));

        // Stream from list
        List<Integer> list = new ArrayList<>();
        for(int i = 1; i< 10; i++)
            list.add(i);
        Stream<Integer> stream2 = list.stream();
        stream2.forEach(p -> System.out.println(p));

        // Stream.generate() or Stream.iterate()
        Stream<Integer> randomNumbers = Stream.generate(() -> (new Random()).nextInt(100));
        randomNumbers.limit(20).forEach(System.out::println);

        // Stream of String chars or tokens
        IntStream stream3 = "12345_abcdefg".chars();
        stream3.forEach(p -> System.out.println(p));
        //OR
        Stream<String> stream4 = Stream.of("A$B$C".split("\\$"));
        stream4.forEach(p -> System.out.println(p));
    }
}
