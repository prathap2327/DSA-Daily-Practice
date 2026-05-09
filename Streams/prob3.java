package Streams;

import java.util.Arrays;

public class prob3 {

    public static void main(String[] args) {
	   int[] A = {1,2,3,1,4,5,2,3};
	   Long count = Arrays.stream(A)
	                    .distinct()
	                    .count();
	                    
	   System.out.println(count);
	}
}
