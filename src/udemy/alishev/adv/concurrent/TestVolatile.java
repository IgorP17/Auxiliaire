package udemy.alishev.adv.concurrent;

import java.util.Scanner;

public class TestVolatile {
    // volatile нужен для того, когда 1 переменная делится между потоками.
    // Когерентность кешей - main на одном ядре, поток на другом - переменная isRunning может быть по разному закеширована на уровне кеша CPU?
    // Когда 1 поток читает, второй записывает - используем volatile

    public static void main(String[] args) {
        TestVolatileThread thread = new TestVolatileThread();
        thread.start();

        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();

        thread.shutDown();
    }
}
class TestVolatileThread extends Thread {
    private volatile boolean isRunning = true; // гарантия не кеширования переменной

    @Override
    public void run() {
        while (isRunning) {
            System.out.println("Hello!");
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void shutDown() {
        this.isRunning = false;
    }
}