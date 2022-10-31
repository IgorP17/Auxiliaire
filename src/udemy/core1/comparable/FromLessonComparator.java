package udemy.core1.comparable;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class FromLessonComparator {
    public static void main(String[] args) {
        // comparable в своем классе 1
        User user1 = new User("John", 42, 3000);
        User user2 = new User("Mark", 36, 3500);

        System.out.println(user1.compareTo(user2));

        Map<User, String> map = new TreeMap<>();
        map.put(user1, "text1");
        map.put(user2, "text2");

        for (Map.Entry<User, String> entry : map.entrySet()) {
            System.out.println(entry);
        }

        System.out.println("---");
        // 2 - использование компоратора, переопределяет сравнение в классе
        Comparator<User> comparator = new UserComparator();
        Map<User, String> map_var2 = new TreeMap<>(comparator);
        map_var2.put(user1, "text1");
        map_var2.put(user2, "text2");
        for (Map.Entry<User, String> entry : map_var2.entrySet()) {
            System.out.println(entry);
        }

        // 3 - использование последовательных компараторов
        // если 1й компаратор выдал 0, применить второй
        // new TreeMap<>(comparator.thenComparing(comparator2))
    }
}
