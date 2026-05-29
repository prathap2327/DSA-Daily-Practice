package carryForward;

public class PickfromBothSides {
    public static int solve(int[] A, int B) {
        int N = A.length;
        int leftSum =0;
        int rightSum =0;

        for(int i=0;i<B;i++)
        {
            leftSum+=A[i];
        }
        int ans=leftSum;
        for(int i=0;i<B;i++)
        {
            leftSum-= A[B-1-i];
            rightSum+= A[N-1-i];
            ans=Math.max(ans,leftSum+rightSum);
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] A = {5, -2, 3 ,1, 2};
        int B = 3;
        System.out.println(solve(A, B));
    }
}
