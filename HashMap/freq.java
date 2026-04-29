package HashMap;

import java.util.HashMap;

public class freq {
    public static int[] solve(int[] A, int[] B) {
        HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
        for(int i=0;i<A.length;i++)
        {
            // if(hm.containsKey(A[i]))
            // {
            //     hm.put(A[i],hm.get(A[i])+1);
            // }
            // else
            // {
            //     hm.put(A[i],1);
            // }
            hm.put(A[i],hm.getOrDefault(A[i],0)+1);
        }
        int[] ans = new int[B.length];
        for(int i=0;i<B.length;i++)
        {
            if(hm.containsKey(B[i]))
            {
                ans[i] = hm.get(B[i]);
            }
            else
            {
                ans[i] = 0;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 4, 4};
        int[] B = {2, 4};
        int[] result = solve(A, B);
        for (int freq : result) {
            System.out.print(freq + " ");
        }
    }
}
