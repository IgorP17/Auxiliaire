package udemy.alishev.adv.concurrent;

import java.util.Scanner;

public class TestWaitNotify {
    public static void main(String[] args) {
        WaitAndNotify waitAndNotify = new WaitAndNotify();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    waitAndNotify.produce();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    waitAndNotify.consume();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
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
    }
}

class WaitAndNotify {
    public void produce() throws InterruptedException {
        synchronized (this) {
            System.out.println("Producer thread started ...");
            wait(); // wait имеет смысл только внутри синхр блока, по умолчанию вызывается на объекте this(даже если sync(obj)) -  (this.wait)
            //  если хотим не на this - то lock.wait()
            // 1 - отдаем intrinsic lock - другие объекты использующие этот объект могут забрать и поработать
            // 2 - ждем пока не будет вызван notify
            // wait(timeout) - подождать таймаут и продолжить выполнение, если монитор свободен
            System.out.println("Producer thread resumed....");
        }
    }

    public void consume() throws InterruptedException {
        Thread.sleep(2000);
        Scanner scanner = new Scanner(System.in);
        synchronized (this){
            System.out.println("Waiting for return key pressed ...");
            scanner.nextLine();
            notify(); // notifyAll - пробудить всех кто ждет
            // sync на том же самом объекте
            // не освобождает монитор
            Thread.sleep(2000);
            System.out.println("Sleep");
        }
    }
}
