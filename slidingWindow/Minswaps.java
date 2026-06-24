public class Minswaps {
    
    public static void main(String[] args) {
		int[] A = {1, 12, 10, 3, 14, 10, 5};
		int N = A.length;
		int B = 8;
		int bad=0;
		int count=0;
		for(int i=0;i<N;i++)
		{
		    if(A[i]<=8)
		    {
		        count++;
		    }
		}
		for(int i=0;i<count;i++)
		{
		    
		    if(A[i]>8)
		    {
		       bad++;
		    }
		}
		int minSwaps = bad;
		int i=0;
		int j=count;
		while(j<N)
		{
		   
		        if(A[i]>B)
		        {
		            bad--;
		        }
		        if(A[j]>B)
		        {
		            bad++;
		        }
		    minSwaps = Math.min(minSwaps, bad);
		    i++;
		    j++;
		}
		System.out.println(minSwaps);
		
	}
}
