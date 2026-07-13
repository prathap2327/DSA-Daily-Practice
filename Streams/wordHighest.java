package Streams;

import java.util.Arrays;
import java.util.Comparator;

public class wordHighest {

    public static void main(String[] args) {
		String s = "I am learning Stream Api in java";
		
	    String ans = Arrays.stream(s.split(" ")).max(Comparator.comparing(String::length)).get();
	    
	    System.out.println(ans);
	}
}
