package Streams;

import java.util.List;
import java.util.stream.Collectors;

public class listInttoStr {
    
    public static void main(String[] args) {
		List<Integer> list = List.of(1,2,3,4);
		String collect = list.stream().map(String::valueOf).collect(Collectors.joining(","));
		System.out.println(collect);
	}
}
