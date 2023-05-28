package stream;

import java.util.OptionalInt;
import java.util.stream.IntStream;

import static stream.Example.menu;

public class Example_6_NumStream {
    public static void main(String[] args) {
        int calories = menu.stream()
                .mapToInt(Dish::getCalories)
                .sum();
        System.out.println("Total calories = " + calories);

        OptionalInt maxCalories = menu.stream()
                .mapToInt(Dish::getCalories)
                .max();
        int max = maxCalories.orElse(1);
        System.out.println("Max calories = " + max);

        // ranges
        IntStream evenNumbers = IntStream.rangeClosed(1, 100) // or range - not include
                .filter(n -> n % 2 == 0);
        System.out.println(evenNumbers.count());

    }
}
