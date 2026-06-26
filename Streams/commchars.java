package Streams;

import java.util.List;
import java.util.stream.Collectors;

public class commchars {
    public static void main(String[] args) {
		String s1 = "banana";
		String s2 = "anaconda";
		List<Character> result = s1.chars()
		                        .mapToObj(c->(char)c)
		                        .distinct()
		                        .filter(c->s2.indexOf(c)!=-1)
		                        .collect(Collectors.toList());
		                        System.out.println(result);
	}
}
