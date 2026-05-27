package carryForward;

public class countSubBrute {
     public static void main(String[] args) {
        String s = "abegag";
        int count = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            for (int j = i + 1; j < s.length(); j++) {
                // Fixed: Used ch and .charAt(j) instead of array brackets
                if (ch == 'a' && s.charAt(j) == 'g') {
                    count++;
                }
            }
        }
        System.out.println(count); // Output will be 3
    }
}
