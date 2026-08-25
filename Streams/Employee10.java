package Streams;


import java.util.*;
import java.util.stream.Collectors;


public class Employee10 {
     private int id;
    private String name;
    private String dept;
    private String city;
    private int salary;
    private int age;
    private char gender;
    private int yearOfJoining;

    // ... Constructor, Getters, and Setters ...
    public Employee10(int id, String name, String dept, String city, int salary, int age, char gender, int yearOfJoining) {
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
        //  String shortDept = dept;
        // if (dept.equals("Engineering")) {
        //     shortDept = "Eng";
        // } else if (dept.equals("Marketing")) {
        //     shortDept = "Mkt";
        // }
        // else if (dept.equals("HR")) {
        //     shortDept = "HR";
        // }
        // String salaryInK = (salary / 1000) + "k"; 
        // return shortDept + ":" + name + "(" + salaryInK + ")" + "->";
        //return name + "(" + age + ")";
        //return name + "(" + yearOfJoining + ")";
        return "Optional" + "(" + name + "," + dept + "," + city + "," + salary + ")";
    }

    public static void main(String[] args) {
		
		List<Employee10> employees = new ArrayList<>();
		employees.add(new Employee10(1, "Alice", "Engineering", "NYC", 85000, 28, 'F', 2019));
		employees.add(new Employee10(2, "Bob", "Engineering", "SF", 92000, 35, 'M', 2016));
        employees.add(new Employee10(3, "Charlie", "HR", "NYC", 55000, 42, 'M', 2010));
        employees.add(new Employee10(4, "Diana", "HR", "SF", 62000, 30, 'F', 2018));
        employees.add(new Employee10(5, "Eve", "Marketing", "NYC", 58000, 26, 'F', 2021));
        employees.add(new Employee10(6, "Frank", "Engineering", "NYC", 78000, 31, 'M', 2017));
        employees.add(new Employee10(7, "Grace", "Marketing", "SF", 71000, 38, 'F', 2015));
        employees.add(new Employee10(8, "Henry", "HR", "NYC", 55000, 29, 'M', 2020));
        employees.add(new Employee10(9, "Ivy", "Engineering", "SF", 95000, 33, 'F', 2014));
        employees.add(new Employee10(10,"Jack", "Marketing", "NYC", 64000, 27, 'M', 2022));
        
      
        
        Map<String,List<String>> namesByDept = employees.stream().collect(Collectors.groupingBy(Employee10::getDept,Collectors.mapping(Employee10::getName,Collectors.toList())));
	
         Map<String,Long> countByDept = employees.stream().collect(Collectors.groupingBy(Employee10::getDept,Collectors.counting()));
        
        System.out.println(namesByDept);
        System.out.println(countByDept);
    }
}
