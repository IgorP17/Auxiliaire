package udemy.alishev.base;

public class MyObject {

    public static void main(String[] args) {
        MyObject myObject = new MyObject(7, "QW");
        System.out.println(myObject);
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
}
