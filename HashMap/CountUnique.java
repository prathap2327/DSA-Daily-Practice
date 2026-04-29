package HashMap;

import java.util.HashMap;

public class CountUnique {
    public static int solve(int[] A) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int val : A)
        {
            if(hm.containsKey(val))
            {
                hm.put(val,hm.get(val)+1);
            }
            else
            {
                hm.put(val,1);
            }
        }
        int count =0;
        for(int key :hm.keySet())
        {
            if(hm.get(key)==1)
            {
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int[] A = {1,2,3,4,4,4};
        System.out.println(solve(A));
    }
}
