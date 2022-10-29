package udemy.core1.collections;

import java.util.*;

public class HWS_7 {
    public static void main(String[] args) {
        dz7_5();
    }

    /**
     * <pre>
     * Создать коллекцию HashMap<String, String>, занести туда 4 пары строк
     * Вывести содержимое коллекции на экран, каждый элемент с новой строки.
     * Пример вывода:
     * ключ - значение
     * ключ - значение
     * ключ - значение
     * ключ - значение
     * </pre>
     */
    private static void dz7_5(){

    }

    /**
     *  Ввести с клавиатуры 5 слов и выведи их в алфавитном порядке.
     */
    private static void dz7_4(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter 5 different strings:");
        Set<String> set = new TreeSet<>();
        for (int i = 0; i < 5; i++) {
            set.add(scanner.nextLine());
        }
        for (String s : set) {
            System.out.println(s);
        }
    }

    /**
     * Создать массив на 10 чисел. Заполнить его числами с клавиатуры. Вывести пять наибольших чисел.
     */
    private static void dz7_3(){
        Scanner scanner = new Scanner(System.in);
        Integer[] m = new Integer[10];
        System.out.println("Enter 10 digit values:");
        for (int i = 0; i < 10; i++) {
            m[i] = scanner.nextInt();
        }
        Arrays.sort(m, Collections.reverseOrder());
        for (int i = 0; i < m.length / 2; i++) {
            System.out.println(m[i]);
        }
    }

    /** <pre>
     * 1. Создай класс Human с полями имя (String), пол (boolean), возраст (int), дети (ArrayList<Human>).
     * 2. Создай объекты и заполни их так, чтобы получилось: два дедушки, две бабушки, отец, мать, трое детей.
     * 3. Вывести все объекты Human на экран.
     * Имя: ded Ivan, пол: мужской, возраст: 70, дети: papa Fedya
     * Имя: baba Masha, пол: женский, возраст: 65, дети: papa Fedya
     * Имя: papa Fedya, пол: мужской, возраст: 40, дети: son Lesha, son Misha, daughter Masha
     * </pre>
     */
    private static void dz7_2(){
        List<Human> list = new ArrayList<>();
        Human child1 = new Human("Child 1", true, 12, null);
        list.add(child1);
        Human child2 = new Human("Child 2", false, 8, null);
        list.add(child2);
        Human child3 = new Human("Child 3", true, 4, null);
        list.add(child3);

        Human father = new Human("Father", true, 45, new ArrayList<>(Arrays.asList(child1, child2, child3)));
        Human mother = new Human("Mother", false, 46, new ArrayList<>(Arrays.asList(child1, child2, child3)));
        list.add(father);
        list.add(mother);

        Human grPa1 = new Human("GrPa1", true, 66, new ArrayList<>(List.of(father)));
        Human grMa1 = new Human("GrMa1", false, 65, new ArrayList<>(List.of(father)));
        list.add(grPa1);
        list.add(grMa1);
        Human grPa2 = new Human("GrPa2", true, 68, new ArrayList<>(List.of(mother)));
        Human grMa2 = new Human("GrMa2", false, 67, new ArrayList<>(List.of(mother)));
        list.add(grPa2);
        list.add(grMa2);

        for (Human human : list) {
            System.out.println(human);
        }
    }

    /**<pre>
     * 1. Ввести с клавиатуры число N.
     * 2. Считать N целых чисел и заполнить ими список - метод getIntegerList.
     * 3. Найти минимальное число среди элементов списка - метод getMinimum.
     * </pre>
     */
    private static void dz7_1(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter count of numbers:");
        int count = scanner.nextInt();
        List<Integer> list = new ArrayList<>();
        getIntegerList(scanner, list, count);
        System.out.println(getMinimum(list));
    }

    private static void getIntegerList(Scanner scanner, List<Integer> integerList, int count){
        System.out.println("Enter " + count + " digits");
        for (int i = 0; i < count; i++) {
            integerList.add(scanner.nextInt());
        }
    }

    private static int getMinimum(List<Integer> list){
        int min = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (min > list.get(i))
                min = list.get(i);
        }
        return min;
    }
}
