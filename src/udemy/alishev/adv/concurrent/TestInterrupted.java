package udemy.alishev.adv.concurrent;

import java.util.Random;

public class TestInterrupted {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                Random random = new Random();
                for (int i = 0; i < 1_000_000_000; i++) {
                    if (Thread.currentThread().isInterrupted()){
                        System.out.println("Thread was interrupted");
                        break;
                    }
                    Math.sin(random.nextDouble());
                }
            }
        });
        System.out.println("Start thread");
        thread.start();
        Thread.sleep(1_000);
        thread.interrupt();
        thread.join(); // ждем завершения потока

        System.out.println("Finished");
    }
}
