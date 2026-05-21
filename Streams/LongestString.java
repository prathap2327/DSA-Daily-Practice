package Streams;

import java.util.Arrays;

public class LongestString {

    public static String findLongestString(String[] strings) {
        return Arrays.stream(strings)
                .reduce("", (a, b) -> a.length() > b.length() ? a : b);
    }
    public static void main(String[] args) {
        String[] strings = {"apple", "banana", "pear", "kiwi", "grape"};
        String longest = findLongestString(strings);
        System.out.println("Longest string: " + longest);
    }
}
