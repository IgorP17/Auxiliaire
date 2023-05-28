package stream;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * Modern Java in Action 2nd edition
 */
public class Example {

    public static final List<Dish> menu = Arrays.asList(
            new Dish("pork", false, 800, Dish.Type.MEAT),
            new Dish("beef", false, 700, Dish.Type.MEAT),
            new Dish("chicken", false, 400, Dish.Type.MEAT),
            new Dish("french fries", true, 530, Dish.Type.OTHER),
            new Dish("rice", true, 350, Dish.Type.OTHER),
            new Dish("season fruit", true, 120, Dish.Type.OTHER),
            new Dish("pizza", true, 550, Dish.Type.OTHER),
            new Dish("prawns", false, 300, Dish.Type.FISH),
            new Dish("salmon", false, 450, Dish.Type.FISH));


    public static void main(String[] args) {
        List<String> threeHighCaloricDishNames =
                menu.stream()
                        .filter(dish -> dish.getCalories() > 300) // filter calories
                        .map(Dish::getName)                       // get names of dishes Method reference == eq d -> d.getName
                        .limit(3)                              // select only 3 first record
                        .collect(toList());                      // store result in list
        System.out.println("=== " + threeHighCaloricDishNames);

        //
        threeHighCaloricDishNames =
                menu.parallelStream()                             // parallel
                        .filter(dish -> dish.getCalories() > 300) // filter calories
                        .map(Dish::getName)                       // get names of dishes Method reference == eq d -> d.getName
                        .limit(3)                              // select only 3 first record
                        .collect(toList());                      // store result in list
        System.out.println("=== Parallel " + threeHighCaloricDishNames);


        //
        List<String> names =
                menu.stream()
                        .filter(dish -> {
                            System.out.println("filtering:" + dish.getName());
                            return dish.getCalories() > 300;
                        })
                        .map(dish -> {
                            System.out.println("mapping:" + dish.getName());
                            return dish.getName();
                        })
                        .limit(3)
                        .sorted()
                        .collect(toList());
        System.out.println(names);

        /*
        Intermediate operations:
            filter
            map
            limit
            sorted
            distinct
        Terminal operations
            forEach
            count
            collect


         ===
         filter
         distinct
         takeWhile
         dropWhile
         skip
         limit
         map
         flatMap
         sorted

         anyMatch
         noneMatch
         allMatch
         findAny
         findFirst
         forEach
         collect
         reduce
         count
         */

    }

}
