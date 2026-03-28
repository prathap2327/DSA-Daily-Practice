package Day8_Coding;

public class Pangram {
    public static boolean checkIfPangram(String sentence) {
        boolean[] seen = new boolean[26];
        for(int i=0;i<sentence.length();i++)
        {
            char ch = sentence.charAt(i);
            if (ch >= 'a' && ch <= 'z') { // Ensure the character is a lowercase letter
                int index = ch - 'a';
                seen[index] = true;
            }
        }
        for(int i=0;i<26;i++)
        {
            if(seen[i]==false)
            {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String sentence = "the quick brown fox jumps over a lazy dog";
        boolean isPangram = checkIfPangram(sentence);
        System.out.println("Is the sentence a pangram? " + isPangram);
    }
}
