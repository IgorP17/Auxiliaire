package udemy.core1.recur;

import java.math.BigInteger;
import java.util.Map;
import java.util.TreeMap;

public class Fibonacci {

    static Map<Integer, BigInteger> cache = new TreeMap<>();

    public static void main(String[] args) {
        System.out.println("Fib 22 = " + fibonacci(22));
        System.out.println("Cached values:");
        for (Map.Entry<Integer, BigInteger> entry : cache.entrySet()) {
            System.out.println("Fib " + entry.getKey() + " = " + entry.getValue());
        }

    }

    private static BigInteger fibonacci(int n) {
        // Обработку негативных значений пока не делаем...
        // Возможно и не надо BigInteger как для факториала или и n сделать тогда уж BigInteger

        // если 0 или 1 - вернем их
        if (n == 0)
            return BigInteger.ZERO;
        if (n == 1)
            return BigInteger.ONE;

        BigInteger result;

        // если значение есть в кеше - вернем
        if (null != (result = cache.get(n)))
            return result;


        // иначе погнали вычислять
        result = fibonacci(n - 1).add(fibonacci(n - 2));

        // добавим в кеш
        cache.put(n, result);

        return result;
    }
}
