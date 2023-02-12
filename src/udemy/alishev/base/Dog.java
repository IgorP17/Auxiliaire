package udemy.alishev.base;

public class Dog extends Animal {

    public Dog(String name) {
        super(name);
    }

    public void bark(){
        System.out.println("I'm barking");
    }

    @Override
    public void eat() {
        super.eat();
        System.out.println("Dog is eating");
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                '}';
    }
}
