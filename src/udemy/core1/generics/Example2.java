package udemy.core1.generics;

public class Example2<T> {
    private T instance;

    // PRIVATE constructor means we cannot create instance outside

    private Example2() {

    }

    // first <T> is return type - T instance
    public static <T> void simpleInit(T instance) {
        //T obj;
    }

    public static <T> Example2<T> init(T instance) {
        return new Example2<T>();
    }

    public void set(T obj) {
        instance = obj;
    }

    public T getInstance() {
        return instance;
    }

}
