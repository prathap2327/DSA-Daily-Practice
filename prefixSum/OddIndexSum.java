package prefixSum;

public class OddIndexSum {
    
    public static void oddIndex(int[] arr,int[][] queries)
    {
        int[] pf = new int[arr.length];
        pf[0] = 0;
        for(int i=1;i<arr.length;i++)
        {
            if(i%2==1)
            {
                pf[i] = pf[i-1] + arr[i];
            }
            else
            {
                pf[i] = pf[i-1];
            }
        }
        int sum =0;
        for(int i=0;i<queries.length;i++)
        {
            int l = queries[i][0];
            int r = queries[i][1];
            
            if(l==0)
            {
                sum = pf[r];
            }
            else
            {
                sum = pf[r] - pf[l-1];
            }
            System.out.println("the sum for given l and r: "+ sum);
        }
        
    }
    public static void main(String[] args) {
       int[] arr = {2,3,1,6,4,5};
		int[][] queries = {{1,3}, {2, 5}, {0, 4},{3,3}};
        oddIndex(arr, queries);
    }
}
