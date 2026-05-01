package Day6_coding;

public class isPrime {
    public static boolean checkPrime(int n) {
        int count =0;
        if (n <= 1) {
            return false;
        }
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                count++;
                if(i*i!=n)
                {
                    count++;
                }
            }
            if(count>2)
                return false;
        }
        return count == 2?true:false;
    }
    public static void main(String[] args) {
        System.out.println(checkPrime(5));  // true
        System.out.println(checkPrime(10)); // false
    }
}
