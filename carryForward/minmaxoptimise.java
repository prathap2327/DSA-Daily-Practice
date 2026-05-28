package carryForward;

public class minmaxoptimise {
    public static int findMinLength(int[] arr) {
        
		int N = arr.length;
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for(int i=0;i<N;i++)
		{
		    if(arr[i]<min)
		    {
		        min = arr[i];
		    }
		    if(arr[i]>max)
		    {
		        max = arr[i];
		    }
		}
		int lastminidx = -1;
		int lastmaxidx = -1;
		int curLength=0;
		int minLength = Integer.MAX_VALUE;
		for(int i=0;i<N;i++)
		{
		    if(arr[i]==min)
		    {
		        lastminidx=i;
		        if(lastmaxidx!=-1)
		        {
		            curLength = lastminidx - lastmaxidx+1;
		            minLength=Math.min(curLength,minLength);
		        }
		    }
		    if(arr[i]==max)
		    {
		        lastmaxidx=i;
		        if(lastminidx!=-1)
		        {
		            curLength = lastmaxidx-lastminidx+1;
		            minLength=Math.min(curLength,minLength);
		        }
		        
		    }
		    
		    
		}
		
        
        return minLength;
    }
    public static void main(String[] args) {
        int[] arr = {2, 2, 6, 4, 5, 1, 6,5, 2, 6, 4, 1};
        int minLength = findMinLength(arr);
        System.out.println("Minimum length: " + minLength);
    }
}
