package HashSet;

import java.util.HashSet;

public class countDistinct {
    public static  int solve(int[] A) {
        HashSet<Integer> hs = new HashSet<>();

        for(int val : A)
        {
            hs.add(val);
        }
        return hs.size();
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 4, 4};
        System.out.println(solve(A));
    }
}
