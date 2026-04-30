package Streams;

import java.util.List;

public class toUpper {
    public static void main(String[] args) {
        List<String> names = List.of("ram", "john", "alex");
        // List<String> upperNames = names.stream()
        //         .map(String::toUpperCase)
        //         .toList();
        List<String> upperNames = names.stream()
                .map(name -> "USER_" + name.toUpperCase())
                .toList();
        System.out.println(upperNames);
    }
}
