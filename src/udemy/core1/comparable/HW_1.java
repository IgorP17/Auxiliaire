package udemy.core1.comparable;

import java.util.*;

public class HW_1 {
    public static void main(String[] args) {
        dz1();
    }

    /**
     * <pre>
     * Ввести с клавиатуры 5 строчек и подсчитать в них количество различных букв (для 33 букв алфавита).
     * Вывести результат на экран.
     * Используй метод класса String - toCharArray();
     * Пример ввода:
     * String text = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
     * String text2 = "абв";
     * String text3 = "ддд";
     * String text4 = "яяа";
     * String text5 = "вввв";
     * Пример вывода:
     * а 3
     * б 2
     * в 6
     * г 1
     * д 4
     * …
     * я 3
     * </pre>
     */

    private static void dz1() {
        // Мы не будем использовать ввод с in, используем как в примере
        String text = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
        /*char[] charsTTTT = text.toCharArray();
        for (int i = 0; i < charsTTTT.length; i++) {
            System.out.println(charsTTTT[i] + "=" + (int) charsTTTT[i]);
        }*/

        String text2 = "абв";
        String text3 = "ддд";
        String text4 = "яяа";
        String text5 = "вввв";
        String all = text + text2 + text3 + text4 + text5;
        char[] chars = all.toCharArray();
        Map<Character, Integer> map = new TreeMap<>();

        // TODO БЛЯДЬ ПОЧЕМУ Ё то в конце......
        // СУКА ЕБАТЬ
        // е=1077
        // ё=1105 !!!
        // ж=1078
        // ...
        // я=1103
        for (int i = 0; i < chars.length; i++) {
            if (map.containsKey(chars[i])) {
                map.put(chars[i], map.get(chars[i]) + 1);
            } else {
                map.put(chars[i], 1);
            }
        }

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            System.out.println(entry);
        }
    }
}
