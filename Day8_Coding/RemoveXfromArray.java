package Day8_Coding;

public class RemoveXfromArray {
    
    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5};
        int B = 3;
         solve(A, B);
        
    }

    public static void solve(int[] A, int B) {

        int N = A.length;
        int index = B-1;
        for(int i=index;i<N-1;i++)
        {
            A[i]=A[i+1];
            
        }
        for(int i=0;i<N-1;i++)
        {
            System.out.print(A[i]+" ");
        }
    }
}
