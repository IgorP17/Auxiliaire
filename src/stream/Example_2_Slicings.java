package stream;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static stream.Example.menu;

public class Example_2_Slicings {

    private static List<Dish> specialMenu = Arrays.asList(
            new Dish("seasonal fruit", true, 120, Dish.Type.OTHER),
            new Dish("prawns", false, 300, Dish.Type.FISH),
            new Dish("rice", true, 350, Dish.Type.OTHER),
            new Dish("chicken", false, 400, Dish.Type.MEAT),
            new Dish("french fries", true, 530, Dish.Type.OTHER));

    public static void main(String[] args) {
        List<Dish> slicedMenu1
                = specialMenu.stream()
                .takeWhile(dish -> dish.getCalories() < 320)
                .collect(toList());
        System.out.println(slicedMenu1);

        List<Dish> slicedMenu2
                = specialMenu.stream()
                .dropWhile(dish -> dish.getCalories() < 320) // compliment to takeWhile
                .collect(toList());
        System.out.println(slicedMenu2);

        // skipping
        List<Dish> dishes = menu.stream()
                .filter(d -> d.getCalories() > 300)
                .skip(2)                        // skip first 2 elements
                .collect(toList());
        System.out.println(dishes);

    }
}
