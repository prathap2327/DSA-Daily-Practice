package Day8_Coding.TwoDimenArrays;

public class IdentityMatrix {
    public static boolean IdentityM(int[][] matrix)
    {
        int N = matrix.length;
        int M = matrix[0].length;
        for(int i=0;i<N;i++)
        {
            for(int j=0;j<M;j++)
            {
                if(i==j)
                {
                    if(matrix[i][j]!=1)
                    {
                        return false;
                    }
                }else {
                    // Everything else must be 0
                    if (matrix[i][j] != 0) return false;
                }
            }
            
        }
        return true;
    }
	public static void main(String[] args) {
		int[][] matrix ={
            {1, 0, 0},
            {0, 1, 0},
            {0, 0, 1}
        };
		      
		
		if(IdentityM(matrix))
		{
		    System.out.println("Identity Matrix");
		}
		else
		{
		    System.out.println("Not Identity Matrix");
		}
	}
}
