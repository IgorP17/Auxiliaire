package udemy.core1.collections;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FromLessonsCollectionsStage {

    public static void main(String[] args) {
//        dt();
        iter1();
    }

    /**
     * Iterator for List
     */
    private static void iter1() {
        List<String> list = new ArrayList<>();
        list.add("aaaaaaa");
        list.add("bbbbbbb");
        list.add("ccccccc");

        Iterator<String> iter = list.iterator();
        while (iter.hasNext()) {
            String element = iter.next();
            System.out.println(element);
        }

        for (String s : list) {
            System.out.println(s);
        }

        List<String> list2 = List.of("Alex", "Bob", "Cris");
        for (Iterator i = list2.iterator(); i.hasNext(); ){
            String name = (String) i.next();
            System.out.println(name);
        }
    }

    /**
     * DateTimeLocal
     */
    private static void dt() {
        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDate localD = LocalDate.of(2007, Month.APRIL, 20);
        LocalTime localT = LocalTime.of(23, 12, 11);
        LocalDateTime local = LocalDateTime.of(localD, localT);
        System.out.println(localDateTime);
        System.out.println(localDate);
        System.out.println(localTime);
        System.out.println(localD);
        System.out.println(localT);
        System.out.println(local);
    }
}
