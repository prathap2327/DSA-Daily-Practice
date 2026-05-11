package Streams;

import java.util.List;

public class length {
    public static void main(String[] args) {
        List<String> words = List.of("apple", "banana", "cherry");
        words.stream()
            .map(String::length)
            .forEach(System.out::println);
    }
}
