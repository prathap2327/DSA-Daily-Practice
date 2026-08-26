package Streams;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Employee11 {
     private int id;
    private String name;
    private String dept;
    private String city;
    private int salary;
    private int age;
    private char gender;
    private int yearOfJoining;

    // ... Constructor, Getters, and Setters ...
    public Employee11(int id, String name, String dept, String city, int salary, int age, char gender, int yearOfJoining) {
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
    public int getId()
    {
        return id;
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
        //return  dept + "->" + name + "(" + salary + ")";
        return name;
    }

    public static void main(String[] args) {
		
		List<Employee11> employees = new ArrayList<>();
		employees.add(new Employee11(1, "Alice", "Engineering", "NYC", 85000, 28, 'F', 2019));
		employees.add(new Employee11(2, "Bob", "Engineering", "SF", 92000, 35, 'M', 2016));
        employees.add(new Employee11(3, "Charlie", "HR", "NYC", 55000, 42, 'M', 2010));
        employees.add(new Employee11(4, "Diana", "HR", "SF", 62000, 30, 'F', 2018));
        employees.add(new Employee11(5, "Eve", "Marketing", "NYC", 58000, 26, 'F', 2021));
        employees.add(new Employee11(6, "Frank", "Engineering", "NYC", 78000, 31, 'M', 2017));
        employees.add(new Employee11(7, "Grace", "Marketing", "SF", 71000, 38, 'F', 2015));
        employees.add(new Employee11(8, "Henry", "HR", "NYC", 55000, 29, 'M', 2020));
        employees.add(new Employee11(9, "Ivy", "Engineering", "SF", 95000, 33, 'F', 2014));
        employees.add(new Employee11(10, "Jack", "Marketing", "NYC", 64000, 27, 'M', 2022));

        
      
        
         Map<String,Integer> nametoSal=employees.stream().collect(Collectors.toMap(Employee11::getName,Employee11::getSalary));
        System.out.println(nametoSal);

        Map<Integer, Employee11> idToEmployee = employees.stream().collect(Collectors.toMap(Employee11::getId, Function.identity()));
        System.out.println(idToEmployee);

       String names =  employees.stream().map(Employee11::getName).collect(Collectors.joining(", "));
       System.out.println(names);

       Map<String, Integer> deptToSalary = employees.stream().collect(Collectors.toMap(Employee11::getDept, Employee11::getSalary, Integer::sum));
       System.out.println(deptToSalary);
}
}
