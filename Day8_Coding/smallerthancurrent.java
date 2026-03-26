package Day8_Coding;

public class smallerthancurrent {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int N = nums.length;
        int[] result = new int[N];
        for(int i=0;i<N;i++)
        {
            int count=0;
            for(int j=0;j<N;j++)
            {
                if(nums[j]<nums[i])
                {
                    count++;
                }
                
            }
            result[i]=count;
        }
        return result;
    }

     public static void main(String[] args) {
        smallerthancurrent obj = new smallerthancurrent();
        int[] nums = {8,1,2,2,3};
        int[] result = obj.smallerNumbersThanCurrent(nums);
        for(int x: result)
        {
            System.out.print(x+" ");
        }
     }
}
