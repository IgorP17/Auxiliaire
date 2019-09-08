package threads;

public class ThreadCom {
    public static void main(String[] args) {
        TickTock tt = new TickTock();
        TickTockThread thread1 = TickTockThread.createAndStart("Tick", tt);
        TickTockThread thread2 = TickTockThread.createAndStart("Tock", tt);
        try {
            thread1.thrd.join();
            thread2.thrd.join();

        } catch (InterruptedException e) {
            System.out.println("Прерывание основного потока");
        }
    }
}
