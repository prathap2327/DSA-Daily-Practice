package carryForward;

import java.util.ArrayList;

public class Leaders {
    public static int[] solve(int[] A) {
        ArrayList<Integer> leaders = new ArrayList<>();
		int maxRight=Integer.MIN_VALUE;
        int count=0;
		for(int i=A.length-1;i>=0;i--)
		{
		    if(A[i]>maxRight)
		    {
		        maxRight=A[i];
		        leaders.add(maxRight);
                count++;
		    }
		    
		    
		}
        int[] res = new int[count];
        for(int i=0;i<count;i++)
        {
            res[i]=leaders.get(i);
        }
        return res;
    }
    public static void main(String[] args) {
        int[] A = {16, 17, 4, 3, 5, 2};
        int[] res = solve(A);
        for(int i:res)
        {
            System.out.print(i+" ");
        }
    }
}
