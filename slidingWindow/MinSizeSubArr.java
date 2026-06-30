public class MinSizeSubArr {
    public static int minSubArrayLen(int target, int[] nums) {
        int N = nums.length;
		int min = Integer.MAX_VALUE;
		int l=0;
		int sum=0;
		for(int i=0;i<N;i++)
		{
		   sum+=nums[i];
		  while(sum>=target)
		  {
		      min = Math.min(min,i-l+1);
		      sum-=nums[l];
		      l++;
		  }
		}
        return min == Integer.MAX_VALUE ? 0 : min;
    }
    public static void main(String[] args) {
        int[] nums = {2,3,1,2,4,3};
        int target = 7;
        System.out.println(minSubArrayLen(target, nums)); // Output: 2
    }
}
