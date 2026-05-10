package Streams;

import java.util.Arrays;
import java.util.List;

public class maxmin {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1, 17, 54, -11);

        int max = nums.stream().max(Integer::compare).orElseThrow();
        int min = nums.stream().min(Integer::compare).orElseThrow();

        System.out.println("Maximum: " + max);
        System.out.println("Minimum: " + min);
    }
}
