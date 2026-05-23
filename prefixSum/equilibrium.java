package prefixSum;

public class equilibrium {
    public static void main(String[] args) {
        int[] arr = { -7, 1, 5, 2, -4, 3, 0 };
        int n = arr.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }
        int leftsum = 0;
        for (int i = 0; i < n; i++) {
            sum -= arr[i];
            if (leftsum == sum) {
                System.out.println("Equilibrium index is " + i);
            }
            leftsum += arr[i];
        }
    }
}
