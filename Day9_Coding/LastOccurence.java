package Day9_Coding;

public class LastOccurence {
    public static int BinarySearch(int[] arr,int target)
    {
        int low=0, high=arr.length-1, result=-1;
    while (low<=high) {
        int mid=low+(high-low)/2;
        if (arr[mid]==target) { result=mid; low=mid+1; }  // save, keep going right
        else if (arr[mid]<target) low=mid+1;
        else high=mid-1;
    }
    return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 2, 3, 4, 5};
        int target = 2;

        int result = BinarySearch(arr, target);
        if (result != -1) {
            System.out.println("Last occurrence of " + target + " found at index: " + result);
        } else {
            System.out.println("Element not found in the array.");
        }
    }
}
