package udemy.core1.collections;

import java.util.ArrayList;

public class Human {
    private final String name;
    private final boolean sex; // 0 female, 1 - male
    private final int age;
    private final ArrayList<Human> childrens;

    public Human(String name, boolean sex, int age, ArrayList<Human> childrens) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.childrens = childrens;
    }

    @Override
    public String toString() {
        StringBuilder s =
                new StringBuilder(
                        "Имя: "
                        + name
                        + ", пол: "
                        + (sex ? "мужской" : "женский")
                        + ", возраст: "
                        + age);
        if (!(childrens == null || childrens.isEmpty())){
            s.append(", дети: ");
            for (int i = 0; i < childrens.size(); i++) {
                s.append(childrens.get(i).name);
                if (i != (childrens.size() -1))
                    s.append(", ");
            }
        }

        return s.toString();
    }
}
