package udemy.alishev.adv.lamda;


interface Executable {
    int execute(int x, int y);
}

class Runner {
    public void run(Executable e) {
        int a = e.execute(10, 20);
        System.out.println(a);
    }
}

class ExecutableImpl implements Executable {
    @Override
    public int execute(int x, int y) {
        System.out.println("Hello from ExecutableImpl");
        return x + y + 1;
    }
}

public class TestLambda1 {
    // Используется для того, чтобы передать код в метод - т.е. аналог анонимной ф-и/класс (метод не привязанный и идентификатору)
    // () -> {code}
    // () - аргументы
    // interface Executable должен содержать только 1 метод
    public static void main(String[] args) {
        Runner runner = new Runner();
        // Вариант 1
        runner.run(new ExecutableImpl());
        // Вариант 2
        runner.run(new Executable() {
            @Override
            public int execute(int x, int y) {
                System.out.println("Hello from anonymous");
                return x + y + 2;
            }
        });
        // Вариант 3
        runner.run((int x, int y) -> {
            System.out.println("Hello from lambda");
            return x + y + 3; // java сама понимает какой тип надо вернуть
        });

        /*
            int a = 1; // должно быть final или effectively final
            runner.run((x,y) -> x + y + a);

            runner.run((x,y) -> {
            int b = 1; // т.к. уже выше в коде определена а, то не можем использовать (область видимости по всему коду выше)
            return x + y + a + b;
            )};
         */
    }
}
