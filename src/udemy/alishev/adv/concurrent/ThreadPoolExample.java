package udemy.alishev.adv.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExample {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        for (int i = 0; i < 5; i++) {
            executorService.submit(new ThreadPoolExampleWork(i));
        }

        executorService.shutdown();
        System.out.println("All task submitted and started!");

        boolean result = executorService.awaitTermination(1, TimeUnit.MINUTES); // подождать окончания выполнения

        if (result){
            System.out.println("Work done in time!");
        } else {
            System.out.println("Work NOT done in time!");
        }
    }
}

class ThreadPoolExampleWork implements Runnable {
    private final int id;

    public ThreadPoolExampleWork(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.printf("Work id = %d was completed\n", id);
    }
}