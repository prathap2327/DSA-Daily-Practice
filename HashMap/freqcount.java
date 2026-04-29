package HashMap;

import java.util.HashMap;

public class freqcount {
    public static HashMap<Integer, Integer> solve(int[] arr) {
    HashMap<Integer, Integer> hm = new HashMap<>();
    for (int num : arr) {
        if (!hm.containsKey(num)) {
            hm.put(num, 1);
        } else {
            // Get the current value and add 1
            hm.put(num, hm.get(num) + 1);
        }
    }
    return hm;
}

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,4,4};
        System.out.println(solve(arr));
    }
}
