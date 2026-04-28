package Strings;

public class HightoLow {
    public static String solve(String A) {
        String res ="";
        for(int i=0;i<A.length();i++)
        {
            char ch = A.charAt(i);
            if(ch>='A' && ch<='Z')
            {
                res += (char)(ch+32);
            }
            else
            {
                res += (char)(ch-32);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String input = "HELLOWORLD";
        String output = solve(input);
        System.out.print(output); 
    }
}
