package Day8_Coding;

public class FrequencyofX {

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5, 3, 2, 1};
        int B = 3;
        int frequency = solve(A, B);
        System.out.println("Frequency of " + B + ": " + frequency);
    }

   public static int solve(int[] A, int B) {
        int N = A.length;
        int freq =0;
        for(int i=0;i<N;i++)
        {
            if(A[i]==B)
            {
                freq++;
            }
        }
        return freq;
    }
}
