package Streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
public class Employee1{
    private String name;
    private double salary;
    
    public Employee1(String name,double salary)
    {
        this.name = name;
        this.salary=salary;
    }
    public String getName()
    {
        return name;
    }
    public double getSalary()
    {
        return salary;
    }
    
    public String toString()
    {
        return "Employee1{name='" + name + "',salary = "+ salary + "}";
    }


    	public static void main(String[] args) {
		List<Employee1> employees = Arrays.asList(
		    new Employee1("ALice",70000),
		    new Employee1("Ram",80000),
		    new Employee1("Peddi",200000),
		    new Employee1("priya",50000));
		    
		    Optional<Employee1> highestPaid = employees.stream().max(Comparator.comparingDouble(Employee1::getSalary));
		    
		    
		    highestPaid.ifPresent(employee -> System.out.println("Highest paid salary: "+ employee));
	}
}
