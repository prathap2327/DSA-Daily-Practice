package Streams;

import java.util.List;

public class Discount {
   
    public static void main(String[] args) {
        List<Integer> nums = List.of(101,200,30,20,400,19);
        nums.stream()
            .filter(n -> n > 100)
            .map(n -> n * 0.90)
            .forEach(System.out::println);
    }
}
