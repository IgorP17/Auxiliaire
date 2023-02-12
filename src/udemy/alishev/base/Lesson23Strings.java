package udemy.alishev.base;

public class Lesson23Strings {
    public static void main(String[] args) {
        String s = "qwerty";
        // s.toUpperCase(); // String is immutable - it does not change, need reassign
        s = s.toUpperCase();
        System.out.println(s);

        // concate
        String all = "a" + "b" + "c";
        // new string = a + b
        // new string = (a + b) + c
        // total new 2 objects

        // String builder - mutable
        StringBuilder stringBuilder = new StringBuilder("Hello");
        stringBuilder.append(" my").append(" friend");
        System.out.println(stringBuilder.toString());

        System.out.printf("Int %06d\n", 12);
        System.out.printf("Int %6d\n", 12);
        System.out.printf("Int %-6d\n", 12);

    }

}
