package Streams;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class findingDuplicates {
    public static void main(String[] args) {
		int[] arr = {2,3,4,5,2,9,3,2};
		
		Set<Integer> unique = new HashSet<>();
		
		Arrays.stream(arr).
		        boxed()
		        .filter(n-> !unique.add(n))
		        .distinct()
		        .forEach(System.out::println);
                
	}

    
}
