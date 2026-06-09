package prefixSum;

public class oddSum {
    public static int numOfSubarrays(int[] arr) {
        // int MOD = 1_000_000_007;

        // long ans =0;
        // int prefixSum =0;

        // int even =1;
        // int odd=0;
        // for(int num : arr)
        // {
        //     prefixSum += num;

        //     if(prefixSum %2 ==0)
        //     {
        //         ans+=odd;
        //         even++;
        //     }
        //     else
        //     {
        //         ans+=even;
        //         odd++;
        //     }
        //     ans%=MOD;
        // }
        // return (int)ans;
        
		int N = arr.length;
		int[] pfsum = new int[N+1];
		pfsum[0] =0;
		for(int i=1;i<=N;i++)
		{
		    pfsum[i] = pfsum[i-1]+arr[i-1];
		}
		
		int even=1;
		int odd=0;
		int ans =0;
		for(int i=1;i<pfsum.length;i++)
		{
		    if(pfsum[i]%2!=0)
		    {
		        
		        ans += even;
		        odd++;
		    }
		    else
		    {
		        ans+=odd;
		        even++;
		    }
		}
		return ans;
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        int result = numOfSubarrays(arr);
        System.out.println("Number of subarrays with odd sum: " + result);
    }
}
