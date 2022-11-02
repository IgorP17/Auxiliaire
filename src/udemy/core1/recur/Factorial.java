package udemy.core1.recur;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class Factorial {

    static Map<Integer, BigInteger> cache = new HashMap<>(); // для кешированого !

    public static void main(String[] args) {
        System.out.println("4! = " + factorial(4));
        System.out.println("5! = " + factorial(5));
        System.out.println("6! = " + factorial(6));
        System.out.println("== Use recur");
        System.out.println("4! = " + factorialRec(4));
        System.out.println("5! = " + factorialRec(5));
        System.out.println("6! = " + factorialRec(6));
        System.out.println("== Use recur + BigInteger");
        System.out.println("100! = " + factorialBig(100));
        System.out.println("=== Use resur + BigInteger + cache");
        System.out.println("100! = " + factorialBigCached(100));
        System.out.println("120! = " + factorialBigCached(120));
        System.out.println("90! = " + factorialBigCached(90));
        System.out.println("6! = " + factorialBigCached(6));

    }

    /**
     * Факториал с помощью цикла
     *
     * @param n число факториала
     * @return факториал
     */
    private static int factorial(int n) {
        int res = 1;
        for (int i = 1; i <= n; i++) {
            res = res * i;
        }
        return res;
    }

    /**
     * Факториал через рекурсию
     *
     * @param n число факториала
     * @return факториал
     */
    private static int factorialRec(int n) {
        if (n == 1)
            return 1;
        return n * factorialRec(n - 1);
        /*
            для 4
            fact(4)     ->      4 * fact(3)
            fact(3)     ->      3 * fact(2)
            fact(2)     ->      2 * fact(1)
            fact(1)     ->      return 1
         */
    }

    /**
     * Факториал через рекурсию с использованием BigInteger
     *
     * @param n число факториала
     * @return факториал
     */
    private static BigInteger factorialBig(int n) {
        if (n == 0)
            return BigInteger.ONE;
        return BigInteger.valueOf(n).multiply(factorialBig(n - 1));
    }


    /**
     * Факториал через рекурсию с использованием BigInteger и кеша
     *
     * @param n число факториала
     * @return факториал
     */
    private static BigInteger factorialBigCached(int n) {
        BigInteger result;
        if (n == 1)
            return BigInteger.ONE;

        if (null != (result = cache.get(n)))
            return result;

        result = BigInteger.valueOf(n).multiply(factorialBigCached(n - 1));

        cache.put(n, result);

        return result;
    }
}
