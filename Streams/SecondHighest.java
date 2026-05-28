package Streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SecondHighest {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        Integer secondHighest = numbers.stream()
                .distinct()
                // .sorted((a, b) -> b.compareTo(a))
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst()
                .orElse(null);
        System.out.println(secondHighest);
    }   
}
