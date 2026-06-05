package prefixSum;

import java.util.HashMap;
import java.util.Map;

public class contiguousArr {
    public static int findMaxLength(int[] nums) {
        int N = nums.length;
        Map<Integer,Integer> map = new HashMap<>();

        int preSum =0;
        int max=0;
        map.put(0,-1);
        for(int i=0;i<N;i++)
        {
            preSum += (nums[i]==0)?-1:1;

            if(map.containsKey(preSum))
            {
                int pre = map.get(preSum);
                int cur = i-pre; 
                max = Math.max(max,cur);
            }
            else
            {
                map.put(preSum,i);
            }
        }
        return max;
    }
    public static void main(String[] args) {
        int[] nums = {0,1,0};
        System.out.println(findMaxLength(nums));
    }
}
