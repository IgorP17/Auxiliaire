package threads;

public class TickTock {

    String state; // состояние часов

    synchronized void tick(boolean running) {
        if (!running) {// остановить часы
            state = "ticked";
            notify();//уведомить ожидающие потоки
            return;
        }
        System.out.print("Tick ");
        state = "ticked";
        notify();// позволить выполняться другому потоку
        try {
            while (!state.equals("tocked")) {
                wait();
            }
        } catch (InterruptedException e) {
            System.out.println("Прерывание потока");
        }
    }


    synchronized void tock(boolean running) {
        if (!running) {// остановить часы
            state = "tocked";
            notify();//уведомить ожидающие потоки
            return;
        }
        System.out.println("Tock");
        state = "tocked";
        notify();// позволить выполняться другому потоку
        try {
            while (!state.equals("ticked")) {
                wait();
            }
        } catch (InterruptedException e) {
            System.out.println("Прерывание потока");
        }
    }

}
