package udemy.alishev.adv.concurrent;

import java.util.Random;
import java.util.concurrent.*;

public class TestCallableFuture {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(1);

        Future<Integer> future = executorService.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                System.out.println("Started");
                Thread.sleep(200);
                System.out.println("Finished");
                Random random = new Random();
                int rnd = random.nextInt(10);
                if (rnd < 5){
                    throw new Exception("Something wrong!");
                }
                return rnd;
            }
        });
        executorService.shutdown();
        try {
            int result = future.get(); // ждет окончания исполнения потока
            System.out.println(result);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            Throwable ex = e.getCause();
            System.out.println(ex.getMessage());
        }

    }
}
