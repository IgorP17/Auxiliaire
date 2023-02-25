package udemy.alishev.adv.collections;

import java.util.Objects;

class Person implements Comparable<Person> {
    private final int id;
    private final String name;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (id != person.id) return false;
        return Objects.equals(name, person.name);
    }

    // {person} -> int(!!фиксированная длина) с учетом полей
    // может случиться так, что хеш коды 2-х разных объектов равны - коллизия, поэтому нужен equals
    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    /*
     * Контракт hashcode и equals
     * 1) У двух проверяемых объектов вызываем hashCode.
     * Если получили 2 разных числа - объекты точно разные.
     * 2) если hashCode одинаков, то вызываем equals:
     * который даст ответ - одинаковы объекты или нет.
     */


    // сравнение объектов (implements Comparable<Person>)
    @Override
    public int compareTo(Person person) {
        if (this.name.length() > person.getName().length()) {
            return 1;
        } else if (this.name.length() < person.getName().length()) {
            return -1;
        } else {
            return 0;
        }
    }
}
