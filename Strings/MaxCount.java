package Strings;

public class MaxCount {
    public static int solve(final String A) {
        int N = A.length();
        int alphaC=0;
        int DigitC=0;
        for(int i=0;i<N;i++)
        {
            char ch = A.charAt(i);
            if((ch >= 'a' && ch<='z') || (ch>= 'A' && ch <= 'Z') )
            {
                alphaC++;
            }
            else if(ch >= '0'&& ch<= '9')
            {
                DigitC++;
            }

        }
        if(alphaC > DigitC)
        {
            return alphaC;
        }
        return DigitC;
    }
    public static void main(String[] args) {
        
        String A = "abc12345";
        System.out.println(solve(A));
    }
}
