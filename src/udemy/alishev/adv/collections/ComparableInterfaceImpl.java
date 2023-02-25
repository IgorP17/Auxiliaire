package udemy.alishev.adv.collections;

import java.util.*;

public class ComparableInterfaceImpl {
    public static void main(String[] args) {
        List<Person> peopleList = new ArrayList<>();
        Set<Person> peopleSet = new TreeSet<>();

        addElements(peopleList);
        addElements(peopleSet);

        Collections.sort(peopleList);

        System.out.println(peopleList);
        System.out.println(peopleSet);
    }

    private static void addElements(Collection collection){
        collection.add(new Person(2, "Tom"));
        collection.add(new Person(4, "Katy"));
        collection.add(new Person(1, "Bo"));
        collection.add(new Person(3, "Zeeeeeeeed"));
    }
}
