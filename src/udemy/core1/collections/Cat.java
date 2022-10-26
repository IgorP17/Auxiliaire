package udemy.core1.collections;

public class Cat {
    private final String name;
    private final int age;
    private final int weight;
    private final int tail;

    public Cat(String name, int age, int weight, int tail) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.tail = tail;
    }

    @Override
    public String toString() {
        return "Cat name is "
                + name
                + ", age is "
                + age +
                ", weight is "
                + weight +
                ", tail = "
                + tail;
    }
}
