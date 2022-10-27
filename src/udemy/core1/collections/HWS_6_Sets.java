package udemy.core1.collections;

import java.time.LocalDate;
import java.util.*;

public class HWS_6_Sets {
    public static void main(String[] args) {
//        dz6_8();
    }

    /**
     * <pre>
     * Часть 6
     * Реверс числа
     * 1) Ввести число с клавиатуры
     * 2) Сделать реверс этого числа и вывести результат в консоль
     * Пример: входные данные: -5544 результат: -4455
     * </pre>
     */
    public static long dz6_8(long number) {
        // WE WILL TEST IT WITH PARAMS TEST - see udemy.core1.collections.ReverseTest

//        Scanner scanner = new Scanner(System.in);
//        int number = scanner.nextInt(); - it seems we should use LONG
//        because reverse 1_230_456_789 will overflow INT type,

//        !!! it seems we should use BigInteger for very big inputs,
//        OR use not digit type as input, but String representation and reverse String

        boolean isNegative = false;
        if (number < 0) {
            isNegative = true; // remember this fact
            number = -number;
        }

        long target = 0;
        do {
            // shift current target to left, get last digit and add it
            target = 10 * target + number % 10;
            // since we have last digit - we don't need it in original
            number = number / 10;
        } while (number != 0);

        if (isNegative)
            target = -target;
//        System.out.println(target);

        return target;
    }

    /**
     * <pre>
     * Часть 6
     * Посчитать сколько дней прошло с начала года. Используйте класс LocalDate.
     * </pre>
     */
    private static void dz6_7() {
        LocalDate now = LocalDate.now();
        System.out.println(now);
        System.out.println(now.getDayOfYear()); // actually we must do -1, since today day not finished yet
        System.out.println(now.getDayOfMonth());
        System.out.println(now.getDayOfWeek());
    }

    /**
     * <pre>
     * Часть 6
     * Посчитать сколько прошло времени с начала сегодняшнего дня. Используйте класс Date
     * </pre>
     */
    private static void dz6_6() {
        Date date = new Date();
        Date date00 = new Date();
        date00.setHours(0);
        date00.setMinutes(0);
        date00.setSeconds(0);

        System.out.println(date);
        System.out.println(date00);

        long diff = date.getTime() - date00.getTime();
        int hh = (int) diff / (1000 * 60 * 60);
        int mi = (int) (diff / (1000 * 60)) % 60;
        int ss = (int) (diff - hh * 60 * 60 * 1000 - mi * 60 * 1000) / 1000;

        System.out.println("Hours: " + hh + " Min: " + mi + " Sec: " + ss);

    }

    /**
     * <pre>
     * Часть 6
     * Создать список строк. Ввести строки с клавиатуры и добавить их в список.
     * Вводить с клавиатуры строки, пока пользователь не введёт строку "end".
     * "end" не учитывать. Вывести строки на экран, каждую с новой строки.
     * </pre>
     */
    private static void dz6_5() {
        Scanner in = new Scanner(System.in);
        List<String> list = new LinkedList<>();
        String s;
        while (!(s = in.nextLine()).equals("end")) {
            list.add(s);
        }
        for (String s1 : list) {
            System.out.println(s1);
        }
    }

    /**
     * <pre>
     * Часть 6
     * Создать массив на 5 чисел. Заполнить его числами с клавиатуры.
     * Найти максимальное и минимальное числа в массиве.
     * Вывести на экран максимальное и минимальное числа через пробел.
     * </pre>
     */
    private static void dz6_4() {
        Scanner in = new Scanner(System.in);
        int[] massive = new int[5];
        for (int i = 0; i < massive.length; i++) {
            massive[i] = in.nextInt();
        }
        int max = massive[0];
        int min = massive[0];
        for (int i = 1; i < massive.length; i++) {
            if (max < massive[i])
                max = massive[i];
            if (min > massive[i])
                min = massive[i];
        }
        System.out.println(max + " " + min);
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
    private static void dz6_3() {
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
