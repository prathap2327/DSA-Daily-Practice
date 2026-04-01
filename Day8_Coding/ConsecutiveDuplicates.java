package Day8_Coding;

public class ConsecutiveDuplicates {
    public static boolean solve(int arr[]) {
    // Complete the function here
    int N = arr.length;
    for(int i=0;i<N-1;i++)
    {
        if(arr[i]==arr[i+1])
        {
            return true;
        }
    }
    return false;
}

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 3, 4};
        boolean result = solve(arr);
        System.out.println(result); // Output: true
    }
}
