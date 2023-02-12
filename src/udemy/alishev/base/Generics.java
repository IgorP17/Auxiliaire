package udemy.alishev.base;

import java.util.ArrayList;
import java.util.List;

public class Generics {
    public static void main(String[] args) {
        List<Animal> animalList = new ArrayList<>();
        animalList.add(new Animal("Animal 1"));
        animalList.add(new Animal("Animal 2"));
        test(animalList);
        List<Dog> dogList = new ArrayList<>();
        dogList.add(new Dog("Dog 1"));
        dogList.add(new Dog("Dog 2"));
        test(dogList);
    }

    private static void test(List<? extends Animal> animals){ // wildcard Animal и ниже, super - Animal и выше
        for (Animal animal : animals) {
            System.out.println(animal);
            animal.eat();
        }
    }
}
