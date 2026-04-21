package Day8_Coding.ArrayList;

import java.util.ArrayList;
import java.util.List;

public class MatrixScalar {
    public static ArrayList<ArrayList<Integer>> solve(ArrayList<ArrayList<Integer>> A, int B) {
        int N = A.size();
        int M = A.get(0).size();
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<N;i++)
        {
            ArrayList<Integer> row = new ArrayList<>();
            for(int j=0;j<M;j++)
            {
                row.add(A.get(i).get(j)*B);
            }
            res.add(row);
        }
        return res;
    }
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> A = new ArrayList<>();
        A.add(new ArrayList<>(List.of(1, 2, 3)));
        A.add(new ArrayList<>(List.of(4, 5, 6)));
        A.add(new ArrayList<>(List.of(7, 8, 9)));
        int B = 2;
        System.out.println(solve(A, B));
    }
}
