package Day6_coding;

public class countFactors {
    public static int countFactors(int n) {
        int count = 0;
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                count++;
                if (i * i != n) {
                    count++;
                }
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int n = 36;
        System.out.println("Number of factors of " + n + " is: " + countFactors(n));
    }
    
}
