package prefixSum;

import java.util.HashMap;

public class LongSubArreqK {
    public static int longestSubarray(int[] nums, int k) {
        int N = nums.length;
        int maxLen =0;
           int prefixSum =0;
           HashMap<Integer,Integer> map = new HashMap<>();
           map.put(0,-1);
           for(int i=0;i<N;i++)
           {
               prefixSum+=nums[i];
               if(map.containsKey(prefixSum-k))
               {
                   int idx = map.get(prefixSum-k);
                   int len = i-idx;
                   maxLen=Math.max(maxLen,len);
               }
               else
               {
                   map.put(prefixSum,i);
               }
           }
        return maxLen;
    }
        public static void main(String[] args) {
            int[] nums = {1,-1,5,-2,3};
            int k = 3;
            System.out.println(longestSubarray(nums, k));
        }
}
