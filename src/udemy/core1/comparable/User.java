package udemy.core1.comparable;

public class User implements Comparable<User> {
    private String name;
    private int age;
    private int salary;

    public User(String name, int age, int salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public int getSalary() {
        return salary;
    }

    // USe only age for compare
    @Override
    public int compareTo(User o) {
        if (this.age == o.age){
            return 0;
        } else if (this.age < o.age) {
            return -1;
        } else {
            return 1;
        }
    }
}
