package prefixSum;

import java.util.Arrays;

public class ProductArrayOptimise {
    public static int[] ProdArray(int[] nums)
    {
        int N = nums.length;
        int[] pf = new int[N];
        int[] sf = new int[N];
        int[] ans = new int[N];
        pf[0] = 1;
        for(int i=1;i<N;i++)
        {
            pf[i] = pf[i-1] * nums[i-1];
        }
        sf[N-1]=1;
        for(int i=N-2;i>=0;i--)
        {
            sf[i] = sf[i+1] * nums[i+1];
        }
        for(int i=0;i<N;i++)
        {
            ans[i] = pf[i] * sf[i];
        }
        return ans;
    }
	public static void main(String[] args) {
		int[] nums = {1,2,3,4};
		System.out.println(Arrays.toString(ProdArray(nums)));
    }
}
