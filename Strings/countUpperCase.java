package Strings;

public class countUpperCase {
    
    public static int countUpperCase(String str)
    {
        int count = 0;
        for(int i=0;i<str.length();i++)
        {
            if(str.charAt(i) >= 'A' && str.charAt(i) <= 'Z')
            {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String str = "Hello World";
        System.out.println("Number of uppercase letters in the string is: " + countUpperCase(str));
    }
}
