package Day5_coding;

public class LeapYear {
    public static boolean isLeapYear(int year) {
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                return year % 400 == 0;
            }
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int year = 1900; // Example input
        int result = isLeapYear(year) ? 1 : 0;
        System.out.println(result);
    }
}
