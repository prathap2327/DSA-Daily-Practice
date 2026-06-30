package Streams;

import java.util.Arrays;
import java.util.stream.Collectors;

public class wordReversal {
    public static void main(String[] args) {
		String str = "Java Stream API";
		String result = Arrays.stream(str.split(" "))
		                .map(word-> new StringBuilder(word).reverse().toString())
		                .collect(Collectors.joining(" "));
		          
		          System.out.println(result);
	}
}
