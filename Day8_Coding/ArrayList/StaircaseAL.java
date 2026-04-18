package Day8_Coding.ArrayList;

import java.util.ArrayList;

public class StaircaseAL {
    
    public static ArrayList<ArrayList<Integer>> stair(int N)
    {
        	ArrayList<ArrayList<Integer>> list2D = new ArrayList<ArrayList<Integer>>();
		
		
		 for(int i=1;i<=N;i++)
		 {
		     ArrayList<Integer> A1 = new ArrayList<>();
		     for(int j=1;j<=i;j++)
		     {
		          
		         A1.add(j);
		         
		     }
		     list2D.add(A1); 
		     
		 }
		 return list2D;
    }
    public static void main(String[] args) {
        int N = 3;
        System.out.println(stair(N));
    }
}
