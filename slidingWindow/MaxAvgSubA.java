public class MaxAvgSubA {
     public static double findMaxAverage(int[] nums, int k) {

        int sum = 0;

        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        double maxAvg = (double) sum / k;

        for (int i = 1; i <= nums.length - k; i++) {
            int j = i + k - 1;
            sum = sum - nums[i - 1] + nums[j];

            maxAvg = Math.max(maxAvg, (double) sum / k);
        }

        return maxAvg;
    }
    public static void main(String[] args) {
        int[] nums = {1, 12, -5, -6, 50, 3};
        int k = 4;
        double maxAverage = findMaxAverage(nums, k);
        System.out.println("Maximum average of subarray of length " + k + " is: " + maxAverage);
    }
}
