package udemy.core1.generics;

public class Example1<T> {
    private T instance;

    public T get() {
        return instance;
    }

    public void set(T instance) {
        this.instance = instance;
    }
}
