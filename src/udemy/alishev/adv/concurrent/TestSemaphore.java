package udemy.alishev.adv.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class TestSemaphore {
    // нужен для ограничения доступа к ресурсу
    public static void main(String[] args) throws InterruptedException {
//        Semaphore semaphore = new Semaphore(3);// сколько потоков могут одновременно работать с ресурсом
        ExecutorService executorService = Executors.newFixedThreadPool(100);
        Connection connection = Connection.getInstance();
        for (int i = 0; i < 100; i++) {
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        connection.doWorkWithSemaphore();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            });
        }
        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.DAYS);
    }
}

class Connection {
    private static Connection connection = new Connection();
    private int connectionsCount = 0;
    private Semaphore semaphore = new Semaphore(10);

    private Connection() {

    }

    public static Connection getInstance() {
        return connection;
    }

    public void doWorkWithSemaphore() throws InterruptedException {
        semaphore.acquire();
        try {
            doWork();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
    }

    private void doWork() throws InterruptedException {
        synchronized (this) {
            connectionsCount++;
            System.out.println(connectionsCount);
        }
        Thread.sleep(3000);
        synchronized (this) {
            connectionsCount--;
        }
    }
}
