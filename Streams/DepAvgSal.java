package Streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DepAvgSal {
    private String name;
    private double salary;
    private String department;
    
     public DepAvgSal(String name, String department, double salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }
    
    public String getDepartment()
    {
        return department;
    }
    
    public double getSalary()
    {
        return salary;
    }

public static void main(String[] args) {
		
		List<DepAvgSal> employees = Arrays.asList(
		                        new DepAvgSal("Alice", "IT", 60000),
            new DepAvgSal("Bob", "HR", 45000),
            new DepAvgSal("Charlie", "IT", 80000),
            new DepAvgSal("David", "Finance", 70000),
            new DepAvgSal("Eva", "HR", 55000),
            new DepAvgSal("Frank", "Finance", 75000)
		                        );
		                        
		 Map<String,Double> avgSalaryDept = employees.stream()
		                                        .collect(Collectors.groupingBy(DepAvgSal::getDepartment,
		                                        Collectors.averagingDouble(DepAvgSal::getSalary)));
		              avgSalaryDept.forEach((dept,avgSalary)-> System.out.println(dept + ": $" + avgSalary));
		              
		                                        
	}
}