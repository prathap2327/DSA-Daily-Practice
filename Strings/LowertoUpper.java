package Strings;

public class LowertoUpper {
    public static String convertToUpper(String str) {
        // Convert string to a character array to modify it
        char[] chars = str.toCharArray();
        
        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            
            // Check if the character is a lowercase letter (a-z)
            if (ch >= 'a' && ch <= 'z') {
                // Subtract 32 to get the uppercase version
                chars[i] = (char) (ch - 32);
            }
        }
        
        // Return the modified array as a new String
        return new String(chars);
    }

    public static void main(String[] args) {
        System.out.println(convertToUpper("hello world 123")); // Output: HELLO WORLD 123
    }
}
