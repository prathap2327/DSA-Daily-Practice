package Day8_Coding;

import java.util.ArrayList;
import java.util.List;

public class GreatestNoofCandies {
    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        
        int max = Integer.MIN_VALUE;
        List<Boolean> list = new ArrayList<>();
        for(int x: candies)
        {
            if(x>=max)
            {
                max=x;
            }
        }
        

for(int c : candies)
{
    list.add(c + extraCandies >= max);
}
        return list;
    }

    public static void main(String[] args) {
        int[] candies = {2, 3, 5, 1, 3};
        int extraCandies = 3;
        System.out.println(kidsWithCandies(candies, extraCandies));
    }
}
