package slidingWindow.MaxSubarrayLength;

public class approach1 {
    public static void main(String[] args) {
		
		int N=10;
		int k=5;
		int[] arr = {-3,4,-2,5,3,-2,8,2,-1,4};
		int max = Integer.MIN_VALUE;
		int[] pf = new int[N];
		 pf[0] = arr[0];
		for(int i=1;i<N;i++)
		{
		    pf[i] = pf[i-1]+arr[i];
		}
		for(int start =0;start<=N-k;start++)
		{
		    int sum =0;
		    int end = start+k-1;
		    if(start==0)
		    {
		        sum = pf[end];
		    }
		    else
		    {
		        sum = pf[end]-pf[start-1]; 
		    }
		    
		    max = Math.max(sum,max);
		    System.out.println(pf[start] + " " + pf[end] + " "+ sum);
		}
		System.out.println("The max is: " + max);
	}
}
