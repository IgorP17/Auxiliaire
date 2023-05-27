package stream;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static stream.Example.menu;

public class Example_3_Map {
    public static void main(String[] args) {
        // Applying a function to each element of a stream
        List<String> dishNames = menu.stream()
                .map(Dish::getName)
                .collect(toList());
        System.out.println(dishNames);

        // length
        List<String> words = Arrays.asList("Modern", "Java", "In", "Action");
        List<Integer> wordLengths = words.stream()
                .map(String::length)
                .collect(toList());
        System.out.println(wordLengths);

        //
        System.out.println("===");
        List<Integer> dishNameLengths = menu.stream()
                .map(Dish::getName)// ???????????????????
                .map(String::length)
                .collect(toList());
        System.out.println(dishNameLengths);

        // pairs
        System.out.println("===");
        List<Integer> numbers1 = Arrays.asList(1, 2, 3);
        List<Integer> numbers2 = Arrays.asList(3, 4);
        List<int[]> pairs =
                numbers1.stream()
                        .flatMap(i -> numbers2.stream()
                                .map(j -> new int[]{i, j})
                        )
                        .collect(toList());
        for (int i = 0; i < pairs.size(); i++) {
            System.out.println(Arrays.toString(pairs.get(i)));
        }

        // sum divided by 3
        System.out.println("===");
        List<int[]> pairs2 =
                numbers1.stream()
                        .flatMap(i ->
                                numbers2.stream()
                                        .filter(j -> (i + j) % 3 == 0)
                                        .map(j -> new int[]{i, j})
                        )
                        .collect(toList());
        for (int i = 0; i < pairs2.size(); i++) {
            System.out.println(Arrays.toString(pairs2.get(i)));
        }
    }
}
