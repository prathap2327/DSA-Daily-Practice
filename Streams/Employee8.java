package Streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Comparator;

public class Employee8 {
    private int id;
    private String name;
    private String dept;
    private String city;
    private int salary;
    private int age;
    private char gender;
    private int yearOfJoining;

    // ... Constructor, Getters, and Setters ...
    public Employee8(int id, String name, String dept, String city, int salary, int age, char gender, int yearOfJoining) {
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
        return name + "(" + yearOfJoining + ")";
    }

    public static void main(String[] args) {
		
		List<Employee8> employees = new ArrayList<>();
		employees.add(new Employee8(1, "Alice", "Engineering", "NYC", 85000, 28, 'F', 2019));
		employees.add(new Employee8(2, "Bob", "Engineering", "SF", 92000, 35, 'M', 2016));
        employees.add(new Employee8(3, "Charlie", "HR", "NYC", 55000, 42, 'M', 2010));
        employees.add(new Employee8(4, "Diana", "HR", "SF", 62000, 30, 'F', 2018));
        employees.add(new Employee8 (5, "Eve", "Marketing", "NYC", 58000, 26, 'F', 2021));
        employees.add(new Employee8(6, "Frank", "Engineering", "NYC", 78000, 31, 'M', 2017));
        employees.add(new Employee8(7, "Grace", "Marketing", "SF", 71000, 38, 'F', 2015));
        employees.add(new Employee8(8, "Henry", "HR", "NYC", 55000, 29, 'M', 2020));
        employees.add(new Employee8(9, "Ivy", "Engineering", "SF", 95000, 33, 'F', 2014));
        employees.add(new Employee8(10,"Jack", "Marketing", "NYC", 64000, 27, 'M', 2022));
        
        // List<Employee8> asc=employees.stream().sorted(Comparator.comparingInt(Employee8::getSalary)).collect(Collectors.toList());
        // System.out.println(asc);
        // List<Employee8> des=employees.stream().sorted(Comparator.comparingInt(Employee8::getSalary).reversed()).collect(Collectors.toList());
        // System.out.println(des);
        // List<Employee8> asc1 = employees.stream().sorted(Comparator.comparing(Employee8::getDept).thenComparing(Employee8::getSalary)).collect(Collectors.toList());
        // System.out.println(asc1);
        // List<Employee8> des1 = employees.stream().sorted(Comparator.comparing(Employee8::getAge).reversed().thenComparing(Employee8::getName)).collect(Collectors.toList());
        // System.out.println(des1);
        List<Employee8> asc2 = employees.stream().sorted(Comparator.comparingInt(Employee8::getYear)).collect(Collectors.toList());
        System.out.println(asc2);
	}
}
