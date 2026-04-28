package Strings;

public class copyString {
    public static String solve(final String A) {
        String res ="";
        for(int i=0;i<A.length()-1;i++)
        {
            char ch = A.charAt(i);
            res += ch;
        }
        return res;
    }

    public static void main(String[] args) {
        String input = "Hello, World!";
        String output = solve(input);
        System.out.println(output);
    }
}
