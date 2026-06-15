package Streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class joinusingcomma {
    
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Ram","john","Alex");
		String result = names.stream().collect(Collectors.joining(","));
		System.out.println(result);
    }
}
