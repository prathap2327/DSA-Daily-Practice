package Streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Employee {
    public static class Emp {
    String name;
    String dept;
    int salary;
    
    public Emp(String name,String dept,int salary)
    {
        this.name = name;
        this.dept = dept;
        this.salary = salary;
    }
     @Override
        public String toString() {
            return name + " (" + salary + ")";
        }
}
	public static void main(String[] args) {
		List<Emp> employees = Arrays.asList(
		    new Emp("Alice","HR",50000),
		    new Emp("Ram","IT",80000),
		    new Emp("Charlie","HR",60000),
		    new Emp("David","IT",90000)

		    );
		    
		    Map<String,List<Emp>> byDept = employees.stream().collect(Collectors.groupingBy(e->e.dept));
		    
		    Optional<Emp> highestSalaryEmp = employees.stream().max(Comparator.comparingInt(e->e.salary));
		    
		    double avgSalary =employees.stream().collect(Collectors.averagingInt(e->e.salary));
		    
		    System.out.println("Average salary: " +avgSalary);
		    System.out.println();
		    
		    System.out.println("Employees by Department:");
            byDept.forEach((dept, empList) -> System.out.println(dept + ": " + empList));
            System.out.println();
        
        highestSalaryEmp.ifPresent(emp -> 
            System.out.println("Highest Salary Employee: " + emp.name + " with " + emp.salary)
        );
		    
		    
		    
	}
}
