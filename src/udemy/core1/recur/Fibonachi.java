package udemy.core1.recur;

import java.math.BigInteger;
import java.util.Map;
import java.util.TreeMap;

public class Fibonachi {

    static Map<Integer, BigInteger> cache = new TreeMap<>();

    public static void main(String[] args) {
        System.out.println("Fib 22 = " + fibonachi(22));
        System.out.println("Cached values:");
        for (Map.Entry<Integer, BigInteger> entry : cache.entrySet()) {
            System.out.println("Fib " + entry.getKey() + " = " + entry.getValue());
        }

    }

    private static BigInteger fibonachi(int n) {
        // обработку негативных значений пока не делаем...

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
        result = fibonachi(n - 1).add(fibonachi(n - 2));

        // добавим в кеш
        cache.put(n, result);

        return result;
    }
}
