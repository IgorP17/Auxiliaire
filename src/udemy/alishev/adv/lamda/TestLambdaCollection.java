package udemy.alishev.adv.lamda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TestLambdaCollection {
    public static void main(String[] args) {
        int[] arr = new int[10];
        List<Integer> list = new ArrayList<>();
        fillArr(arr);
        fillList(list);

        System.out.println(list);
        System.out.println(Arrays.toString(arr));

/*        for (int i = 0; i < 10; i++) {
            arr[i] = arr[i] * 2;
            list.set(i, list.get(i) * 2);
        }*/
        // map
        arr = Arrays.stream(arr).map(a -> a * 2).toArray(); // массив превращается в поток данных, map - проходимся по массиву и сопоставляем новое значение
        list = list.stream().map(a -> a * 2).collect(Collectors.toList());

        System.out.println(list);
        System.out.println(Arrays.toString(arr));

        // filter
        int[] arr2 = new int[10];
        List<Integer> list2 = new ArrayList<>();
        fillArr(arr2);
        fillList(list2);

        arr2 = Arrays.stream(arr2).filter(a -> a % 2 == 0).toArray();
        list2 = list2.stream().filter(a -> a % 2 == 0).collect(Collectors.toList());
        System.out.println(list2);
        System.out.println(Arrays.toString(arr2));

        // for each
        Arrays.stream(arr2).forEach(a -> System.out.println(a));
        Arrays.stream(arr2).forEach(System.out::println);

        // reduce
        int[] arr3 = new int[10];
        List<Integer> list3 = new ArrayList<>();
        fillArr(arr3);
        fillList(list3);

        // acc - аккумулятор, b - текущий элемент; acc = 0, если не указано, то acc = первое значение, стартуем со второго
        int sum = Arrays.stream(arr3).reduce(0, (acc, b) -> acc + b); // .getAsInt
        int product = list3.stream().reduce((acc, b) -> acc * b).get();

        System.out.println(sum);
        System.out.println(product);

        // цепочки
        int[] arr4 = new int[10];
        fillArr(arr4);
        arr4 = Arrays.stream(arr4)
                .filter(a -> a % 2 != 0)
                .map(a -> a * 2).toArray();
        System.out.println(Arrays.toString(arr4));
    }

    private static void fillList(List<Integer> list) {
        for (int i = 0; i < 10; i++) {
            list.add(i + 1);
        }
    }

    private static void fillArr(int[] arr) {
        for (int i = 0; i < 10; i++) {
            arr[i] = i + 1;
        }
    }


}
