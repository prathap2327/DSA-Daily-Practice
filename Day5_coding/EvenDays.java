package Day5_coding;

public class EvenDays {
    public static int isEvenDay(int day) {
        return day / 2;
    }

    public static void main(String[] args) {
        int day = 31; // Example input
        int result = isEvenDay(day);
        System.out.println(result);
    }
}
