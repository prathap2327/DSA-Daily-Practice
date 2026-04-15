package Day8_Coding.ArrayList;

import java.util.ArrayList;

public class AddelementstoAL {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(10);
        numbers.add(20);
        numbers.add(30);
        System.out.println(numbers);

        ArrayList<String> names = new ArrayList<>();
        names.add("Alice");
        names.add("Bob");
        names.add("Charlie");
        System.out.println(names);
        names.get(1);
        System.out.println(names.size());
        System.out.println(names.remove(0));
        names.set(0, "Hales");
        System.out.println(names);
    }
}
