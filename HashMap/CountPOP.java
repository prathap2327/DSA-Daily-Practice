package HashMap;

import java.util.HashMap;

public class CountPOP {
    public static int population(HashMap<String, Integer> H, int K){
    int cnt =0;
    for(String val : H.keySet())
    {
        if(H.get(val)<K)
        {
            cnt++;
        }
    }
    return cnt;
}
    public static void main(String[] args) {
        HashMap<String, Integer> populationMap = new HashMap<>();
        populationMap.put("CityA", 500000);
        populationMap.put("CityB", 300000);
        populationMap.put("CityC", 700000);
        int K = 600000;
        System.out.println(population(populationMap, K));
    }
}
