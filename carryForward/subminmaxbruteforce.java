package carryForward;

public class subminmaxbruteforce {
    public static void main(String[] args) {
     int[] arr = {2, 2, 6, 4, 5, 1, 5,  6, 4,2, 1};
        
        // Initialize with the largest possible integer value
        int minLength = Integer.MAX_VALUE; 
        
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i] == 6 && arr[j] == 1 || arr[i] == 1 && arr[j] == 6) {
                    int currentLength = Math.abs(i - j) + 1; // Calculate the length of the subarray between indices i and j
                    
                    // Update minLength if the new distance is smaller
                    if (currentLength < minLength) {
                        minLength = currentLength;
                    }
                }
            }
        }
        
        System.out.println("Minimum length: " + minLength);
}
}