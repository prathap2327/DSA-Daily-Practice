package Streams;

import java.util.Comparator;
import java.util.List;

public class secondhighest {
    public static void main(String[] args) {
    List<Integer> nums = List.of(10,20,30,40,50);

     Integer secondHighest = nums.stream().sorted(Comparator.reverseOrder())
                .distinct()
                .skip(1)
                .findFirst()
                .orElse(null);

        System.out.println("Second highest number is: " + secondHighest);
    }

}
