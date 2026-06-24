

public class maxSubbary {
    public static int maxSubarray(int A, int B, int[] C) {
        int sum =0;
	    int start=0;
	    int max =0;
	    for(int i=0;i<A;i++)
	    {
	        sum += C[i];
	        while(sum>B)
	        {
	            sum -= C[start];
	            start++;
	        }
	        max = Math.max(sum,max);
	    }
    
    return max;
    
}
public static void main(String[] args) {
    int A = 5;
	    int B = 12;
	    int[] C = {2, 1, 3, 4, 5};
    System.out.println(maxSubbary.maxSubarray(A, B, C));
}
}

