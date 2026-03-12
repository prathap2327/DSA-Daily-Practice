package Day5_coding;

public class HcfAndLcm {
    public static int hcf(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static int lcm(int a, int b) {
        return (a * b) / hcf(a, b);
    }

    public static void main(String[] args) {
        int a = 12;
        int b = 18;
        System.out.println("HCF: " + hcf(a, b));
        System.out.println("LCM: " + lcm(a, b));
    }
}
