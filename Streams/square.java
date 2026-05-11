package Streams;

import java.util.List;

public class square {
    public static void main(String[] args) {
            // List<Integer> nums = List.of(5,1,9,3);
            // nums.stream()
            //     .map(n -> n * n > 20)
            //     .forEach(System.out::println);
            List<Integer> nums = List.of(5,1,9,3);
            nums.stream().filter(n -> n * n > 20).forEach(System.out::println);
    }
    
}
