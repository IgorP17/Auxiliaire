package udemy.alishev.adv.collections;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListsExample {

    public static void main(String[] args) {
        /*
         * ArrayList
         * Реализация через массив
         * Default capacity = 10
         * Увеличение массива на половину от емкости
         */

        List<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            arrayList.add(i * 2);
        }
        System.out.println(arrayList);
        System.out.println(arrayList.get(9));
        System.out.println(arrayList.size());

        /*
         * Двухсвязанный список
         *
         */
        List<Integer> linkedList = new LinkedList<>();

        int a = 4;
        System.out.println(a >> 1);
        System.out.println(a << 1);

        System.out.println("ArrayList:");
        measureTimeAdd(arrayList);
        System.out.println("LinkedList:");
        measureTimeAdd(linkedList);

        System.out.println("ArrayList:");
        measureTimeGet(arrayList);
        System.out.println("LinkedList:");
        measureTimeGet(linkedList);

        System.out.println("ArrayList:");
        measureTimeAddAt(arrayList);
        System.out.println("LinkedList:");
        measureTimeAddAt(linkedList);
    }

    private static void measureTimeAdd(List<Integer> list) {
        long start = System.currentTimeMillis();

        for (int i = 0; i < 1_000_000; i++) {
            list.add(i);
        }

        long end = System.currentTimeMillis();
        System.out.println("Time add = " + (end - start));
    }

    private static void measureTimeGet(List<Integer> list) {
        for (int i = 0; i < 10_000; i++) {
            list.add(i);
        }

        long start = System.currentTimeMillis();
        for (int i = 0; i < 10_000; i++) {
            list.get(i);
        }
        long end = System.currentTimeMillis();
        System.out.println("Time get = " + (end - start));
    }

    private static void measureTimeAddAt(List<Integer> list) {
        long start = System.currentTimeMillis();

        for (int i = 0; i < 10_000; i++) {
            list.add(0, i);
        }

        long end = System.currentTimeMillis();
        System.out.println("Time add at 0 = " + (end - start));
    }
}
