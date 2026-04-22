package Day8_Coding.ArrayList;

import java.util.ArrayList;
import java.util.List;

public class SumofMainDiag {
    public int solve(final List<ArrayList<Integer>> A) {
        int N = A.size();
        int M = A.get(0).size();
        int sum =0;
        for(int i=0;i<N;i++)
        {
            ArrayList<Integer>res = new ArrayList<Integer>();
            for(int j=0;j<N;j++)
            {
                if(A.get(i).equals(A.get(j)))
                {
                    sum = sum+A.get(i).get(j);
                }
            }
            
        }
        return sum;
    }
    public static void main(String[] args) {
        SumofMainDiag sumofMainDiag = new SumofMainDiag();
        ArrayList<ArrayList<Integer>> A = new ArrayList<>();
        A.add(new ArrayList<>(List.of(1, 2, 3)));
        A.add(new ArrayList<>(List.of(4, 5, 6)));
        A.add(new ArrayList<>(List.of(7, 8, 9)));
        System.out.println(sumofMainDiag.solve(A));
    }
}
