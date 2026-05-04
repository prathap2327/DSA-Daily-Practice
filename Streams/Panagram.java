package Streams;
 
public class Panagram {
    public static void main(String[] args) {
        String sentence = "The quick brown fox jumps over the lazy dog";
        boolean isPanagram = sentence.toLowerCase().chars()
            .filter(Character::isLetter)
            .distinct()
            .count() == 26;
        System.out.println("Is the sentence a panagram? " + isPanagram);
    }
}