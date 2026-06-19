package slidingWindow;

public class sublenSum {
    public static int solve(int[] A, int B, int C) {
        // Guard check: A window larger than the array is impossible
        if (A == null || B > A.length || B <= 0) {
            return 0;
        }

        int N = A.length;
        int sum = 0;

        // Compute the sum of the first window
        for (int i = 0; i < B; i++) {
            sum += A[i];
        }

        if (sum == C) {
            return 1;
        }

        // Slide the window across the remaining elements
        for (int i = 1; i <= N - B; i++) {
            int j = i + B - 1;
            sum = sum - A[i - 1] + A[j];

            if (sum == C) {
                return 1;
            }
        }

        return 0;
    }
    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5};
        int B = 2;
        int C = 5;

        int result = sublenSum.solve(A, B, C);
        System.out.println(result); // Output: 1
    }
}
