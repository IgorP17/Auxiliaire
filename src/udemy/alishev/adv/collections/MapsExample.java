package udemy.alishev.adv.collections;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapsExample {

    public static void main(String[] args) {
        // не гарантирует порядок хранения
        Map<Integer, String> hashMap = new HashMap<>();
        // сохраняет порядок добавления
        Map<Integer, String> linkedHashMap = new LinkedHashMap<>();
        // сортировка по ключу
        Map<Integer, String> treeMap = new TreeMap<>();

        System.out.println("=== HashMap ===");
        testMap(hashMap);
        System.out.println("=== LinkedHashMap ===");
        testMap(linkedHashMap);
        System.out.println("=== TreeMap ===");
        testMap(treeMap);
    }

    public static void testMap(Map<Integer, String> map) {
        map.put(39, "Bob");
        map.put(12, "Mike");
        map.put(78, "Tom");
        map.put(0, "Alice");
        map.put(1500, "Carol");
        map.put(7, "Don");

        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }
}
