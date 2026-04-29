package HashMap;

import java.util.*;
public class prob1 {
    

	public static void main(String[] args) {
		HashMap<String,Integer> hm = new HashMap<String,Integer>();
		hm.put("Delhi",10);
		hm.put("Up",20);
		hm.put("Bengal",20);
		hm.put("Goa",40);
		hm.put("chennai",60);
		for(String key : hm.keySet())
		{
		    System.out.println(key + ":" + hm.get(key));
		}
		System.out.println(hm);
	}
}

