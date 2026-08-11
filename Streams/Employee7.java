package Streams;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Employee7 {
    private int id;
    private String name;
    private String dept;
    private String city;
    private int salary;
    private int age;
    private char gender;
    private int yearOfJoining;

    // ... Constructor, Getters, and Setters ...
    public Employee7(int id, String name, String dept, String city, int salary, int age, char gender, int yearOfJoining) {
        this.id = id;
        this.name = name;
        this.dept = dept;
        this.city = city;
        this.salary = salary;
        this.age = age;
        this.gender = gender;
        this.yearOfJoining = yearOfJoining;
    }
    
    public String getDept() {
        return dept;
    }

    public int getSalary() {
        return salary;
    }
    
    public char getGender()
    {
        return gender;
    }
    public String getCity()
    {
        return city;
    }
    public int getAge()
    {
        return age;
    }
    public String getName()
    {
        return name;
    }
    public int getYear()
    {
        return yearOfJoining;
    }
    
    @Override
    public String toString() {
        
        return name + "(" + yearOfJoining + ")";
    }

    public static void main(String[] args) {
		
		List<Employee7> employees = new ArrayList<>();
		employees.add(new Employee7(1, "Alice", "Engineering", "NYC", 85000, 28, 'F', 2019));
		employees.add(new Employee7(2, "Bob", "Engineering", "SF", 92000, 35, 'M', 2016));
        employees.add(new Employee7(3, "Charlie", "HR", "NYC", 55000, 42, 'M', 2010));
        employees.add(new Employee7(4, "Diana", "HR", "SF", 62000, 30, 'F', 2018));
        employees.add(new Employee7(5, "Eve", "Marketing", "NYC", 58000, 26, 'F', 2021));
        employees.add(new Employee7(6, "Frank", "Engineering", "NYC", 78000, 31, 'M', 2017));
        employees.add(new Employee7(7, "Grace", "Marketing", "SF", 71000, 38, 'F', 2015));
        employees.add(new Employee7(8, "Henry", "HR", "NYC", 55000, 29, 'M', 2020));
        employees.add(new Employee7(9, "Ivy", "Engineering", "SF", 95000, 33, 'F', 2014));
        employees.add(new Employee7(10,"Jack", "Marketing", "NYC", 64000, 27, 'M', 2022));
        
        List<Employee7> filteredEmployee=employees.stream().filter(e-> e.getYear()>2018).collect(Collectors.toList());
        List<String> filteredEmployees=employees.stream().map(e->e.getName()).collect(Collectors.toList());
        List<String> filteredEmployees1=employees.stream().map(e->e.getDept()).distinct().collect(Collectors.toList());
       System.out.println(filteredEmployees);
       System.out.println(filteredEmployee);
       System.out.println(filteredEmployees1);
	}
}

