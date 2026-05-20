package prefixSum;

public class EvenIndexSum {
    public static void evenIndex(int[] arr,int[][] queries)
    {
        int[] pf = new int[arr.length];
        pf[0] = arr[0];
        for(int i=1;i<arr.length;i++)
        {
            if(i%2==0)
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
        int[] arr = {1, 2, 3, 4, 5, 6};
        int[][] queries = {{0, 2}, {1, 4}, {2, 5}};
        evenIndex(arr, queries);
    }
}
