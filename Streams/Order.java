package Streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Order {
    private Integer orderId;
    private double amount;
    public Order(Integer orderId,double amount)
    {
        this.orderId=orderId;
        this.amount=amount;
    }
    public Integer getOrderId()
    {
        return orderId;
    }
    public double getAmount()
    {
        return amount;
    }
    public String toString()
    {
        return "Order{OrderId='" + orderId + "',Amount = "+ amount + "}";
    }
	public static void main(String[] args) {
	    List<Order> orders = Arrays.asList(
	        new Order(105,3000),
	        new Order(101,7000),
	        new Order(103,9000),
	        new Order(102,4500),
	        new Order(104,6000));
	        
	        List<Integer> orderIds = orders.stream().filter(order -> order.getAmount()>5000).
	                                map(Order::getOrderId).sorted().collect(Collectors.toList());
	                               
	                               System.out.println(orderIds);
	}
}
