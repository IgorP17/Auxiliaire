package stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static stream.Example.menu;

public class Example_4_FindMatch {
    public static void main(String[] args) {
        // 1. “Is there an element in the
        //stream matching the given predicate?”
        if(menu.stream().anyMatch(Dish::isVegetarian)) {
            System.out.println("The menu is (somewhat) vegetarian friendly!!");
        }

        // all match
        boolean isHealthy = menu.stream()
                .allMatch(dish -> dish.getCalories() < 1000);
        System.out.println(isHealthy);

        // none match
        isHealthy = menu.stream()
                .noneMatch(d -> d.getCalories() >= 1000);
        System.out.println(isHealthy);

        ///////////////FIND
        // Find any
        Optional<Dish> dish =
                menu.stream()
                        .filter(Dish::isVegetarian)
                        .findAny();
        System.out.println("=== Vegetarian:\n" + (dish.isPresent() ? dish.get() : "NONE"));

        // or
        menu.stream()
                .filter(Dish::isVegetarian)
                .findAny()
                .ifPresent(dish2 -> System.out.println(dish2.getName()));

        // Find first
        System.out.println("=== Find first:");
        List<Integer> someNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Optional<Integer> firstSquareDivisibleByThree =
                someNumbers.stream()
                        .map(n -> n * n)
                        .filter(n -> n % 3 == 0)
                        // 9
                        .findFirst();
        System.out.println(firstSquareDivisibleByThree.orElse(-1)); // if present then value else -1

        //
    }
}
