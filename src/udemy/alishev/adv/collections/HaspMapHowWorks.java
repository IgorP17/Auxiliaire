package udemy.alishev.adv.collections;

import java.util.HashMap;
import java.util.Map;

public class HaspMapHowWorks {
    /*
     * Node<K, V>[] table
     * int hash;
     * K key;
     * V value;
     * Node<K,V> next; This is linked list
     *
     * [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15]
     * PUT:
     * hash(key)
     * index = hash & (n - 1) // n = 16 -> остаток от деления на 16
     * put("KING", 100)
     * hash("KING") = 2306967
     * index = 7
     *
     * put("KING2", 100)
     * LET hash is 2306967, index = 7
     *
     * Тогда в 7 бакете будет список Node(KING) next -> Node(KING2)
     *
     * GET:
     * Вычисляем остаток деления хеша и берем ячейку.
     * Если в ячейке список:
     *      берем хеш ключа и сравниваем равен ли у объекта (если нет идем дальше)
     *      если равен то возможна коллизия - вызываем equals
     */

    public static void main(String[] args) {
        System.out.println("AaAaAa".hashCode());
        System.out.println("AaAaAa".hashCode() & 15);
        System.out.println("AaAaBB".hashCode());
        System.out.println("AaAaBB".hashCode() & 15);

        Map<String, Integer> hashMap = new HashMap<>();
        hashMap.put("AaAaAa", 1);
        hashMap.put("AaAaBB", 1);

        for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }

    }
}
