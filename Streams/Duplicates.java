package Streams;

import java.util.List;

public class Duplicates {
    public static void main(String[] args) {
        List<Integer> nums = List.of(1,2,3,2,4,1);
        nums.stream()
            .filter(n -> nums.indexOf(n) != nums.lastIndexOf(n))
            .distinct()
            .forEach(System.out::println);
    }
}
