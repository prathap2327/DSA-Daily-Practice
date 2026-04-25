package Strings;

public class BeeslyString {
    public static int solve(String A) {
        int N = A.length();
        int countPA=0;
        int countM=0;
        for(int i=0;i<N;i++)
        {
            char ch = A.charAt(i);
            if(ch == 'p' || ch == 'a')
            {
                countPA++;
            }
            else
            {
                countM++;
            }
        }
        if(countPA == countM)
        {
            return 1;
        }
        return 0;
    }
    public static void main(String[] args) {
        System.out.println(solve("ppaa")); // Output: 1
        System.out.println(solve("ppamammm")); // Output: 0
    }
}
