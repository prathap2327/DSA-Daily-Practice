package prefixSum;

public class prob2bruteforce {
     public static void evenIndexSum(int[] arr, int[][] queries) {
        	for(int i=0;i<queries.length;i++)
		{
		    int l = queries[i][0];
		    int r = queries[i][1];
		    int sum =0;
		    for(int j=l;j<=r;j++)
		    {
		        if(j%2==0)
		        {
		            sum += arr[j];
		        }
		    }
		    System.out.println("the sum for given l and r: "+ sum);
		}
     }
     public static void main(String[] args) {
         int[] arr = {1, 2, 3, 4, 5, 6};
         int[][] queries = {{0, 2}, {1, 4}, {2, 5}};
         evenIndexSum(arr, queries);
     }
}
