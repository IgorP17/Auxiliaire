package udemy.core1.hw14;

public class Human {
    private String name;
    private boolean s;
    private int age;
    private Human father;
    private Human mother;

    public Human(String name, boolean s, int age, Human father, Human mother) {
        this.name = name;
        this.s = s;
        this.age = age;
        this.father = father;
        this.mother = mother;
    }



    @Override
    public String toString() {
        String result = "Имя: " + name;
        result += ", пол: ";
        if (s)
            result += "мужской";
        else
            result += "женский";
        result += ", возраст: " + age;
        if (father != null){
            result += ", отец: " + father.name;
        }
        if (mother != null){
            result += ", мать: " + mother.name;
        }

        return result;
    }


    public static void main(String[] args) {
        Human ded1 = new Human("Дед1", true, 65, null, null);
        Human babka1 = new Human("Бабка1", false, 60, null, null);

        System.out.println(ded1);
        System.out.println(babka1);

        Human ded2 = new Human("Дед2", true, 61, null, null);
        Human babka2 = new Human("Бабка2", false, 59, null, null);

        System.out.println(ded2);
        System.out.println(babka2);

        Human father = new Human("Отец", true, 39, ded1, babka1);
        Human mother = new Human("Мать", false, 38, ded2, babka2);

        System.out.println(father);
        System.out.println(mother);

        Human child1 = new Human("Ребенок1", true, 7, father, mother);
        Human child2 = new Human("Ребенок2", false, 4, father, mother);

        System.out.println(child1);
        System.out.println(child2);
    }


}
