package Streams;

import java.util.Arrays;

public class MaxWealth {
    public static int maximumWealth(int[][] accounts) {
        return Arrays.stream(accounts)
                .mapToInt(account -> Arrays.stream(account).sum())
                .max()
                .orElse(0);
    }

    public static void main(String[] args) {
        int[][] accounts = {
            {1, 2, 3},
            {3, 2, 1},
            {4, 5, 6}
        };
        System.out.println(maximumWealth(accounts));
    }
}
