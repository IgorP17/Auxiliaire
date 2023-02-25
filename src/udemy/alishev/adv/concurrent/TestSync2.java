package udemy.alishev.adv.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TestSync2 {
    public static void main(String[] args) {
        new Worker().main();
    }
}

class Worker {
    Random random = new Random();
    private final List<Integer> list1 = new ArrayList<>();
    private final List<Integer> list2 = new ArrayList<>();

    final Object lock1 = new Object();
    final Object lock2 = new Object();

    public void addToList1() {
        synchronized (lock1) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            list1.add(random.nextInt(100));
        }
    }

    public void addToList2() {
        synchronized (lock2) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            list2.add(random.nextInt(100));
        }
    }

    public void work() {
        for (int i = 0; i < 1_000; i++) {
            addToList1();
            addToList2();
        }
    }

    public void main() {
        long before = System.currentTimeMillis();
//        work();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                work();
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                work();
            }
        });
        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        long after = System.currentTimeMillis();
        System.out.println("Time elapsed: " + (after - before));
        // Time elapsed: 3712 в 1 потоке
        // Time elapsed: 7787 при 2х синхронизованных методах добавления
        // Time elapsed: 4155 при использовании lock объектов
        System.out.println("List 1 size: " + list1.size());
        System.out.println("List 2 size: " + list2.size());
    }
}