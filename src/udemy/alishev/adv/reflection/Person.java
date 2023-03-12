package udemy.alishev.adv.reflection;

import udemy.alishev.adv.annotations.Author;

@Author(name = "Igor", dateOfBirth = 1981)
public class Person {
    private int id;
    private String name;

    public Person() {
        this.id = -1;
        this.name = "Some name";
    }

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void sayHello() {
        System.out.println("Person id = " + id + ", name = " + name);
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
