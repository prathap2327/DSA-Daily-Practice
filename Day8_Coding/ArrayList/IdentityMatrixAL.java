package Day8_Coding.ArrayList;

import java.util.ArrayList;
import java.util.List;

public class IdentityMatrixAL {
    public int solve(final List<ArrayList<Integer>> A) {
        int N = A.size();
        if (N == 0) return 0;
        int M = A.get(0).size();
        for(int i=0;i<N;i++)
        {
            for(int j=0;j<M;j++)
            {
                 if(i==j&&A.get(i).get(j)!=1)
                {
                    return 0;
                }
                else if(i!=j&&A.get(i).get(j)!=0)
                {
                    return 0;
                }
            }
            
        }
        return 1;
    }
        public static void main(String[] args) {
            List<ArrayList<Integer>> A = new ArrayList<>();
            A.add(new ArrayList<>(List.of(1, 0, 0)));
            A.add(new ArrayList<>(List.of(0, 1, 0)));
            A.add(new ArrayList<>(List.of(0, 0, 1)));
    
            IdentityMatrixAL obj = new IdentityMatrixAL();
            int result = obj.solve(A);
            System.out.println(result);
        }
}
