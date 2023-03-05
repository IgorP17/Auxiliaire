package udemy.alishev.adv.concurrent;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestReentrantLock {
    public static void main(String[] args) throws InterruptedException {
        Task task = new Task();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                task.first();
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                task.second();
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        task.showCounter();
    }
}

class Task {
    private int count;
    private Lock lock = new ReentrantLock();
    private void increment() {
        for (int i = 0; i < 10_000; i++) {
            count++;
        }
    }

    public void first() {
        lock.lock(); // только 1 поток может вызвать lock, типа аналог synchronized
        increment();
        lock.unlock();
    }

    public void second() {
        lock.lock();
        increment();
        lock.unlock();
    }

    public void showCounter(){
        System.out.println(count);
    }
}
