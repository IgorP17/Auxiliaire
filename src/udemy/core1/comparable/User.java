package udemy.core1.comparable;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/*
Создать класс User с 3 полями - age(int), name(String), salary(int)
Создать коллекцию HashMap<User, String> и добавить туда 5 записей по принципу юзер-должность
Данные добавлять с консоли, используя BufferedReader
Разделить коллекцию HashMap на 3 коллекции TreeSet:
- в первую коллекцию сохранять пользователей с должностью - boss
- во вторую коллекцию сохранять пользователей с должностью - worker
- в третью коллекцию сохранять пользователей с другими должностями
Отсортировать пользователей с должностью boss по параметру salary и вывести содержимое коллекции в консоль.
Отсортировать пользователей с должностью worker по параметру age и вывести содержимое коллекции в консоль.
Отсортировать пользователей с другими должностями по параметру name и вывести содержимое коллекции в консоль.

Для упрощения не будем использовать ввод с консоли
 */
public class User implements Comparable<User> {
    private final String name;
    private final int age;
    private final int salary;

    public User(String name, int age, int salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public int getSalary() {
        return salary;
    }

    public String getName() {
        return name;
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

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }

    public static void main(String[] args) {
        User b1 = new User("Boss 1", 30, 3000);
        User b2 = new User("Boss 2", 40, 1000);
        User b3 = new User("Boss 3", 50, 5000);

        User w1 = new User("Worker 1", 40, 1000);
        User w2 = new User("Worker 2", 30, 2000);
        User w3 = new User("Worker 3", 50, 3000);

        User other2 = new User("Other 2", 20, 1000);
        User other1 = new User("Other 1", 20, 1000);
        User other3 = new User("Other 3", 20, 1000);

        HashMap<User, String> map = new HashMap<>();
        map.put(b1, "boss");
        map.put(b2, "boss");
        map.put(b3, "boss");
        map.put(w1, "worker");
        map.put(w2, "worker");
        map.put(w3, "worker");
        map.put(other2, "other");
        map.put(other1, "other");
        map.put(other3, "other");

        UserComparator comparator = new UserComparator();
        Set<User> boss = new TreeSet<>(comparator);
        Set<User> worker = new TreeSet<>();
        UserComparatorName userComparatorName = new UserComparatorName();
        Set<User> other = new TreeSet<>(userComparatorName);

        for (Map.Entry<User, String> entry : map.entrySet()) {
            if (entry.getValue().equalsIgnoreCase("boss")){
                boss.add(entry.getKey());
            } else if (entry.getValue().equalsIgnoreCase("worker")){
                worker.add(entry.getKey());
            } else {
                other.add(entry.getKey());
            }
        }

        System.out.println("Bosses by salary:");
        for (User user : boss) {
            System.out.println(user);
        }

        System.out.println("Worker by age:");
        for (User user : worker) {
            System.out.println(user);
        }

        System.out.println("Others by name:");
        for (User user : other) {
            System.out.println(user);
        }
    }
}
