package Strings;

public class CountSpecialChars {

    public static int countSpecialChars(String str)
    {
        int count = 0;
        for(int i=0;i<str.length();i++)
        {
            char ch = str.charAt(i);
            // if(!Character.isLetterOrDigit(str.charAt(i)))
            // {
            //     count++;
            // }
            if(!(ch >= 'A' && ch<= 'Z')&& !(ch >= 'a' && ch<= 'z')&& !(ch >= '0' && ch<= '9'))
		  {
		      count++;
		  }
        }
        return count;
    }

    public static void main(String[] args) {
        String str = "Hello World!";
        System.out.println("Number of special characters in the string is: " + countSpecialChars(str));
    }
}
