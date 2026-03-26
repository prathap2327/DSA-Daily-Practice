package Day8_Coding;

public class NoofGoodPairs {
    public static int numIdenticalPairs(int[] nums) {
        int N = nums.length;
        int count=0;
        for(int i=0;i<N;i++)
        {
            for(int j=i+1;j<N;j++)
            {
                if(nums[i]==nums[j])
                {
                    count++;
                }
            }
        }
        return count;
    }

     public static void main(String[] args) {
        int[] nums = {1,2,3,1,1,3};
        System.out.println(numIdenticalPairs(nums));
     }
}
