package udemy.alishev.adv.reflection;

public class Test {
    /*
        У класса есть
        - имя
        - имя пакета
        - набор полей
        - набор методов
        - ...

        class Class {
            String name;
            String packageName;
            List<Attribute> attributes;
            List<Method> methods;
        }

        Рассматриваем класс как объект (экземпляр) класса Class и работаем с ним как с обычным объектом.
        Class - служебный класс, экземпляры которого хранят конкретную информацию о конкретном классе.
        Class c = MyClass.class;
        Class c = obj.getClass(); // obj экземпляр MyClass
        Class c = Class.forName("ru.aaa.MyClass");
     */
}
