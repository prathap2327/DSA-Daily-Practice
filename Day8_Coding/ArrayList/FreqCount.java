package Day8_Coding.ArrayList;

import java.util.ArrayList;

public class FreqCount {
    public ArrayList<Integer> solve(ArrayList<Integer> A) {
        int N = A.size();
        ArrayList<Integer> B = new ArrayList<>();
        for(int i=0;i<N;i++)
        {
             int count=0;
            for(int j=0;j<N;j++)
            {
               
                if(A.get(i).equals(A.get(j)))
                {
                    count++;
                }
                
            }
            B.add(count);
        }
        return B;
    }
    public static void main(String[] args) {
        FreqCount freqCount = new FreqCount();
        ArrayList<Integer> A = new ArrayList<>();
        A.add(1);
        A.add(2);
        A.add(2);
        A.add(3);
        System.out.println(freqCount.solve(A));
    }
}
