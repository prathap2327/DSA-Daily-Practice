package Strings;

public class LastOcuurence {
    
    public static int solve(final String A, final int B) {
         int N = A.length();
        for(int i=N-1;i>=0;i--)
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
         
         String A = "hello worlbb";
         int B = 98;
         System.out.println(solve(A, B));
      }
}
