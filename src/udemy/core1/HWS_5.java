package udemy.core1;

import java.util.*;

public class HWS_5 {
    /*
    Ввести с клавиатуры в список 5 слов.
Нужно подсчитать количество одинаковых слов в списке.
Результат нужно представить в виде словаря Map<String, Integer>,
где первый параметр – уникальная строка, а второй – число,
сколько раз данная строка встречалась в списке. Вывести содержимое словаря на экран.
     */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> list = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            list.add(scanner.nextLine());
        }

        Map<String, Integer> map = new HashMap<>();
        for (String s : list) {
            map.merge(s, 1, Integer::sum);
        }
        System.out.println("===");
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry);
        }
    }
}
