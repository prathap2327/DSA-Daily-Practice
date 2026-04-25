package Strings;

public class charIndex {
    public static  String solve(String A) {
        String res ="";
	    for(int i=0;i<A.length();i++)
	    {
	        int index =0;
	        char ch = A.charAt(i);
	        index = (ch-'a')+1;
	        res = res + ch+index;
	    }
        return res;
    }
    public static void main(String[] args) {
        System.out.println(solve("abc")); // Output: a1b2c3
        System.out.println(solve("xyz")); // Output: x24y25z26
    }
}
