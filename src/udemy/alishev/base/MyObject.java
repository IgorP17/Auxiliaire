package udemy.alishev.base;

import java.util.Objects;

public class MyObject {

    public static void main(String[] args) {
        MyObject myObject = new MyObject(7, "QW");
        MyObject myObject2 = new MyObject(7, "QW");
        System.out.println(myObject);
        System.out.println(myObject2);
        System.out.println(myObject == myObject2);
        System.out.println(myObject.equals(myObject2));

        // string pool
        String s1 = "Hello";
        String s2 = "Hello";
        System.out.println(s1 == s2); // true


    }

    private int field1;
    private String field2;

    public MyObject(int field1, String field2) {
        this.field1 = field1;
        this.field2 = field2;
    }

    @Override
    public String toString() {
        return "MyObject{" +
                "field1=" + field1 +
                ", field2='" + field2 + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyObject myObject = (MyObject) o;
        return field1 == myObject.field1 && field2.equals(myObject.field2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(field1, field2);
    }
}
