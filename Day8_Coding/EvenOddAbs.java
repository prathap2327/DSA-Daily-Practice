package Day8_Coding;

import java.util.Scanner;

public class EvenOddAbs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T>0)
        {
            int N = sc.nextInt();
            int[] A = new int[N];
            for(int i=0;i<N;i++)
            {
                A[i] = sc.nextInt();
            }
            int evncnt=0;
            int oddcnt=0;
            for(int i=0;i<N;i++)
            {
                if(A[i]%2==0)
                {
                    evncnt++;
                }
                else
                {
                    oddcnt++;
                }
            }
            System.out.println(Math.abs(evncnt-oddcnt));
            T--;

        }
    }
}
