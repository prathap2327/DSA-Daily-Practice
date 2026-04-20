package Day8_Coding.ArrayList;

import java.util.ArrayList;
import java.util.Arrays;

public class RowcolSum {

    public static ArrayList<Integer> solve(ArrayList<ArrayList<Integer>> A) {
         ArrayList<Integer> res = new ArrayList<>();
        for(int i=0;i<A.size();i++)
        {
           int rowSum =0;
            for(int j=0;j<A.get(i).size();j++)
            {
                rowSum += (A.get(i).get(j));
                
            }
            res.add(rowSum);
        }
      for (int j = 0; j < A.get(0).size(); j++) { 
    int colSum = 0;
    
    // 2. Loop through rows (i)
    for (int i = 0; i < A.size(); i++) {
        colSum += A.get(i).get(j);
    }
    
    res.add(colSum);
    }
    return res;
    }
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> A = new ArrayList<>();
        A.add(new ArrayList<>(Arrays.asList(1, 2, 3)));
        A.add(new ArrayList<>(Arrays.asList(4, 5, 6)));
        A.add(new ArrayList<>(Arrays.asList(7, 8, 9)));

        RowcolSum obj = new RowcolSum();
        ArrayList<Integer> result = obj.solve(A);
        System.out.println(result);
    }
}
