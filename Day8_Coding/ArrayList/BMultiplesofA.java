package Day8_Coding.ArrayList;

import java.util.ArrayList;
import java.util.Scanner;

public class BMultiplesofA {
    public static ArrayList<Integer> multiples(int A,int B)
    {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=1;i<=B;i++)
        {
            list.add(A*i);
        }
        return list;
    }
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		System.out.println(multiples(A,B));
	}
}