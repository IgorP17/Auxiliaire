package udemy.alishev.base;

public class Animal {
    protected String name;
    public void eat(){
        System.out.println("I'm eating!");
    }

    public void sleep(){
        System.out.println("I'm sleeping!");
    }

    public Animal(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                '}';
    }
}
