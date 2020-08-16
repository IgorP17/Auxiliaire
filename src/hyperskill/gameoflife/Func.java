package hyperskill.gameoflife;

/**
 * This functional interface has the @FunctionalInterface annotation (optional) and only one instance method apply.
 * The interface represents a function (in the math sense).
 * The function has an instance method apply which takes a value of type T and returns a result of type R.
 * @param <T> - type of return function
 * @param <R> - typ of return value
 */

@FunctionalInterface
interface Func<T, R> {

    R apply(T val);

    static void doNothingStatic() {

    }

    default void doNothingByDefault() {

    }
}

/*
Func<Long, Long> square = new Func<Long, Long>() {
    @Override
    public Long apply(Long val) {
        return val * val;
    }
};

long val = square.apply(10L); // the result is 100L

2) Lambda expression

Func<Long, Long> square = val -> val * val; // the lambda expression

long val = square.apply(10L); // the result is 100L

 */