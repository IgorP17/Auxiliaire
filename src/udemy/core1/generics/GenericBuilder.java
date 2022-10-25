package udemy.core1.generics;

import udemy.core1.generics.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class GenericBuilder<T> {
    private final Supplier<T> inst;
    private List<Consumer<T>> instModifiers = new ArrayList<>();

    public GenericBuilder(Supplier<T> inst) {
        this.inst = inst;
    }

    public static <T> GenericBuilder<T> of(Supplier<T> instantiator) {
        return new GenericBuilder<>(instantiator);
    }

    public <U> GenericBuilder<T> with(BiConsumer<T, U> consumer, U value) {
        Consumer<T> c = instance -> {
            if (Optional.ofNullable(value).isEmpty()) {
                return;
            }
            consumer.accept(instance, value);
        };
        instModifiers.add(c);
        return this;
    }

    public T build(){
        T value = inst.get();
        instModifiers.forEach(modifier -> modifier.accept(value));
        instModifiers.clear();
        return value;
    }

    public static void main(String[] args) {
        GenericBuilder<User> of = GenericBuilder.of(User::new);
        GenericBuilder<User> with = of.with(User::setAge, 30);
        User build = with.build();
        System.out.println(build);
        System.out.println("/--------------------/");

        User user = GenericBuilder.of(User::new)
                .with(User::setAge, 30)
                .with(User::setName, "John")
                .build();
        System.out.println(user);
        System.out.println("/--------------------/");
    }
}
