import java.util.*;

public class Collections {

    public static void main(String[] args) {
        // List
        // Set
        // Queue
        // Map

        // HashSet
        // ThreeSet - sorted
        // LinkedHashSet - ordered by addition
        // LinkedHashMap - ordered by addition


        // getting a mutable set from an immutable one
        Set<String> countries = new HashSet<>(List.of("India", "Japan", "Switzerland"));
        countries.addAll(List.of("India", "Germany", "Algeria"));
        System.out.println(countries); // [Japan, Algeria, Switzerland, Germany, India]

        countries.retainAll(List.of("Italy", "Japan", "India", "Germany"));
        System.out.println(countries); // [Japan, Germany, India]

        countries.removeAll(List.of("Japan", "Germany", "USA"));
        System.out.println(countries); // [India]

        System.out.println(countries.containsAll(Set.of("India", "Japan")));   // true

        Set<Integer> numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        Objects.equals(numbers, List.of(1, 2, 3)); // true

        Set<String> nameSet = new TreeSet<>(Arrays.asList("Mr.Green", "Mr.Yellow", "Mr.Red"));

        // maps
        Map<String, String> friendPhones = Map.of(
                "Bob", "+1-202-555-0118",
                "James", "+1-202-555-0220",
                "Katy", "+1-202-555-0175"
        );

        // printing names
        for (String name : friendPhones.keySet()) {
            System.out.println(name);
        }

        // printing phones
        for (String phone : friendPhones.values()) {
            System.out.println(phone);
        }

        // key + value
        // var == Map.Entry<String, String>
        for (var entry : friendPhones.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        friendPhones.forEach((name, phone) -> System.out.println(name + ": " + phone));
    }
}
