package Day8_Coding.TwoDimenArrays;

public class Print_Sum {
    
    public static void main(String[] args) {
        int N=3,M=4;
       int[][] Mat = new int[3][4];
       int cnt =1;
       for(int i=0;i<N;i++)
       {
           for(int j=0;j<M;j++)
           {
               Mat[i][j] = cnt;
               cnt++;
           }
       }
       for(int i=0;i<N;i++)
       {
           int sum = 0;
           for(int j=0;j<M;j++)
           {
               sum+=Mat[i][j];
           }
           System.out.println("Sum of row "+i+" is: "+sum);
       }
    }
}
