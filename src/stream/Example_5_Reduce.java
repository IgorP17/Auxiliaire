package stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import static stream.Example.menu;

public class Example_5_Reduce {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5);


        // sum
        int sum = numbers.stream().reduce(0, (a, b) -> a + b);
        System.out.println("Sum = " + sum);
        int product = numbers.stream().reduce(1, (a, b) -> a * b);
        System.out.println("Prod = " + product);

        // Optional<Integer> sum = numbers.stream().reduce((a, b) -> (a + b)); // WO initial value

        // max and min
        Optional<Integer> max = numbers.stream().reduce(Integer::max);
        Optional<Integer> min = numbers.stream().reduce((a, b) -> Math.min(a,b));
//        Optional<Integer> min = numbers.stream().reduce((a, b) -> x < y ? x : y);
        System.out.println("Max = " + (max.orElse(0)));
        System.out.println("Min = " + (min.orElse(0)));

        //
        int count = menu.stream()
                .map(d -> 1)
                .reduce(0, Integer::sum);
        System.out.println("Menu count = " + count);

        //
        Optional<Dish> minCal = menu.stream()
                .min((d1, d2) -> (d1.getCalories() < d2.getCalories() ? d1 : d2).getCalories());
        System.out.println(minCal.orElse(null));

    }
}
