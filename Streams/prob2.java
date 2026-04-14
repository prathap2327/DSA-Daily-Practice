package Streams;

import java.util.Arrays;
import java.util.List;

public class prob2 {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5);
        int result = nums.stream()
                         .filter(n -> n % 2 == 1) // Filter odd numbers
                         .mapToInt(n -> n * 2)    // Double the numbers
                         .reduce(0, Integer::sum);                   // Sum them up
        System.out.println("Sum of doubled odd numbers: " + result);
    }
}
