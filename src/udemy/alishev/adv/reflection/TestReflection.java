package udemy.alishev.adv.reflection;

import udemy.alishev.adv.annotations.Author;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

public class TestReflection {
    public static void main(String[] args) {
        Person person = new Person();

        Class personClass = Person.class;
        Class personClass2 = person.getClass();
        try {
            Class personClass3 = Class.forName("udemy.alishev.adv.reflection.Person");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        System.out.println("=== Methods ===");
        Method[] methods = personClass.getMethods();
        for (Method method : methods) {
            System.out.println(method.getName() + ", returns " + method.getReturnType() + ", params " + Arrays.toString(method.getParameterTypes()));
        }

        System.out.println("=== Fields ===");
        Field[] fields = personClass.getDeclaredFields(); // достать все поля, включая приватные
        for (Field field : fields) {
            System.out.println(field.getName() + ", type " + field.getType());
        }

        System.out.println("=== Annotation ===");
        Annotation[] annotations = personClass.getAnnotations();
        System.out.println(annotations.length);
        for (Annotation annotation : annotations) {
            if (annotation instanceof Author){
                System.out.println("YES");
            }
        }

    }
}
