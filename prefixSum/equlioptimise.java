package prefixSum;

public class equlioptimise {
    
    public int solve(int[] A) {
        int N =A.length;
        for(int i=1;i<N;i++)
        {
            A[i] = A[i-1]+A[i];
        }
        for(int i=0;i<N;i++)
        {
            int leftsum =0;
            if(i!=0)
            {
                leftsum += A[i-1];
            }
            int rightsum = A[N-1] - A[i];
            if(leftsum == rightsum)
            {
                return i;
            }
        }
        return -1;

    }
    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 6};
        equlioptimise obj = new equlioptimise();
        int result = obj.solve(A);
        System.out.println("Equilibrium index: " + result);
    }
}
