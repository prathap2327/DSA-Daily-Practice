package carryForward;

public class countSuboptimise {
    public static void main(String[] args) {
        String s = "abegag";
        int count = 0;
        int aCount = 0; // To count occurrences of 'a'
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == 'a') {
                aCount++; // Increment count of 'a'
            } else if (ch == 'g') {
                count += aCount; // Add the number of 'a's found so far
            }
        }
        System.out.println(count); // Output will be 3
    }
}
