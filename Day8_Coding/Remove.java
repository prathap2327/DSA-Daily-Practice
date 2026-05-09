package Day8_Coding;

public class Remove {
       public static int removeElement(int[] nums, int val) {
        int count =0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != val) {
                nums[count] = nums[i];
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int[] nums = {3, 2, 2, 3};
        int val = 3;
        int newLength = removeElement(nums, val);
        System.out.println("New length: " + newLength);
        System.out.print("Modified array: ");
        for (int i = 0; i < newLength; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
