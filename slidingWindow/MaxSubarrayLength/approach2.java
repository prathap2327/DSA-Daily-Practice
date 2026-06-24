package MaxSubarrayLength;

public class approach2 {
    public static void main(String[] args) {
		
		int N=10;
		int k=5;
		int[] arr = {-3,4,-2,5,3,-2,8,2,-1,4};
		int subarrSum =0;
		for(int i=0;i<k;i++)
		{
		    subarrSum+=arr[i];
		}
		int maxSubarrSum = subarrSum;
		for(int start=1;start<=N-k;start++)
		{
		    int end = start+k-1;
		    subarrSum = subarrSum-arr[start-1]+arr[end];
		    maxSubarrSum = Math.max(subarrSum,maxSubarrSum);
		    
		}
		System.out.println(maxSubarrSum);
		
	}
}
