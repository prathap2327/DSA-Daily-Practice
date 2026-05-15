package Day8_Coding;

public class Time_to_Equality {
    public static void main(String[] args) {
        int[] arr = {2,4,1,3,2};
        System.out.println(minTimeToEquality(arr));
    }

    public static int minTimeToEquality(int[] arr) {
        int max = Integer.MIN_VALUE;
        

        for (int num : arr) {
            if (num > max) {
                max = num;
            }
           
        }
        int count=0;
        for(int i=0;i<arr.length;i++){
            count+=max-arr[i];
        }

        return count;
    }
}
