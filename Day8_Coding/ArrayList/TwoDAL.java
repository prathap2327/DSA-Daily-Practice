package Day8_Coding.ArrayList;

import java.util.ArrayList;

public class TwoDAL {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> list2D = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> A1 = new ArrayList<>();
        A1.add(1);
        A1.add(5);
        System.out.println(A1);
        list2D.add(A1);

        ArrayList<Integer> A2 = new ArrayList<>();
        A2.add(2);
        System.out.println(A2);
        list2D.add(A2);

        ArrayList<Integer> A3 = new ArrayList<>();
        A3.add(3);
        A3.add(6);
        A3.add(9);
        System.out.println(A3);
        list2D.add(A3);

        System.out.println(list2D);
    }
}
