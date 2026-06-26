public class Majorityelement {
    public static int countMajoritySubarrays(int[] nums, int target) {
        
        int N = nums.length;
        int ans =0;
        for(int i=0;i<N;i++)
        {
            int targetCount=0;
            for(int j=i;j<N;j++)
            {
                if(nums[j]==target)
                {
                    targetCount++;
                }
                int length = j-i+1;
                if(2*targetCount> length)
                {
                    ans++;
                }
            }
        }
        return ans;
}
public static void main(String[] args) {
    
        
        int[] nums = {1,2,3,1,1};
        int target = 1;
        int result = countMajoritySubarrays(nums, target);
        System.out.println("Number of subarrays where " + target + " is the majority: " + result);
    }
}
