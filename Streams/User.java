package Streams;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class User {
    int id;
        String name;
        int age;

        // 2. Fixed constructor syntax (removed 'class' keyword and made public)
        public User(int id, String name, int age) {
            this.id = id;
            this.name = name;
            this.age = age;
        }

        // 3. Added a getter for age and toString for readable output
        public int getAge() { return age; }
        
        @Override
        public String toString() {
            return name + " (" + age + ")";
        }
        public static void main(String[] args) {
		List<User> users = Arrays.asList(new User(1,"Alice",15),
		                    new User(2,"Bob",17),
		                    new User(3,"Charlie",21),
		                    new User(4,"euro",23),
		                    new User(5,"David",32));
		                    
		  Map<Boolean,List<User>> partioned= users.stream().collect(Collectors.partitioningBy(user->user.getAge()>18));
		      
		      System.out.println(partioned);
	}
}
