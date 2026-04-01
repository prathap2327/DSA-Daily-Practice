package Day8_Coding;

public class printNegatives {
    public static void main(String[] args) {
        int[] numbers = {1, -2, 3, -4, 5, -6};
        for (int num : numbers) {
            if (num < 0) {
                System.out.println(num);
            }
        }
    }
}
