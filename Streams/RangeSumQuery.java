package Streams;

public class RangeSumQuery {
    private final int[] arr;
    public RangeSumQuery(int[] nums) {
        int N = nums.length;
        this.arr = new int[N+1];
        for(int i=0;i<N;i++)
        {
            arr[i+1] = arr[i] + nums[i];
        }
    }
    
    public int sumRange(int left, int right) {
        return arr[right+1] - arr[left];
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        RangeSumQuery rangeSumQuery = new RangeSumQuery(nums);
        System.out.println(rangeSumQuery.sumRange(0, 2)); // Output: 6
        System.out.println(rangeSumQuery.sumRange(1, 3)); // Output: 9
    }
}
