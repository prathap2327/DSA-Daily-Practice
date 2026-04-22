package Day8_Coding.ArrayList;

import java.util.ArrayList;

public class MatrixTranspose {
    public ArrayList<ArrayList<Integer>> solve(ArrayList<ArrayList<Integer>> A) {
        int N = A.size();
        int M = A.get(0).size();
        ArrayList<ArrayList<Integer>> List = new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<M;i++)
        {
            ArrayList<Integer> row = new ArrayList<>();
            for(int j=0;j<N;j++)
            {
                row.add(A.get(j).get(i));
            }
            List.add(row);
        }
        return List;
    }
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        ArrayList<Integer> row1 = new ArrayList<>();
        row1.add(1);
        row1.add(2);
        row1.add(3);
        matrix.add(row1);
        ArrayList<Integer> row2 = new ArrayList<>();
        row2.add(4);
        row2.add(5);
        row2.add(6);
        matrix.add(row2);
        ArrayList<Integer> row3 = new ArrayList<>();
        row3.add(7);
        row3.add(8);
        row3.add(9);
        matrix.add(row3);
        System.out.println(new MatrixTranspose().solve(matrix));
    }
}
