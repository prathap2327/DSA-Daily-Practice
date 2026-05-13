package Streams;

import java.util.List;

public class firstletterUpper {
    public static void main(String[] args) {
        List<String> name = List.of("Ram","suresh","Madhu");
        name.stream().filter(n->n.startsWith("R")).map(String::toUpperCase).forEach(System.out::println);
    }
}
