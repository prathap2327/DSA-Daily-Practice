package Day8_Coding.ArrayList;

import java.util.ArrayList;

public class Multiplesof5or7 {
    public static ArrayList<Integer> getMultiples(ArrayList<Integer> numbers) {
        ArrayList<Integer> res = new ArrayList<>();
        for (int num : numbers) {
            if (num % 5 == 0 || num % 7 == 0) {
                res.add(num);
            }
        }
        return res;
    }
    public static void main(String[] args) {
        
        // You can change this value to test with different inputs
        ArrayList<Integer> multiples = new ArrayList<>();
        multiples.add(1);
        multiples.add(2);
        multiples.add(3);
        multiples.add(4);
        multiples.add(5);
        multiples.add(6);
        multiples.add(7);
        multiples.add(8);
        multiples.add(9);
        multiples.add(10);


        System.out.println("Multiples of 5 or 7 up to " + getMultiples(multiples));
    }
}
