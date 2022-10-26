package udemy.core1.collections;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class HWS_3_Sets {
    public static void main(String[] args) {
        dz6_3();
    }

    /**
     * <pre>
     * Часть 6
     * Ввести с клавиатуры 2 числа N и M.
     * Ввести N строк и заполнить ими список.
     * Переставить M первых строк в конец списка.
     * Вывести список на экран, каждое значение с новой строки.
     * </pre>
     */
    private static void dz6_3(){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter count of input lines:");
        int n = in.nextInt();
        System.out.println("Enter count of permutations:");
        int m = in.nextInt();
        List<String> list = new ArrayList<>();
        System.out.println("Please enter " + n + " lines:");
        for (int i = 0; i < n; i++) {
            list.add(in.next());
        }
        // кручу верчу
        for (int i = 0; i < m; i++) {
            list.add(list.size(), list.get(0));
            list.remove(0);
        }
        for (String s : list) {
            System.out.println(s);
        }
    }

    /**
     * <pre>
     * Часть 6
     * Ввести с клавиатуры 5 чисел и заполнить ими список.
     * Вывести их в обратном порядке.
     * Использовать только цикл for.
     * </pre>
     */
    private static void dz6_2() {
        Scanner in = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add(in.nextInt());
        }
        for (int i = list.size() - 1; i >= 0; i--) {
            System.out.println(list.get(i));
        }
    }

    /**
     * <pre>
     * Часть 6
     * Программа вводит строки, пока пользователь не введёт пустую строку (нажав enter).
     * Потом программа строит новый список. Если в строке чётное число букв, строка удваивается,
     * если нечётное – утраивается. Программа выводит содержимое нового списка на экран. Пример ввода:
     * Кот
     * Коты
     * Я
     * Пример вывода:
     * Кот Кот Кот
     * Коты Коты
     * Я Я Я
     * </pre>
     */
    private static void dz6_1() {
        Scanner in = new Scanner(System.in);
        List<String> list = new LinkedList<>();
        String s;
        while (!(s = in.nextLine()).isBlank()) {
            list.add(s);
        }
        List<String> result = new LinkedList<>();
        for (String s1 : list) {
            if (s1.length() % 2 == 0) {
                result.add(s1 + " " + s1);
            } else {
                result.add(s1 + " " + s1 + " " + s1);
            }
        }

        for (String s1 : result) {
            System.out.println(s1);
        }
    }
}
