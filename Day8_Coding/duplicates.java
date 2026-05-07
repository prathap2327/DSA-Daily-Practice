package Day8_Coding;

public class duplicates {
    public static int removeDuplicates(int[] nums) {
        int N = nums.length;
        int k=1;
        for(int i=0;i<N-1;i++)
        {
           if(nums[i+1]!=nums[i])
           {
                nums[k]= nums[i+1];
                k++;
           }
           
           
        }
        return k;
        
    }
    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 2, 3, 4, 4, 5};
        int newLength = removeDuplicates(nums);
        System.out.println("New length: " + newLength);
        System.out.print("Array after removing duplicates: ");
        for (int i = 0; i < newLength; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
