package Streams;

import java.util.List;

public class Greater10 {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(5, 12, 8, 20, 3);
        // List<Integer> filtered = numbers.stream()
        //         .filter(n -> n > 10)
        //         .collect(Collectors.toList());
        // System.out.println(filtered);
        numbers.stream()
                .filter(n -> n > 10)
                .forEach(System.out::println);
    }
}
