package Streams;

import java.util.List;

public class templist {
    public static void main(String[] args) {
        List<Integer> nums = List.of(1,-2,-3,2,4,-1);
        nums.stream()
            .filter(n -> n < 0)
            .forEach(System.out::println);
    }
}
