package Day8_Coding.ArrayList;

import java.util.ArrayList;

public class productOfELement {
    public static long solve(ArrayList<Integer> arr) {
    // Complete the function template here
    int N = arr.size();
    long prod = 1;
    for(int i=0;i<N;i++)
    {
        prod= prod*arr.get(i);
    }
    return prod;
}
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        System.out.println(solve(arr));
    }
}
