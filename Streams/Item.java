package Streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Item {
    private int id; 
         private String name;
    
    public Item(int id,String name)
    {
        this.id = id;
        this.name = name;
    }
    public int getId()
    {
        return id;
    }
    public String getName()
    {
        return name;
    }
    public static void main(String[] args) {
		List<Item> itemList = Arrays.asList(
		                new Item(1,"Apple"),
		                new Item(2,"Banana"),
		                new Item(3,"Cherry")
		                );
		      Map<Integer,String> map = itemList.stream().collect(Collectors.toMap(Item::getId,Item::getName));
		      
		      System.out.println(map);
	}
}
