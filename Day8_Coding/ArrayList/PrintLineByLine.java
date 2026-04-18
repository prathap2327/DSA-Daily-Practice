package Day8_Coding.ArrayList;

import java.util.ArrayList;

public class PrintLineByLine {

    ArrayList<ArrayList<Integer>> list2D = new ArrayList<ArrayList<Integer>>();

    public PrintLineByLine() {
        ArrayList<Integer> A1 = new ArrayList<>();
        ArrayList<Integer> A2 = new ArrayList<>();
        ArrayList<Integer> A3 = new ArrayList<>();
        A1.add(1);
        A1.add(2);
        A1.add(3);
        A2.add(4);
        A2.add(5);
        A2.add(6);
        A3.add(7);
        A3.add(8);
        A3.add(9);
        list2D.add(A1);
        list2D.add(A2);
        list2D.add(A3);
    }

    public void printList() {
        for (ArrayList<Integer> row : list2D) {
            for (int elem : row) {
                System.out.print(elem + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        PrintLineByLine obj = new PrintLineByLine();
        obj.printList();
    }
}