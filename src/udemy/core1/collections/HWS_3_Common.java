package udemy.core1.collections;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class HWS_3_Common {


    public static void main(String[] args) {
        dz3_8();
    }


    /**
     * <pre>
     * 1. Введи с клавиатуры 6 чисел, сохрани их в список и рассортируй по трём другим спискам:
     * Число делится на 3 (x%3==0), делится на 2 (x%2==0) и все остальные.
     * Числа, которые делятся на 3 и на 2 одновременно, например 6, попадают в оба списка.
     * 2. Создай метод printList - он должен выводить на экран все элементы списка с новой строки.
     * 3. Используя метод printList выведи эти три списка на экран.
     * Сначала тот, который для x%3, потом тот, который для x%2, потом последний.
     * </pre>
     */
    private static void dz3_8() {
        List<Integer> list = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < 6; i++) {
            list.add(Integer.valueOf(in.nextLine()));
        }
        List<Integer> l3 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        List<Integer> lOther = new ArrayList<>();

        for (int i = 0; i < 6; i++) {
            if (list.get(i) % 3 == 0 && list.get(i) % 2 == 0) {
                l2.add(list.get(i));
                l3.add(list.get(i));
            } else if (list.get(i) % 3 == 0) {
                l3.add(list.get(i));
            } else if (list.get(i) % 2 == 0) {
                l2.add(list.get(i));
            } else {
                lOther.add(list.get(i));
            }

        }

        printList(l3);
        printList(l2);
        printList(lOther);
    }

    private static void printList(List<Integer> list) {
        System.out.println();
        System.out.println(list);
    }

    /**
     * <pre>
     * 1. Создай список строк.
     * 2. Считай с клавиатуры 5 строк и добавь в список.
     * 3. Используя цикл, найди самую длинную строку в списке.
     * 4. Выведи найденную строку на экран.
     * 5. Если таких строк несколько, выведи каждую с новой строки.
     *
     * Задача следующая по анологии (нафига?)
     * 1. Создай список строк.
     * 2. Считай с клавиатуры 5 строк и добавь в список.
     * 3. Используя цикл, найди самую короткую строку в списке.
     * 4. Выведи найденную строку на экран.
     * 5. Если таких строк несколько, выведи каждую с новой строки.
     * </pre>
     */
    private static void dz3_7() {
        List<String> list = new LinkedList<>();
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            list.add(in.nextLine());
        }

        int maxLen = 0;
        // get max len
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).length() > maxLen)
                maxLen = list.get(i).length();
        }
        // sout max
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).length() == maxLen)
                System.out.println(list.get(i));
        }
    }

    /**
     * <pre>
     * Создать список чисел и заполнить его с консоли
     * Разбить список на два других: - в первый список сохранять чётные числа - во второй список сохранять нечётные числа
     * Вывести содержимое всех списков в консоль. Каждый новый список выводить с новой строки, в ряд.</pre>
     */
    private static void dz3_6() {
        Scanner in = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        String s;
        while (!(s = in.nextLine()).isBlank()) {
            list.add(Integer.parseInt(s));
        }

        List<Integer> listOdd = new LinkedList<>();
        List<Integer> listEven = new LinkedList<>();

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) % 2 == 0)
                listEven.add(list.get(i));
            else
                listOdd.add(list.get(i));
        }
        System.out.println("Even = " + listEven);
        System.out.println("Odd = " + listOdd);
    }

    /**
     * <pre>
     * Создать список чисел и заполнить его с консоли
     * Удалить все числа больше 5
     * </pre>
     */
    private static void dz3_5() {
        Scanner in = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        String s;
        while (!(s = in.nextLine()).isBlank()) {
            list.add(Integer.parseInt(s));
        }
        /* DO NOT USE THIS - we may have side effects with counter and actual size
          for (int i = 0; i < list.size(); i++) {
            if (list.get(i) > 5){
                list.remove(i);
            }
        }*/

        // We can try backward direction in cycle - (size-1, 0, i--) - it seems we can...

        // But I will use copy
        List<Integer> list2 = new LinkedList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) <= 5)
                list2.add(list.get(i));
        }

        // OR
        list.removeIf(x -> x > 5);

        System.out.println("List = " + list);
        System.out.println("List2 = " + list2);
    }

    /**
     * <pre>
     * Создать список чисел и заполнить его с консоли следующим образом:
     * чётные числа добавляют в конец списка, нечётные — в начало.
     * </pre>
     */
    private static void dz3_4() {
        Scanner in = new Scanner(System.in);
        List<Integer> list = new LinkedList<>();
        String s;
        while (!(s = in.nextLine()).isBlank()) {
            if (Integer.parseInt(s) % 2 == 0)
                list.add(list.size(), Integer.valueOf(s));
            else
                list.add(0, Integer.valueOf(s));
        }
        System.out.println(list);
    }

    /**
     * <pre>
     * Создать список из целых чисел и заполнить его с консоли
     * Ввод целых чисел с клавиатуры продолжается, пока не ввели пустую строку в консоли
     * После того, как ввод завершён - вывести все элементы списка в консоль
     * </pre>
     */
    private static void dz3_3() {
        Scanner in = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        String s;
        while (!(s = in.nextLine()).isBlank()) {
            list.add(Integer.valueOf(s));
        }
        System.out.println(list);
    }

    /**
     * <pre>
     * 1. Создай список строк.
     * 2. Добавь в него 5 различных строчек с консоли.
     * 3. Выведи его размер на экран.
     * 4. Используя цикл выведи его содержимое на экран, каждое значение с новой строки.
     * </pre>
     */
    private static void dz3_2() {
        Scanner in = new Scanner(System.in);
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add(in.next());
        }
        System.out.println("Size = " + list.size());
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

    }

    /**
     * <pre>
     * Создать список из чисел и заполнить его на 5 элементов с консоли
     * Вывести все элементы списка в консоль</pre>
     */
    private static void dz3_1() {
        Scanner in = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add(in.nextInt());
        }
        System.out.println(list);
    }


    // ----------------------------------------------------------------------------------------------------------------

    /**
     * Часть 1
     * <pre>
     * Создать массив на 5 чисел.
     * Заполнить его числами с клавиатуры.
     * Найти максимальное и минимальное числа в массиве.
     * Вывести на экран максимальное и минимальное числа через пробел. </pre>
     */
    private static void dz1_2() {
        /*BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String s;
        try {
            while ((s = bufferedReader.readLine()) != null) {
                System.out.println("aaa" + s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        int len = 5;
        Scanner in = new Scanner(System.in);
        int[] n = new int[len];
        for (int i = 0; i < len; i++) {
            n[i] = in.nextInt();
        }
        int min = n[0];
        int max = n[0];
        for (int i = 1; i < len; i++) {
            if (min > n[i])
                min = n[i];
            if (max < n[i])
                max = n[i];
        }
        System.out.println(max + " " + min);
    }

    /**
     * Часть 1
     * <pre>
     * Задача по алгоритмам.
     * Есть массив чисел, в котором все числа дублируются, кроме одного. Найдите число, которое не имеет дубликатов в массиве.
     * Пример ввода: {1, 2, 3, 3, 1, 4, 5, 7, 5, 6, 2, 4, 7, 6}
     * Пример вывода: 1</pre>
     */
    private static void dz1_1() {
        int[] n = new int[]{2, 3, 3, 4, 5, 1, 7, 5, 6, 2, 4, 7, 6};
        boolean isDupl = false;
        for (int i = 0; i < n.length; i++) {
            for (int j = 0; j < n.length; j++) {
                if ((i != j) && (n[i] == n[j])) {
                    isDupl = true;
                    break;
                }
            }
            if (!isDupl) {
                System.out.println("elem " + i + " = " + n[i]);
                break;
            }
            isDupl = false;
        }
    }
}
