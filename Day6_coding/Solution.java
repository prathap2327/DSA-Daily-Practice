package Day6_coding;

public class Solution {
    public static int solve(int A) {
        int prmcount=0;
        for(int j=1;j<=A;j++){
            int count =0;
        for (int i = 1; i*i<=j; i++) {

            if (j % i == 0) {
                count++;
                if(i*i!=j)
                {
                    count++;
                }
            }
            if(count>2)
                break;
        }
        if(count==2)
        {
            prmcount++;
        }
        }
        return prmcount;
    }
    public static void main(String[] args) {
        int A = 19;
        System.out.println("Number of prime numbers up to " + A + " is: " + solve(A));
    }
}

