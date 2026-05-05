package Day8_Coding.TwoDimenArrays;

public class RichCustomer {
    public static int maximumWealth(int[][] accounts) {
        int N = accounts.length;
        int M = accounts[0].length;
        
        int max = Integer.MIN_VALUE;
        for(int i=0;i<N;i++)
        {
            int res =0;
            for(int j=0;j<M;j++)
            {
                res += accounts[i][j];
            }
            if(res>max)
            {
                max = res;
            }
        }
        return max;
    }
    public static void main(String[] args) {
        int[][] accounts = {
            {1, 2, 3},
            {3, 2, 1},
            {4, 5, 6}
        };
        System.out.println(maximumWealth(accounts));
    }
}
