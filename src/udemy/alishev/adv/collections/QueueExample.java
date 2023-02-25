package udemy.alishev.adv.collections;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class QueueExample {
    public static void main(String[] args) {
        // реализация через LinkedList или PriorityQueue и другие
        Queue<Person> people = new LinkedList<>();

        Person person1 = new Person(1, "Mike");
        Person person2 = new Person(2, "Alice");
        Person person3 = new Person(3, "Bob");
        Person person4 = new Person(4, "Don");

        people.add(person2);
        people.add(person3);
        people.add(person4);
        people.add(person1);

        for (Person person : people) {
            System.out.println(person);
        }
        System.out.println("Revome = " + people.remove());
        System.out.println("Peek = " + people.peek()); // посмотрим на того кто первый
        System.out.println(people);

        /*
            Различие методов
                add, remove, element - в случае ошибки выбрасывают исключение
                offer, pool, peek - возвращают спец значение
         */

        Queue<Person> peopleABQ = new ArrayBlockingQueue<>(3); // максимальный размер очереди

        peopleABQ.add(person2);
        peopleABQ.add(person3);
        peopleABQ.add(person4);
        // peopleABQ.add(person1); // Exception in thread "main" java.lang.IllegalStateException: Queue full

        System.out.println("Offer to add element = " + peopleABQ.offer(person1));

    }
}
