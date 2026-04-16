package Day8_Coding.ArrayList;

import java.util.ArrayList;
import java.util.Scanner;

public class ArraylistasInput {

    public static void main(String[] args) {

        ArrayList<Integer> numbers = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        for (int i = 0; i < N; i++) {
            numbers.add(scanner.nextInt());
        }
        System.out.println(numbers);
    }
}