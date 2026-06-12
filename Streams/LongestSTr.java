package Streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LongestSTr {
    public static void main(String[] args) {
        	List<String> words = Arrays.asList("Java","Python","Golangua");
		 String longest = words.stream().max(Comparator.comparingInt(String::length))
		 .orElse("");
		 System.out.println(longest);
    }
}
