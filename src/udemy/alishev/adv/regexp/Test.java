package udemy.alishev.adv.regexp;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        /*
            \\d - одна цифра
            \\w - одна буква
            +   - 1 или более
            *   - 0 или более
            ?   - 0 или 1 символ до: -?\d+ число с - или без минуса

            (x|y|z)  - одно из значений: (-|\+)?\d+
            [a-zA-z] - все возможные английские буквы
            [0-9]    - == \\d
            [abc] = (a|b|c)
            [^abc]   - символ кроме abc: [^abc]*

            .        - любой символ
            {2}      - точное количество \\d{2} - 2 цифры
            {2,}     - от 2 до бесконечности
            {2, 4}   - от 2х до 4х
         */
        String a = "-1234";
        String b = "+1234";
        System.out.println(a.matches("(-|\\+)?\\d+"));
        System.out.println(b.matches("(-|\\+)?\\d+"));
        String c = "aaaa87Bf-123";
        System.out.println(c.matches("[a-zA-z78]+(-|\\+)?\\d+"));
        String d = "1sdf";
        System.out.println(d.matches("[^abc]*"));

        String url = "http://www.google.com";
        System.out.println(url.matches("http://www\\..+\\.(com|ru)"));
        System.out.println("==================================");

        String s1 = "Hello777there88888hey";
        System.out.println(Arrays.toString(s1.split("\\d+")));

        String s2 = "Hello there hey";
        System.out.println(s2.replaceAll("\\s", "!!!"));

    }
}
