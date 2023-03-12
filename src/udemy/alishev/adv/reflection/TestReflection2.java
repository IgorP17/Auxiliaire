package udemy.alishev.adv.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class TestReflection2 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        Scanner scanner = new Scanner(System.in);
        // Название_класса1 Название_класса2 Название метода
        // будем вызывать метод у первого класса с параметром класс2
        Class classObject1 = Class.forName(scanner.next());
        Class classObject2 = Class.forName(scanner.next());
        String methodName = scanner.next();

        Method m = classObject1.getMethod(methodName, classObject2);
        // obj1.method(obj2)
        Object o1 = classObject1.newInstance();
        Object o2 = classObject2.getConstructor(String.class).newInstance("String value");

        m.invoke(o1, o2);
        System.out.println(o1);

        /*
            1. udemy.alishev.adv.reflection.Person java.lang.String setName
            2. java.lang.Thread java.lang.String setName
         */

    }
}
