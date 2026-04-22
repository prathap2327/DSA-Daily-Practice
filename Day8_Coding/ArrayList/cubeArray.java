package Day8_Coding.ArrayList;

import java.util.ArrayList;

public class cubeArray {

    public static ArrayList<Integer> solve(ArrayList<Integer> arr) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < arr.size(); i++) {
            result.add(arr.get(i) * arr.get(i) * arr.get(i));
        }
        return result;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        System.out.println(solve(arr));
    }
}
