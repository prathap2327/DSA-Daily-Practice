package Day8_Coding;

public class FrequencyCount {
    public int[] solve(int[] A) {
        int N = A.length;
        int[] B = new int[N];
        for(int i=0;i<N;i++)
        {
            B[i]= freq(A,A[i]);
        }
        return B;
    }
        public int freq(int[] A,int k)
        {
            int count=0;
            for(int i=0;i<A.length;i++)
            {
                if(A[i]==k)
                {
                    count++;
                }
            }
            return count;
        }

        public static void main(String[] args) {
            FrequencyCount fc = new FrequencyCount();
            int[] A = {1, 2, 2, 3, 3, 3};
            int[] result = fc.solve(A);
            for (int freq : result) {
                System.out.print(freq + " ");
            }
        }
}
