package udemy.core1.collections;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Maps {
    public static void main(String[] args) {
        hashMapImpl();

    }

    /**
     * Внутри массив с нодами
     * Корзины - по умолчанию на 16 ячеек
     * Load Factor - 0.75 - при заполнении 75% увеличиваем размер в 2 раза (?)
     * <p>
     * Как опрделяется индекс ячейки:
     * Для индекса корзины используется hash code ключа
     * Для Integer используется значение в объекте
     * <p>
     * Берем хеш код
     * ищем остаток от деления на кол-во корзин и в тот индекс добавляем Ноду
     * --
     * Коллизии - когда я ячейку попадает более 1й пары (key-value)
     * В этом случае в ячейке создается Linked list в котором будет 2 пары (key-value)
     * Но при этом проверяется ключ от добавляемого
     * Если хеш ключей совпадают и equals == true- то происходит замена на новое значение
     * т.е. put(1, "x"), put(1,"buya") -> будет буйа
     * --
     * Почему так - хеши могут совпасть у разных инстансов, но при этом они разные т.е. equals == false
     * Т.е. если equals == true --> хеши совпадают
     * Но если equals == false --> это не значит что хеши не совпадают
     * --
     * При большом количестве коллизий связаный список может заменяться на сбалансированое дерево
     */
    private static void hashMapImpl() {
        Map<Integer, String> map = new HashMap<>();
        /*
        0[] 1[] 2[] 3[] 4[] 5[] 6[] 7[] 8[] 9[] 10[] 11[] 12[] 13[] 14[] 15[] - 16 корзин
        17 % 16 = 1
         */
        map.put(17, "text1");
        /*
        0[] 1[17] 2[] 3[] 4[] 5[] 6[] 7[] 8[] 9[] 10[] 11[] 12[] 13[] 14[] 15[] - 16 корзин
        19 % 16 = 3
         */
        map.put(19, "text2");
        /*
        0[] 1[17] 2[] 3[19] 4[] 5[] 6[] 7[] 8[] 9[] 10[] 11[] 12[] 13[] 14[] 15[] - 16 корзин
        4 % 16 = 4
         */
        map.put(4, "text3");
        /*
        0[] 1[17] 2[] 3[19] 4[4] 5[] 6[] 7[] 8[] 9[] 10[] 11[] 12[] 13[] 14[] 15[] - 16 корзин
         */

        // коллизия
        map.put(35, "text 35");
        /*
        35 % 16 = 3
        хеши ключей НЕ совпадают 19 != 35
        в случае совпадения нового хеша и старого происходит обновление/замена
        0[] 1[17] 2[] 3[19, 35] 4[4] 5[] 6[] 7[] 8[] 9[] 10[] 11[] 12[] 13[] 14[] 15[] - 16 корзин
         */

        // null ключ - всегда в 0 ячейку, но в случае коллизий он может быть 2м в связаном списке
        map.put(16, "text 0 16");
        map.put(null, "text null");
        /*
        0[16, null] 1[17] 2[] 3[19, 35] 4[4] 5[] 6[] 7[] 8[] 9[] 10[] 11[] 12[] 13[] 14[] 15[] - 16 корзин
         */

        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println(entry);
        }
    }

    private static void base() {
        Map<String, Integer> map = new HashMap<>();
        map.put("text", 5);
        map.put("text1", 7);
        map.put(null, 5);

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry);
//            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
        System.out.println();
        Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> next = iterator.next();
//            System.out.println(next.getKey() + );
            System.out.println(next);
        }
    }
}
