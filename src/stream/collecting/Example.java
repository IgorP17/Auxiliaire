package stream.collecting;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import stream.Dish;

import static java.util.stream.Collectors.*;
import static stream.Example.menu;

public class Example {
    public static void main(String[] args) {
        // count
        long howManyDishes = menu.stream().collect(Collectors.counting());
//        long howManyDishes = menu.stream().count();
        System.out.println("Num of dishes: " + howManyDishes);

        // summarizing
        int totalCalories = menu.stream().collect(summingInt(Dish::getCalories));
        System.out.println("Total cals:" + totalCalories);

        double avgCalories =
                menu.stream().collect(averagingInt(Dish::getCalories));
        System.out.println("Avg cals: " + avgCalories);

        // statistic for calories
        IntSummaryStatistics menuStatistics =
                menu.stream().collect(summarizingInt(Dish::getCalories));
        System.out.println("IntSummaryStatistics: " + menuStatistics);

        // joining strings
        String shortMenu = menu.stream().map(Dish::getName).collect(joining(", "));
        System.out.println("Joined: " + shortMenu);

        //
        totalCalories = menu.stream().collect(reducing(0, Dish::getCalories, (i, j) -> i + j));
        System.out.println("Total cals: " + totalCalories);

        Optional<Dish> mostCalorieDish =
                menu.stream().collect(reducing(
                        (d1, d2) -> d1.getCalories() > d2.getCalories() ? d1 : d2));

        System.out.println("Most cals: " + mostCalorieDish.orElse(null));

        // GROUPING
        Map<Dish.Type, List<Dish>> dishesByType =
                menu.stream().collect(groupingBy(Dish::getType));
        System.out.println("Grouping:\n" + dishesByType);

        //

        Map<CaloricLevel, List<Dish>> dishesByCaloricLevel = menu.stream().collect(
                groupingBy(dish -> {
                    if (dish.getCalories() <= 400) return CaloricLevel.DIET;
                    else if (dish.getCalories() <= 700) return CaloricLevel.NORMAL;
                    else return CaloricLevel.FAT;
                } ));
        System.out.println("Custom:\n" + dishesByCaloricLevel);
    }
}

enum CaloricLevel { DIET, NORMAL, FAT }