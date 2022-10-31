package udemy.core1.collections;

import java.util.*;

public class HWS_8 {
    public static void main(String[] args) {
        dz8_4();
    }

    /**
     * <pre>
     * Программа вводит с клавиатуры имя месяца и выводит его номер на экран в виде:
     * «May is 5 month».
     * map.put("January",1);
     * map.put("February",2);
     * map.put("March",3);
     * map.put("April",4);
     * map.put("May",5);
     * map.put("June",6);
     * map.put("July",7);
     * map.put("August",8);
     * map.put("September",9);
     * map.put("October",10);
     * map.put("November",11);
     * map.put("December",12);
     * </pre>
     */
    private static void dz8_4() {
        Map<String, Integer> map = new HashMap<>();
        map.put("January", 1);
        map.put("February", 2);
        map.put("March", 3);
        map.put("April", 4);
        map.put("May", 5);
        map.put("June", 6);
        map.put("July", 7);
        map.put("August", 8);
        map.put("September", 9);
        map.put("October", 10);
        map.put("November", 11);
        map.put("December", 12);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter month:");
        String s = scanner.nextLine();

        System.out.println(s + " is " + map.get(s) + " month");
    }

    /**
     * <pre>
     * Удалить людей, имеющих одинаковые имена
     * Создать словарь (Map<String, String>) занести в него десять записей по принципу
     * «фамилия» - «имя».
     * Удалить людей, имеющих одинаковые имена.
     * map.put("Rooney", "Leo");
     * map.put("Lloris", "Hugo");
     * map.put("Messi", "Leo");
     * map.put("Ronaldo", "Cristiano");
     * map.put("Maldini", "Paolo");
     * map.put("Indzaghi", "Pipo");
     * map.put("Del Piero", "Alesandro");
     * map.put("Balotelli", "Mario");
     * map.put("Gotze", "Mario");
     * map.put("Gomez", "Mario");
     * </pre>
     */
    private static void dz8_3() {
        Map<String, String> map = new HashMap<>();
        map.put("Rooney", "Leo");
        map.put("Lloris", "Hugo");
        map.put("Messi", "Leo");
        map.put("Ronaldo", "Cristiano");
        map.put("Maldini", "Paolo");
        map.put("Indzaghi", "Pipo");
        map.put("Del Piero", "Alesandro");
        map.put("Balotelli", "Mario");
        map.put("Gotze", "Mario");
        map.put("Gomez", "Mario");

        // count same names
        Map<String, Integer> counts = new HashMap<>();

        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (!counts.containsKey(entry.getValue()))
                counts.put(entry.getValue(), 1);
            else
                counts.put(entry.getValue(), counts.get(entry.getValue()) + 1);
        }

        // add in new map unique names
        Map<String, String> result = new HashMap<>();

        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (counts.get(entry.getValue()) == 1)
                result.put(entry.getKey(), entry.getValue());
            else
                System.out.println("Do not add " + entry);
        }

        for (Map.Entry<String, String> entry : result.entrySet()) {
            System.out.println(entry);
        }
    }

    /**
     * <pre>
     * Удалить всех людей, родившихся летом
     * Создать словарь (Map<String, Date>) и занести в него 5 записей по принципу:
     * «фамилия» - «дата рождения».
     * Удалить из словаря всех людей, родившихся летом.
     * map.put("Jhon", new Date("JUNE 1 1980"));
     * map.put("Mark", new Date("JUNE 5 1999"));
     * map.put("Elone", new Date("DECEMBER 13 1996"));
     * map.put("Stieve", new Date("JUNE 1 1980"));
     * map.put("Clark", new Date("MARCH 1 1980"));
     * </pre>
     */
    private static void dz8_2() {
        Map<String, Date> map = new HashMap<>();
        map.put("Jhon", new Date("JUNE 1 1980"));
        map.put("Mark", new Date("JULY 5 1999"));
        map.put("Elone", new Date("DECEMBER 13 1996"));
        map.put("Stieve", new Date("AUGUST 1 1980"));
        map.put("Clark", new Date("MARCH 1 1980"));

        Set<String> set = new HashSet<>();

        for (Map.Entry<String, Date> entry : map.entrySet()) {
            if (entry.getValue().getMonth() == 5 ||
                    entry.getValue().getMonth() == 6 ||
                    entry.getValue().getMonth() == 7)
                set.add(entry.getKey());
        }
        for (String s : set) {
            map.remove(s);
        }

        for (Map.Entry<String, Date> entry : map.entrySet()) {
            System.out.println(entry);
        }

    }

    /**
     * <pre>
     * Создать словарь (Map<String, String>) занести в него 5 записей по принципу
     * «Фамилия» - «Имя».
     * Проверить сколько людей имеют совпадающие с заданным имя или фамилию:
     * - создать метод getCountTheSameFirstName(Map<String, String> map, String name),
     * который должен вернуть количество пар с именем, которое приходит в аргумент name
     * - создать метод getCountTheSameLastName(Map<String, String> map, String lastName),
     * который должен вернуть количество пар с фамилией, которая приходит в аргумент lastName
     *
     * ?? Коммент - а зачем фамилии - это ключ, значит либо есть либо нет
     * </pre>
     */

    private static void dz8_1() {
        Map<String, String> map = new HashMap<>();
        map.put("Surname 1", "Name 1");
        map.put("Surname 2", "Name 2");
        map.put("Surname 3", "Name 2");
        map.put("Surname 4", "Name 2");
        map.put("Surname 5", "Name 1");
        System.out.println(getCountTheSameFirstName(map, "Name 1"));
        System.out.println(getCountTheSameFirstName(map, "Name 2"));
        System.out.println(getCountTheSameLastName(map, "Buya"));
        System.out.println(getCountTheSameLastName(map, "Surname 3"));
    }

    private static int getCountTheSameFirstName(Map<String, String> map, String name) {
        int result = 0;
        for (String value : map.values()) {
            if (name.equals(value))
                result++;
        }
        return result;
    }

    private static int getCountTheSameLastName(Map<String, String> map, String lastName) {
        if (map.containsKey(lastName))
            return 1;
        else
            return 0;
    }
}
