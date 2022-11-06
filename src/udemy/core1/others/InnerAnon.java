package udemy.core1.others;

public class InnerAnon {
    public static void main(String[] args) {
        Class1 class1 = new Class1(1,2);
        System.out.printf("Nested class: %s\n", class1);

        Duck duck = new Duck();
        duck.fly();
        // анонимный класс
        Flyable obj = new Flyable() {
            @Override
            public void fly() {
                System.out.println("I'm fly!!!");
            }
        };
        obj.fly();

    }
}


// вложенный класс
// не статичный вложенный класс называется внутренним классом (Inner)
// Inner inner = new Inner();
// Inner.Class1 class1 = inner.new Class1();
// вложенный статичный класс не имеет доступа к не статичным полям внешнего

class Class1 {
    private final int a;
    private final int b;

    public Class1(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public String toString() {
        return "Class1{" +
                "a=" + a +
                ", b=" + b +
                '}';
    }
}

interface Flyable{
    void fly();
}

class Duck implements Flyable{
    @Override
    public void fly() {
        System.out.println("Duck fly");
    }
}