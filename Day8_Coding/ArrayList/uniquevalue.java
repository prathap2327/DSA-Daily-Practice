package Day8_Coding.ArrayList;

import java.util.ArrayList;

public class uniquevalue {
    
    public int solve(ArrayList<Integer> A) {
        int res=0;
        for(int i=0;i<A.size();i++)
        {
            int count=0;
            for(int j=0;j<A.size();j++)
            {
                if(A.get(i).equals(A.get(j)))
                {
                    count++;
                }
            }
            if(count==1)
            {
                res=A.get(i);
            }
        }
        return res;
    }
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>();
        A.add(1);
        A.add(2);
        A.add(2);
        A.add(3);
        A.add(3);
        A.add(4);

        uniquevalue obj = new uniquevalue();
        int result = obj.solve(A);
        System.out.println(result);
    }
}
