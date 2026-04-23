package Strings;

public class StringReversal {

    public static String reverseString(String str)
    {
        String reversed = "";
        for(int i=0;i<str.length();i++)
        {
            reversed = str.charAt(i)+reversed;
        }
        return reversed;
    }

    public static void main(String[] args) {
        String str = "Hello World";
        System.out.println("Reversed string is: " + reverseString(str));
    }
}
