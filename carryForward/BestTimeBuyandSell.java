package carryForward;

public class BestTimeBuyandSell {
    public int maxProfit(final int[] A) {
        int n = A.length;
        int maxpro = 0;
         if(n == 0){
            return 0;
        }
        int max = A[n-1];
        int profit=0;
        for(int i=n-2;i>=0;i--)
        {
            if(A[i]>max)
            {
                max = A[i];
            }
             profit = max - A[i];
            if(profit > maxpro)
            {
                maxpro=profit;
            }
        }
        return maxpro;
    }
    public static void main(String[] args) {
        BestTimeBuyandSell obj = new BestTimeBuyandSell();
        int[] A = {1, 2};
        System.out.println(obj.maxProfit(A));
    }
}
