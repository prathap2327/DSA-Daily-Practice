package HashSet;

import java.util.HashSet;

public class ArraytoHashset {
    public static HashSet<Integer> solve(int[] A)
    {
        HashSet<Integer> hs = new HashSet<>();
        for(int i=0;i<A.length;i++)
        {
            hs.add(A[i]);
        }
        return hs;
    }
	public static void main(String[] args) {
		int[] A = {1,2,3,4,4,4};
	
		System.out.println(solve(A));
	}
}
