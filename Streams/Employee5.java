package Streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Employee5 {
    private int id;
    private String name;
    private String dept;
    private String city;
    private int salary;
    private int age;
    private char gender;
    private int yearOfJoining;

    // ... Constructor, Getters, and Setters ...
    public Employee5(int id, String name, String dept, String city, int salary, int age, char gender, int yearOfJoining) {
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
    
    @Override
    public String toString() {
        
        return name ;
    }

    public static void main(String[] args) {
		
		List<Employee5> employees = new ArrayList<>();
		employees.add(new Employee5(1, "Alice", "Engineering", "NYC", 85000, 28, 'F', 2019));
		employees.add(new Employee5(2, "Bob", "Engineering", "SF", 92000, 35, 'M', 2016));
        employees.add(new Employee5(3, "Charlie", "HR", "NYC", 55000, 42, 'M', 2010));
        employees.add(new Employee5(4, "Diana", "HR", "SF", 62000, 30, 'F', 2018));
        employees.add(new Employee5(5, "Eve", "Marketing", "NYC", 58000, 26, 'F', 2021));
        employees.add(new Employee5(6, "Frank", "Engineering", "NYC", 78000, 31, 'M', 2017));
        employees.add(new Employee5(7, "Grace", "Marketing", "SF", 71000, 38, 'F', 2015));
        employees.add(new Employee5(8, "Henry", "HR", "NYC", 55000, 29, 'M', 2020));
        employees.add(new Employee5(9, "Ivy", "Engineering", "SF", 95000, 33, 'F', 2014));
        
        
        // List<Employee5> filteredEmployees = employees.stream().filter(e->{
        //     String name = e.getName();
        //     if(name==null||name.isEmpty())
        //     {
        //         return false;
        //     }
        //     char firstChar = Character.toUpperCase(name.charAt(0));
        //     return "AEIOU".indexOf(firstChar) != -1;
        //     })
        //     .collect(Collectors.toList());
        Set<Character> vowels = Set.of('A','E','I','O','U');
        List<Employee5> filteredEmployees = employees.stream().
                                            filter(e->{
                                                String name = e.getName();
                                                if(name==null || name.isEmpty())
                                                {
                                                    return false;
                                                }
                                                char firstChar = Character.toUpperCase(name.charAt(0));
                                                return vowels.contains(firstChar);
                                                })
                                                .collect(Collectors.toList());
       System.out.println(filteredEmployees);
	}

}
