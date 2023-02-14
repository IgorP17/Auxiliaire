package udemy.alishev.base;

public class AbstractClass {

    public static void main(String[] args) {
        DogA dogA = new DogA("Dog A");
        CatA catA = new CatA("Cat A");

        System.out.println(dogA);
        dogA.eat();
        dogA.makeSound();
        System.out.println(catA);
        catA.eat();
        catA.makeSound();


    }
}

/*
    Абстрактный класс и абстрактный метод, который надо реализовать в потомках.
    Отличие от интерфейса
    - интерфейс - это контракт на реализацию;
    - интерфейс - это то что умеет класс делать, а абстрактный класс - это то, чем класс является;
    Собака - это животное, обладает свойствами животного и полями животного.
    Если собака implements интерфейс МожетИздаватьЗвук - то она теряет возможность иметь имя и есть.
*/
abstract class AbstractAnimal{
    String name;

    public AbstractAnimal(String name) {
        this.name = name;
    }

    public void eat(){
        System.out.println("Abstract eating!");
    }
    public abstract void makeSound();

    @Override
    public String toString() {
        return "AbstractAnimal{" +
                "name='" + name + '\'' +
                '}';
    }
}

class DogA extends AbstractAnimal{
    public DogA(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println("Гав Гав");
    }

    @Override
    public String toString() {
        return "DogA{" +
                "name='" + name + '\'' +
                '}';
    }
}

class CatA extends AbstractAnimal{
    public CatA(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println("Мяу мяу");
    }

    @Override
    public String toString() {
        return "CatA{" +
                "name='" + name + '\'' +
                '}';
    }
}