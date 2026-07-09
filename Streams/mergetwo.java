package Streams;

import java.util.Arrays;
import java.util.stream.IntStream;

public class mergetwo {
    public static void main(String[] args) {
        int[] arr1 = {1, 3, 5};
        int[] arr2 = {2, 4, 6};
        int[] result = IntStream.concat(Arrays.stream(arr1),Arrays.stream(arr2)).distinct().sorted().toArray();
        System.out.println(Arrays.toString(result));
    }
}
