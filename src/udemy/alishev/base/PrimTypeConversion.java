package udemy.alishev.base;

public class PrimTypeConversion {
    public static void main(String[] args) {
        int a = 123;

        long l = a; // не яное приведение типов
        int x = (int) l; // явное приведение типов

        // классы обертки - Byte, Short, Integer, Long, Float, Long, Character, Boolean

        int i1 = Integer.parseInt("123");
        Integer i2 = Integer.valueOf("123");

        // autoboxing
        Integer z1 = 123;

        //unboxing
        int z2 = z1;

        //
        //Boolean.logicalXor();
    }
}
