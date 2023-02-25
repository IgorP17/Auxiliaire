package udemy.alishev.adv.concurrent;

public class TestSync {
    private int counter;

    public static void main(String[] args) throws InterruptedException {
        TestSync testSync = new TestSync();
        testSync.doWork();
    }

    /*
        1: 100 -> 101 -> 101
        2: 100 -> 101 -> 101
        В результате оба потока увеличили значение, но только +1
     */
    private void doWork() throws InterruptedException {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10_000; i++) {
//                    counter = counter + 1; // не атомарная операция, занимает не 1 такт времени
                    increment();
                }
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10_000; i++) {
//                    counter = counter + 1;
                    increment();
                }
            }
        });

        thread1.start();
        thread2.start();

        thread1.join(); // подождать пока завершится поток thread1, поток main будет остановлен
        thread2.join(); // подождать пока завершится поток thread2, поток main будет остановлен

        System.out.println(counter);
    }

    // Только 1 поток может выполнить метод
    // Для синхронизации нужен объект со своим монитором - поэтому psvm TestSync testSync = new TestSync();
    // Явно не указываем объект, на котором будем синхронизировываться - используем this
    private synchronized void increment(){
        counter++;
    }
}
