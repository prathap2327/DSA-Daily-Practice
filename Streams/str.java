package Streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class str {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "", "David", "Eve");
        List<String> nonEmptyNames = names.stream()
                .filter(s->!s.isEmpty())
                .collect(Collectors.toList());
        System.out.println(nonEmptyNames);
    }
}
