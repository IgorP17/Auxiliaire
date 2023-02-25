package udemy.alishev.adv.collections;

import java.util.*;

public class HashCodeEquals {
    public static void main(String[] args) {
        Map<Person, String> hashMap = new HashMap<>();
        Set<Person> set = new HashSet<>();

        Person person1 = new Person(1, "Mike");
        Person person2 = new Person(1, "Mike");

        hashMap.put(person1, "abc");
        hashMap.put(person2, "Zed");

        set.add(person1);
        set.add(person2);

        System.out.println(hashMap);
        System.out.println(set);
    }

}
