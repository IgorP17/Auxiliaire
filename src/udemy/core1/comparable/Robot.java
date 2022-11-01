package udemy.core1.comparable;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/*
Создать класс Robot с двумя полями - power(int), model(String)
Создать коллекцию TreeMap и добавить туда 3 роботов
Реализовать интерфейс Comparable в классе Robot:
- метод compareTo должен сравнивать имена в алфавитном порядке, если имена одинаковые, то сравнение должно проходить по полю power.
Вывести в консоль содержимое коллекции TreeMap
 */
public class Robot implements Comparable<Robot> {
    private final int power;
    private final String model;

    public Robot(int power, String model) {
        this.power = power;
        this.model = model;
    }

    public int getPower() {
        return power;
    }

    @Override
    public int compareTo(Robot o) {
        if (this.model.compareTo(o.model) < 0) {
            return -1;
        } else if (this.model.compareTo(o.model) > 0) {
            return 1;
        } else {
            if (this.power < o.power) {
                return -1;
            } else if (this.power > o.power) {
                return 1;
            } else return 0;
        }
    }

    @Override
    public String toString() {
        return "Robot{" +
                "power=" + power +
                ", model='" + model + '\'' +
                '}';
    }

    public static void main(String[] args) {
        Robot r1 = new Robot(7, "Model 1");
        Robot r2 = new Robot(10, "AModel 1");
        Robot r3 = new Robot(9, "AModel 1");

        System.out.println("--- Use compareTo");
        Map<Robot, String> map = new TreeMap<>();
        map.put(r1, "r1"); // third
        map.put(r2, "r2"); // second
        map.put(r3, "r3"); // should be first

        for (Map.Entry<Robot, String> entry : map.entrySet()) {
            System.out.println(entry);
        }
        System.out.println("--- Use comparator");
        RobotComparator comparator = new RobotComparator();
        Map<Robot, String> mapOrderedByPowerDesc = new TreeMap<>(comparator);
        mapOrderedByPowerDesc.put(r1, "r1"); // first
        mapOrderedByPowerDesc.put(r2, "r2"); // third
        mapOrderedByPowerDesc.put(r3, "r3"); // second

        for (Map.Entry<Robot, String> entry : mapOrderedByPowerDesc.entrySet()) {
            System.out.println(entry);
        }

        System.out.println("--- HashMap");
        System.out.printf("r1 hash = %d, remain = %d\n", r1.hashCode(), r1.hashCode() % 16);
        System.out.printf("r2 hash = %d, remain = %d\n", r2.hashCode(), r2.hashCode() % 16);
        System.out.printf("r3 hash = %d, remain = %d\n", r3.hashCode(), r3.hashCode() % 16);

        Map<Robot, String> hashMap = new HashMap<>();
        hashMap.put(r1, "r1");
        hashMap.put(r2, "r2");
        hashMap.put(r3, "r3");
        for (Map.Entry<Robot, String> entry : hashMap.entrySet()) {
            System.out.println(entry);
        }
    }
}
