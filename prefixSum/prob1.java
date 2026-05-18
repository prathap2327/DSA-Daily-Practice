package prefixSum;

public class prob1 {

    public static void pfsum(int[][] queries,int[] A)
    {
        int N = A.length;
	    
	    
	    for(int i=1;i<N;i++)
	    {
	        A[i] = A[i-1] + A[i];
	    }
	    int sum =0;
	   for(int i=0;i<queries.length;i++)
	   {
	    
	        int l = queries[i][0];
	        int r = queries[i][1];
	        
	        if(l==0)
	        {
	            sum = A[r];
	        }
	        else{
	            sum =  A[r] - A[l-1];
	        }
	        System.out.println("Sum from index " + l + " to " + r + " is: " + sum);
	   }
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5};
        int[][] queries = {{0, 2}, {1, 3}, {0, 4}};
        
        pfsum(queries, A);
    }

}
