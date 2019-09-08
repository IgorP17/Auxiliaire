package threads;

public class TickTockThread implements Runnable {

    Thread thrd;
    TickTock ttOb;

    // Конструктор
    TickTockThread(String name, TickTock tt) {
        thrd = new Thread(this, name);
        ttOb = tt;
    }

    // Создание и запуск с помощью фабричного метода
    public static TickTockThread createAndStart(String name, TickTock tt) {
        TickTockThread tickTockThread = new TickTockThread(name, tt);
        tickTockThread.thrd.start();
        return tickTockThread;
    }

    @Override
    public void run() {
        if (thrd.getName().compareTo("Tick") == 0){
            for (int i = 0; i < 5; i++) {
                ttOb.tick(true);
            }
            ttOb.tick(false);
        } else {
            for (int i = 0; i < 5; i++) {
                ttOb.tock(true);
            }
            ttOb.tock(false);
        }
    }
}
