package carryForward;

public class GenAllsubarr {
     public static int[][] solve(int[] A) {
        int N = A.length;
        int[][] B = new int[(N*(N+1)/2)][];
        int index =0;
        for(int i=0;i<N;i++)
        {
            for(int j=i;j<N;j++)
            {
                int size = j-i+1;
                int[] sub = new int[size];
                int l=0;
                for(int k=i;k<=j;k++)
                {
                    sub[l++]=A[k];
                }
                B[index++] = sub;
            }
        }
        return B;
     }
     public static void main(String[] args) {
        
        int[] A = {1, 2, 3};
        int[][] result = solve(A);
        
        // Print the generated subarrays
        for (int[] subarray : result) {
            System.out.print("[");
            for (int num : subarray) {
                System.out.print(num + " ");
            }
            System.out.println("]");
        }
    }
}
