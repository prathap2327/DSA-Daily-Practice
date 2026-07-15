package Streams;

import java.util.Arrays;
import java.util.Comparator;

public class wordSechigh {

    public static void main(String[] args) {
		String s = "I am Learning Streams API in java";
		
		String ans = Arrays.stream(s.split(" ")).sorted(Comparator.comparing(String::length).reversed())
		.skip(1).findFirst().get();
		
		System.out.println(ans);
	}
}
