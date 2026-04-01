package Day8_Coding;

public class PairCount {

    public int countPairs(int[] A, int K) {
        int count = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = i + 1; j < A.length; j++) {
                if (A[i] + A[j] == K) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        PairCount pc = new PairCount();
        int[] A = {1, 2, 3, 4, 5};
        int K = 5;
        int result = pc.countPairs(A, K);
        System.out.println("Number of pairs: " + result);
    }
}
