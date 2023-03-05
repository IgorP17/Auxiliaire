package udemy.alishev.adv.concurrent;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestDeadlock {
    public static void main(String[] args) throws InterruptedException {
        DeadlockRunner deadlockRunner = new DeadlockRunner();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                deadlockRunner.first();
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                deadlockRunner.second();
            }
        });

        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        deadlockRunner.finished();
    }
}

class DeadlockRunner {
    private Account account1 = new Account();
    private Account account2 = new Account();
    private Lock lock1 = new ReentrantLock();
    private Lock lock2 = new ReentrantLock();
    Random random = new Random();

    private void takeLocks(Lock lock1, Lock lock2) {
        boolean firstLockTaken = false;
        boolean secondLockTaken = false;

        while (true) {
            try {
                firstLockTaken = lock1.tryLock();
                secondLockTaken = lock2.tryLock();
            } finally {
                if (firstLockTaken && secondLockTaken) {
                    return;
                }

                if (firstLockTaken) {
                    lock1.unlock();
                }
                if (secondLockTaken) {
                    lock2.unlock();
                }
                System.out.println("Dead Lock occurred!");
            }
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void first() {
        for (int i = 0; i < 10_000; i++) {
            takeLocks(lock1, lock2);
            try {
                Account.transfer(account1, account2, random.nextInt(100));
            } finally {
                lock1.unlock();
                lock2.unlock();
            }
            /*
                Чтобы избежать состояния гонки можно попробовать так
                for....
                synchronized(account1){
                    synchronized(account2){
                        do transfer
                    }
                }

                Или можно переписать с помощью ReentrantLock
                lock1.lock
                lock2.lock
                do transfer
                // finally
                lock1.unlock
                lock2.unlock

                Но может так что
                - первый поток лочит первый счет
                - второй поток лочит второй счет
                и
                - первый ждет 2й счет
                - второй ждет 1й счет

                Способы решения:
                1. не забирать Lock в разном порядке - т.е. все забирают lock1-N в одинаковом порядке
                2. ReentrantLock

             */
        }
    }

    public void second() {
        for (int i = 0; i < 10_000; i++) {
            takeLocks(lock2, lock1);
            try {
                Account.transfer(account2, account1, random.nextInt(100));
            } finally {
                lock2.unlock();
                lock1.unlock();
            }
        }
    }

    public void finished() {
        System.out.println("Balance 1 = " + account1.getBalance());
        System.out.println("Balance 2 = " + account2.getBalance());
        System.out.println("Total balance = " + (account1.getBalance() + account2.getBalance()));
    }
}

class Account {
    private int balance = 10_000;

    public void deposit(int amount) {
        this.balance += amount;
    }

    public void withdraw(int amount) {
        this.balance -= amount;
    }

    public int getBalance() {
        return balance;
    }

    public static void transfer(Account account1, Account account2, int amount) {
        account1.withdraw(amount);
        account2.deposit(amount);
    }
}