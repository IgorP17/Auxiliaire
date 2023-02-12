package udemy.alishev.base;

public class AbstractClass {

    public static void main(String[] args) {
        DogA dogA = new DogA();
        CatA catA = new CatA();

        dogA.eat();
        catA.eat();

        dogA.makeSound();
        catA.makeSound();


    }
}

// абстактый класс и метод, реализуемый в потомках
abstract class AbstractAnimal{
    public void eat(){
        System.out.println("Abstract eating!");
    }
    public abstract void makeSound();
}

class DogA extends AbstractAnimal{
    @Override
    public void makeSound() {
        System.out.println("Гав Гав");
    }
}

class CatA extends AbstractAnimal{
    @Override
    public void makeSound() {
        System.out.println("Мяу мяу");
    }
}