package prefixSum;

import java.util.Arrays;

public class ProductArraybruforce {
    	public static void main(String[] args) {
		int[] nums = {1,2,3,4};
		int N = nums.length;
		int[] res =new int[N];
		for(int i=0;i<N;i++)
		{
		    res[i] = 1;
		    for(int j=0;j<N;j++)
		    {
		        if(i==j)
		        {
		            continue;
		        }
		        else
		        {
		            res[i] *= nums[j];
		        }
		    }
		}
		System.out.println(Arrays.toString(res));
	}
}
