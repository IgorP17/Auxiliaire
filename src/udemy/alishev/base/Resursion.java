package udemy.alishev.base;

public class Resursion {
    public static void main(String[] args) {
        countDown(5);
        System.out.println(factorial(5));
    }

    private static void countDown(int n) {
        System.out.println(n);
        if (n == 0) return;
        countDown(n - 1);
    }

    private static int factorial(int n) {
        if (n == 0)
            return 1;
        return n * factorial(n - 1);
    }
}
