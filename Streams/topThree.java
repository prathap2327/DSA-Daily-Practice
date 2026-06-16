package Streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class topThree {
    public static void main(String[] args) {
		
		List<Integer> numbers = Arrays.asList(10, 45, 78, 12, 99, 45, 100);
		
		List<Integer> topThree = numbers.stream().distinct().sorted(Comparator.reverseOrder()).limit(3)
		                           .collect(Collectors.toList());
		                           
		                           System.out.println(topThree);
		
	}
}
