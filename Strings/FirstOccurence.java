package Strings;

public class FirstOccurence {
    public static int solve(final String A, final int B) {
        int N = A.length();
        for(int i=0;i<N;i++)
        {
            char ch = A.charAt(i);
            if(ch==B)
            {
                return i;
            }
            
        }
        return -1;
    }

     public static void main(String[] args) {
         
         String A = "hello worlb";
         int B = 98;
         System.out.println(solve(A, B));
     }
}
