package Streams;

import java.util.Arrays;
import java.util.List;

public class upperCase {
    public static void main(String[] args) {
		List<String> nums = Arrays.asList("ram", "john");
		List<String> result = nums.stream().map(String::toUpperCase).toList();
		System.out.println(result);
	}
}
