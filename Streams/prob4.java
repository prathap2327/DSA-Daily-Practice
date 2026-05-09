package Streams;

import java.util.Arrays;

public class prob4 {
    public static void main(String[] args) {
    int[] A = {1,2,3,1,4,5,2,3};
    boolean hasDuplicate =
    Arrays.stream(A).distinct().count() != A.length;

        System.out.println(hasDuplicate);
    }
}
