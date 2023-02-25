package udemy.alishev.adv.concurrent;

public class Test {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start(); // не RUN!!!

        System.out.println("Hello world!");

        Thread myThread2 = new Thread(new Runner());
        myThread2.start(); // не RUN!!!
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("Hello from MyThread " + i);
        }
    }
}

class Runner implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("Hello from Runner " + i);
        }
    }
}