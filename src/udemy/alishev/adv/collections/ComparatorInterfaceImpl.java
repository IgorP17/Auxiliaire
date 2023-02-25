package udemy.alishev.adv.collections;

import java.util.*;

public class ComparatorInterfaceImpl {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("frog");
        list.add("z");
        list.add("alligator");
        list.add("bird");
        list.add("dog");
        list.add("cat");

//        Collections.sort(list);
//        Collections.sort(list, Collections.reverseOrder());
        Collections.sort(list, new StringLengthComparator());
        System.out.println(list);

        List<Integer> iList = new ArrayList<>();
        iList.add(10);
        iList.add(500);
        iList.add(0);
        iList.add(250);

        // Сортировка через анонимный класс
        Collections.sort(iList, new Comparator<Integer>() {
            @Override
            public int compare(Integer integer, Integer t1) {
                if (integer > t1)
                    return -1;
                else if (integer < t1)
                    return 1;
                else
                    return 0;
            }
        });
        System.out.println(iList);

        // Сортировка объектов
        Person person1 = new Person(1, "Bob");
        Person person2 = new Person(2, "Katy");
        Person person3 = new Person(3, "Mike");
        List<Person> people = new ArrayList<>();
        people.add(person3);
        people.add(person1);
        people.add(person2);

        Collections.sort(people, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                if (o1.getId() > o2.getId())
                    return 1;
                else if (o1.getId() < o2.getId())
                    return -1;
                else
                    return 0;
            }
        });

        System.out.println(people);

    }
}

class StringLengthComparator implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        /*
            o1 > o2 -> 1
            o1 < o2 -> -1
            o1 == o2 -> 0
         */
        if (o1.length() > o2.length()) {
            return 1;
        } else if (o1.length() < o2.length()) {
            return -1;
        } else {
            return 0;
        }
    }
}


