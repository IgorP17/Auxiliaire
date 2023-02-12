package udemy.alishev.base;

public class Anonimus {

    interface IAbleToEat {
        public void eat();
    }
    public static void main(String[] args) {
        Animal animal = new Animal("Animal 1");
        animal.eat();

        Animal animal2 = new Animal("Animal 2"){
            @Override
            public void eat(){
                System.out.println("Other animal eating!");
            }
        };
        // наследник класса Animal с переопределенным методом, но сам класс мы не хотим создавать переопределять
        animal2.eat();

        // через интерфейс
        IAbleToEat iAbleToEat = new IAbleToEat() {
            @Override
            public void eat() {
                System.out.println("Implement eating!");
            }
        };
        iAbleToEat.eat();
    }

}