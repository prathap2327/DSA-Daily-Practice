package Streams;

import java.util.Arrays;
import java.util.List;

public class FlatNestedList {
    public static void main(String[] args) {
    List<List<Integer>> nestedList = Arrays.asList(
    Arrays.asList(1, 2),
    Arrays.asList(3, 4),
    Arrays.asList(5, 6)
);
List<Integer> flatList = nestedList.stream()
    .flatMap(List::stream)
    .toList();
    System.out.println(flatList);
    }
    
}
