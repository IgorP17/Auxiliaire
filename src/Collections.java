import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Collections {

    public static void main(String[] args) {
        // HashSet
        // ThreeSet
        // LinkedHashSet

        // getting a mutable set from an immutable one
        Set<String> countries = new HashSet<>(List.of("India", "Japan", "Switzerland"));
        countries.addAll(List.of("India", "Germany", "Algeria"));
        System.out.println(countries ); // [Japan, Algeria, Switzerland, Germany, India]

        countries.retainAll(List.of("Italy", "Japan", "India", "Germany"));
        System.out.println(countries ); // [Japan, Germany, India]

        countries.removeAll(List.of("Japan", "Germany", "USA"));
        System.out.println(countries ); // [India]

        System.out.println(countries.containsAll(Set.of("India", "Japan")));   // true

        Set<Integer> numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        Objects.equals(numbers, List.of(1, 2, 3)); // true
    }
}
