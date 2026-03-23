package Day8_Coding;

import java.util.Arrays;

public class ConcatenationArray {
    public static int[] getConcatenation(int[] nums) {
        int n=nums.length;       
        int[]ans=new int[2*n];

        for(int i=0;i<2*n;i++){
                 ans[i]=nums[i%n];  
        }
        return ans;

    }
    public static void main(String[] args) {
        
        int[] nums = {1, 2, 1};
        int[] result = getConcatenation(nums);
        System.out.println(Arrays.toString(result));
    }
}
