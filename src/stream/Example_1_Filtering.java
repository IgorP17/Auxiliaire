package stream;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static stream.Example.menu;

public class Example_1_Filtering {

    public static void main(String[] args) {
        // filtering with predicate
        List<Dish> vegetarianDishes =
                menu.stream()
                        .filter(Dish::isVegetarian)
                        .collect(toList());
        System.out.println(vegetarianDishes);

        // Filtering unique elements
        List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
        numbers.stream()
                .filter(i -> i % 2 == 0)
                .distinct()
                .forEach(System.out::println);
    }
}
