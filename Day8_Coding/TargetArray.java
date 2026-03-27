package Day8_Coding;

import java.util.Arrays;

public class TargetArray {
    public static int[] createTargetArray(int[] nums, int[] index) {
        int[] target = new int[nums.length];
        for(int i=0;i<nums.length;i++)
        {
            int pos = index[i];
            for(int j=i;j>pos;j--)
            {
                target[j] = target[j-1];
            }
            target[pos] = nums[i];
        }
        return target;
    }
    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 3, 4};
        int[] index = {0, 1, 2, 2, 1};
        System.out.println(Arrays.toString(createTargetArray(nums, index)));
    }
}