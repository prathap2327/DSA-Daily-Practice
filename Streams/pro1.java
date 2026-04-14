package Streams;

import java.util.Arrays;
import java.util.List;

public class pro1 {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5);
        int result = nums.stream()
                         .filter(n -> n % 2 == 0) // Filter even numbers
                         .mapToInt(n -> n * n)    // Square the numbers
                         .sum();                   // Sum them up
        System.out.println("Sum of squares of even numbers: " + result);
    }
}
