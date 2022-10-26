package udemy.core1.collections;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class Sets {
    public static void main(String[] args) {
        System.out.println("=== HashSet ===");
        Set<String> set = new HashSet<>();
        set.add("text");
        set.add("text1");
        set.add("text2");
        set.add("text1");

        // use iter because no indexes in Set
        for (String s : set) {
            System.out.println(s);
        }

        System.out.println("=== TreeSet ===");
        // allowed store elements in sorted way
        // Comparator for Strings already defined
        Set<String> treeSet = new TreeSet<>();
        treeSet.add("text");
        treeSet.add("ac");
        treeSet.add("text1");
        treeSet.add("ab");
        treeSet.add("text2");
        for (String s : treeSet) {
            System.out.println(s);
        }

        System.out.println("=== LinkedHashSet ===");
        // allowed store elements in sorted way by add order
        Set<String> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add("text");
        linkedHashSet.add("ac");
        linkedHashSet.add("text1");
        linkedHashSet.add("ab");
        linkedHashSet.add("text2");
        for (String s : linkedHashSet) {
            System.out.println(s);
        }

    }
}
