package Day8_Coding.TwoDimenArrays;

public class RowByRow {
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
               System.out.print(Mat[i][j]+" ");
           }
           System.out.println();
       }
    }
}
