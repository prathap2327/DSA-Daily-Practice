package HashSet;

import java.util.HashSet;

public class commonEle {
    public static HashSet<Integer> solve(int[] A,int[] B)
    {
        HashSet<Integer> hs = new HashSet<>();
        HashSet<Integer> ts = new HashSet<>();
        for(int i=0;i<A.length;i++)
        {
            hs.add(A[i]);
        }
       for(int val : B)
       {
           if(hs.contains(val))
           {
               ts.add(val);
           }
       }
        return ts;
    }
	public static void main(String[] args) {
		int[] A = {1,2,3,4,4,4};
	    int[] B = {9,8,2,3,0,0};
		System.out.println(solve(A,B));
	}
}
