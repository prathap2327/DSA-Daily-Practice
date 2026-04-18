package Day8_Coding.ArrayList;

import java.util.ArrayList;

public class TwoDAL {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> list2D = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> A1 = new ArrayList<>();
        ArrayList<Integer> A4 = new ArrayList<>();
        A4.add(8);
        A4.add(10);
        A4.add(12);
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

        System.out.println(list2D.get(0).get(1));
        System.out.println(list2D.get(1).get(0));
        System.out.println(list2D.get(2));
        System.out.println(list2D.get(0).size());
        System.out.println(list2D.get(2).remove(0));
        System.out.println(A4);
        list2D.set(0,A4);
        System.out.println(list2D);
    }
}
