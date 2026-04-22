package Day8_Coding.ArrayList;

import java.util.ArrayList;

public class MultiplesofEachElem {
    public ArrayList<ArrayList<Integer>> solve(ArrayList<Integer> A, ArrayList<Integer> B) {
     ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        int N = A.size();
        for(int i=0;i<B.size();i++)
        {
            ArrayList<Integer> row = new ArrayList<Integer>();
            for(int j=0;j<N;j++)
            {
                
                if(A.get(j)%B.get(i)==0)
                {
                    row.add(A.get(j));
                }
            }
            res.add(row);
        }
        return res;
    }
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>();
        A.add(1);
        A.add(2);
        A.add(3);
        ArrayList<Integer> B = new ArrayList<>();
        B.add(1);
        B.add(2);
        B.add(3);
        System.out.println(new MultiplesofEachElem().solve(A, B));
    }
}
