package udemy.core1.collections;

import java.util.Collections;
import java.util.Objects;

public class FromLessonsEqHashCode {

    public static void main(String[] args) {
        User user1 = new User();
        User user2 = new User();
        System.out.println(user1.hashCode() == user2.hashCode()); // false
        System.out.println(user1.equals(user2)); // false
        System.out.println("===");

        User user3 = user2;
        System.out.println(user3.hashCode() == user2.hashCode()); // true
        System.out.println(user3.equals(user2)); // true

        System.out.println("===");
        User user4 = new User(30, 5000);
        User user5 = new User(30, 5000);
        User user6 = new User(30, 5000);
        // in theory 4 and 5 should be the same, but links are not the same
        // we override equals and hashCode
        System.out.println(user4.hashCode() == user5.hashCode()); // false -> true
        System.out.println(user4.equals(user5)); // false -> true

        System.out.println("=== properties");
        // какими свойствами должен обладать equals
        // рефлексивность - проверка одинаковых объектов
        System.out.println(user1.equals(user1));
        // транзитивность 1=2 && 2=3 ->>> 1 = 3
        System.out.println(user4.equals(user5) && user5.equals(user6) && user4.equals(user6));
        // симметричность 1=2 -> 2=1
        System.out.println(user4.equals(user5) && user5.equals(user4));
        // сравнение с null -> false
        System.out.println(user4.equals(null));

        System.out.println("---");
        // if equals true -> hashCodes совпадают
        // но если возвращает false -> не значит что hashCode разные
        // а если false и hasCode одинаковые - значит произошла коллизия
        // необходимо для equals и hashCode использовать одинаковый набор полей
    }

}

class User {
    private int age;
    private int salary;

    public User(){

    }

    public User(int age, int salary){
        this.age = age;
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age && salary == user.salary;
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, salary);
    }
}
