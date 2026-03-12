package Day5_coding;

public class VowelorConstant {
    public static boolean isVowel(char ch) {
        ch = Character.toLowerCase(ch);
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }                   

    public static void main(String[] args) {
        char inputChar = 'A'; // Example input
        if (isVowel(inputChar)) {
            System.out.println(inputChar + " is a vowel.");
        } else {
            System.out.println(inputChar + " is a consonant.");
        }
    }
}
