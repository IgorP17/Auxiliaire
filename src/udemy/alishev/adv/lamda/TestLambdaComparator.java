package udemy.alishev.adv.lamda;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TestLambdaComparator {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Hello");
        list.add("A");
        list.add("Goodbye");


       /* list.sort(new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                if (s1.length() > s2.length()){
                    return 1;
                }
                else if (s1.length() < s2.length()) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });*/

        Comparator<String> comparator = (s1, s2) -> {
            if (s1.length() > s2.length()) return 1;
            else if (s1.length() < s2.length()) return -1;
            else return 0;
        };

        list.sort(comparator);

        System.out.println(list);
    }
}
