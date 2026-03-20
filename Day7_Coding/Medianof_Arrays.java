package Day7_Coding;

import java.util.Arrays;

public class Medianof_Arrays {
    public static double findMedian(int[] A) {
        	int N = A.length;
		double result;
		for(int i=0;i<A.length;i++)
		{
		    for(int j=0;j<A.length-1-i;j++)
		    {
		        if(A[j]>A[j+1])
		        {
		            int temp = A[j];
		            A[j]=A[j+1];
		            A[j+1]=temp;
		        }
		    }
		}
		System.out.println(Arrays.toString(A));
		if(A.length%2==0)
		{
		    result = (A[N/2-1]+A[N/2])/2.0;
		}
		else{
		    result = A[N/2];
		}
        return result;
    }
    public static void main(String[] args) {
        int[] A = {1, 4, 7, 6, 5, 3};
        double median = findMedian(A);
        System.out.println("Median: " + median);
    }
}
