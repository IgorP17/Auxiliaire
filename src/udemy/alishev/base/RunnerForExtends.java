package udemy.alishev.base;

public class RunnerForExtends {
    public static void main(String[] args) {
        Animal animal = new Animal("My name is Animal");
        Dog dog = new Dog("My name is Dog");

        System.out.println(animal);
        animal.eat();
        animal.sleep();
        System.out.println();
        System.out.println(dog);
        dog.eat();
        dog.sleep();
        dog.bark();

        //
        Animal animal1 = new Dog("Animal Dog");
        // animal1.eat(); OK
        // animal1.bark() - not OK
        System.out.println(animal1);
        animal1.eat(); // позднее связывание - если есть реализация у потомка
        System.out.println();
        //
        Cat cat = new Cat("My name is Cat");
        test(animal);
        test(dog);
        test(animal1);
        test(cat);

        // upcasting downcasting (восзодящее и низходящиее преобразование)
        // upcating - Animal animal1 = new Dog("Animal Dog"); - преобразование от наследника к родителю
        // downcasting - не всегда безопасен
        Dog dog1 = (Dog) animal;
        dog1.bark();

    }

    public static void test(Animal animal){
        System.out.println(animal);
        animal.eat();
    }
}
