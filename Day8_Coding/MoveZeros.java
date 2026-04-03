package Day8_Coding;

public class MoveZeros {
    
    public static void moveZeroes(int[] nums) {
        int nonZeroIndex = 0; // Pointer for the position of the next non-zero element

        // Move non-zero elements to the front
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[nonZeroIndex] = nums[i];
                nonZeroIndex++;
            }
        }

        // Fill the remaining positions with zeros
        for (int i = nonZeroIndex; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        moveZeroes(nums);
        System.out.print("After moving zeros: ");
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
    
}
