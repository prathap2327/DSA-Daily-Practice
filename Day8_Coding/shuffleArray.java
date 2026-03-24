package Day8_Coding;

import java.util.Arrays;

public class shuffleArray {
    public static int[] shuffle(int[] nums, int n) {
        int[] ans = new int[2*n];
        for (int i = 0;i<n;i++) {
          ans[2 * i] = nums[i];       // place x_i
            ans[2 * i + 1] = nums[i + n]; // place y_i
        }
        return ans; 
    }
    public static void main(String[] args) {
        int[] nums = {2,5,1,3,4,7};
        int n = 3;
        int[] shuffled = shuffle(nums, n);
        System.out.println(Arrays.toString(shuffled));
    }
}
