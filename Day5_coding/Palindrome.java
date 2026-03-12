package Day5_coding;

public class Palindrome {
    public static boolean isPalindrome(int N)
    {
        int original = N;
        int reversed = 0;

        while (N > 0) {
            int digit = N % 10;
            reversed = reversed * 10 + digit;
            N /= 10;
        }

        return original == reversed;
    }
        public static void main(String[] args) {
            int N = 12321; // Example input
           int result = isPalindrome(N) ? 1 : 0;
            System.out.println(result);
        }
}
