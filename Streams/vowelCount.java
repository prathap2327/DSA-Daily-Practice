package Streams;

public class vowelCount {
    public static void main(String[] args) {
    String str = "Hello World";
		long count = str.toLowerCase().chars().filter(ch->"aeiou".indexOf(ch)!=-1).count();
		System.out.println(count);
    }
}
