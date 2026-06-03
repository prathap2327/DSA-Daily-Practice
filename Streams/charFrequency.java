package Streams;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class charFrequency {
    public static void main(String[] args) {
		String input = "banana";
		
		Map<String, Long> frequencies = Arrays.stream(input.split(""))
		                                .collect(Collectors.groupingBy(c->c,Collectors.counting()));
		
		String result = frequencies.entrySet().stream()
		                    .map(entry -> entry.getKey()+ "=" + entry.getValue())
		                    .collect(Collectors.joining(","));
		                    
		                    System.out.println(result);
	}
}
