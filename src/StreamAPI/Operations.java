package StreamAPI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Operations {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        for(int i = 1; i< 10; i++)
            list.add(i);
        Stream<Integer> streamList = list.stream();

        // Collect Stream elements to a List
        List<Integer> evenNumbersList = streamList.filter(i -> i%2 == 0).collect(Collectors.toList());
        streamList.close();
        Stream<Integer> stream1 = list.stream();

        // Collect Stream elements to an Array
        Integer[] evenNumbersArr = stream1.filter(i -> i%2 == 0).toArray(Integer[]::new);
        System.out.print(evenNumbersList);
        for (Integer i: evenNumbersArr)
            System.out.println(i);
        stream1.close();

        /********************** Stream Operations ************************/

        List<String> memberNames = new ArrayList<>();
        memberNames.add("Amitabh");
        memberNames.add("Shekhar");
        memberNames.add("Aman");
        memberNames.add("Rahul");
        memberNames.add("Shahrukh");
        memberNames.add("Salman");
        memberNames.add("Yana");
        memberNames.add("Lokesh");

        /************** Intermediate Operations **************/

        // Filter
        memberNames.stream().filter((s) -> s.startsWith("A")).forEach(System.out::println);

        // Map
        memberNames.stream().filter((s) -> s.startsWith("A")).map(String::toUpperCase).forEach(System.out::println);

        // Sorted
        memberNames.stream().sorted().map(String::toUpperCase).forEach(System.out::println);

        /************** Terminal operations **************/

        // For Each
        memberNames.forEach(System.out::println);

        // Collect
        List<String> memNamesInUppercase = memberNames.stream().sorted().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(memNamesInUppercase);

        // Match
        boolean matchedResult = memberNames.stream().anyMatch((s) -> s.startsWith("A"));
        System.out.println(matchedResult);     //true

        matchedResult = memberNames.stream().allMatch((s) -> s.startsWith("A"));
        System.out.println(matchedResult);     //false

        matchedResult = memberNames.stream().noneMatch((s) -> s.startsWith("A"));
        System.out.println(matchedResult);     //false

        // Count
        long totalMatched = memberNames.stream().filter((s) -> s.startsWith("A")).count();
        System.out.println(totalMatched);     //2

        // Reduce
        Optional<String> reduced = memberNames.stream().reduce((s1,s2) -> s1 + "#" + s2);
        reduced.ifPresent(System.out::println);

        /************** Short-circuit Operations **************/

        // Any Match: anyMatch() will return true once a condition passed as predicate satisfies. Once a matching value is found, no more elements will be processed in the stream.
        boolean matched = memberNames.stream().anyMatch((s) -> s.startsWith("A"));
        System.out.println(matched);    //true

        // Find First: Returns any value which was find first
        String firstMatchedName = memberNames.stream().filter((s) -> s.startsWith("L")).findFirst().get();
        System.out.println(firstMatchedName);

        /************** Parallel Streams **************/
        Stream<Integer> stream = list.parallelStream();
        evenNumbersArr = stream.filter(i -> i%2 == 0).toArray(Integer[]::new);
        Arrays.stream(evenNumbersArr).parallel().forEach(System.out::println);
    }
}
