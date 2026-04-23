package Strings;

public class PrintASCII {
    public static void printAscii(String str)
    {
        for(int i=0;i<str.length();i++)
        {
            System.out.println("ASCII value of " + str.charAt(i) + " is " + (int)str.charAt(i));
        }
    }

    public static void main(String[] args) {
        printAscii("Hello");
    }

}
