package udemy.alishev.adv.collections;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetExample {
    public static void main(String[] args) {
        Set<String> hashSet= new HashSet<>();
        Set<String> linkedHashSet= new LinkedHashSet<>();
        Set<String> treeSet= new TreeSet<>();

        System.out.println("=== HashSet ===");
        testSet(hashSet);
        System.out.println("=== LinkedHashSet ===");
        testSet(linkedHashSet);
        System.out.println("=== TreeSet ===");
        testSet(treeSet);

        // пересечение
        Set<Integer> set1 = new HashSet<>();
        for (int i = 0; i < 6; i++) {
            set1.add(i);
        }
        Set<Integer> set2 = new HashSet<>();
        for (int i = 2; i < 8; i++) {
            set2.add(i);
        }

        HashSet<Integer> intersection = new HashSet<>(set1);
        intersection.retainAll(set2);
        System.out.println("=== Intersection ===");
        System.out.println(intersection);

        // объединение
        HashSet<Integer> union = new HashSet<>(set1);
        union.addAll(set2);
        System.out.println("=== Union ===");
        System.out.println(union);

        // разность (А без пересечения с Б)
        HashSet<Integer> aWOb = new HashSet<>(set1);
        aWOb.removeAll(set2);
        System.out.println("=== A without B ===");
        System.out.println(aWOb);

    }

    private static void testSet(Set<String> set){
        set.add("Mike");
        set.add("Katy");
        set.add("Tom");
        set.add("Alice");

        System.out.println(set);

        System.out.println(set.contains("Mike"));
        System.out.println(set.contains("Zed"));
    }
}
