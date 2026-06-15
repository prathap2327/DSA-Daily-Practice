package contribution;

public class sumallsubA {
    public static void main(String[] args) {
		int[] A = {10,20,30};
		int N = A.length;
		int sum =0;
		for(int i=0;i<N;i++)
		{
		    sum += A[i]*(i+1)*(N-i);
		}
		System.out.println(sum);
	}
}
