import java.util.HashSet;

public class MaxSubarrStr {
    
    public static int lengthOfLongestSubstring(String s) {
        int N = s.length();
		HashSet<Character> set = new HashSet<>();
		int left =0;
		int maxLength=0;
		for(int right=0;right<N;right++)
		{
		    char ch = s.charAt(right);
		    while(set.contains(ch))
		    {
		        set.remove(s.charAt(left));
		        left++;
		    }
		    set.add(ch);
		    maxLength = Math.max(maxLength,right-left+1);
		}
        return maxLength;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        int length = lengthOfLongestSubstring(s);
        System.out.println("Length of the longest substring without repeating characters: " + length);
    }
}
