package Streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
class Employee{
    private String name;
    private double salary;
    
    public Employee(String name,double salary)
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
        return "Employee{name='" + name + "',salary = "+ salary + "}";
    }
}
public class HighestPaid {
    	public static void main(String[] args) {
		List<Employee> employees = Arrays.asList(
		    new Employee("ALice",70000),
		    new Employee("Ram",80000),
		    new Employee("Peddi",200000),
		    new Employee("priya",50000));
		    
		    Optional<Employee> highestPaid = employees.stream().max(Comparator.comparingDouble(Employee::getSalary));
		    
		    
		    highestPaid.ifPresent(employee -> System.out.println("Highest paid salary: "+ employee));
	}
}
