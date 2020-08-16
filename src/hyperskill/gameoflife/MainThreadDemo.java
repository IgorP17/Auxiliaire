package hyperskill.gameoflife;

public class MainThreadDemo {
    public static void main(String[] args) {
        Thread t = Thread.currentThread(); // main thread

        System.out.println("Name: " + t.getName());
        System.out.println("ID: " + t.getId());
        System.out.println("Alive: " + t.isAlive());
        System.out.println("Priority: " + t.getPriority());
        System.out.println("Daemon: " + t.isDaemon());

        t.setName("my-thread");
        System.out.println("New name: " + t.getName());
    }
}

/*
Extend thread
Implement (CountingTask) -> Thread counter = new Thread(new CountingTask());

1. thread.start instead of thread.run!

2. Join
The join method forces the current thread to wait for the completion of another thread on which the method was called.
In the following example, the string "do something else" will not be printed until the thread terminates.

Thread thread = ...
thread.start(); // start thread

System.out.println("Do something useful");

thread.join();  // waiting for thread to die

System.out.println("Do something else");

 */



/*
Another way to make the current thread sleep is to use the special class TimeUnit from the package java.util.concurrent
TimeUnit.SECONDS.sleep(2) performs Thread.sleep for 2 seconds;
Thread.sleep(TimeUnit.SECONDS.sleep(2))
 */

/*
Invoking the interrupt() method on an instance of the Thread class sets its interrupted flag as true.

    @Override
    public void run() {
        while (!isInterrupted()) {
.....
If you prefer implementing Runnable rather than extending Thread directly,
you may use the static method Thread.interrupted() inside the run method.
 */
