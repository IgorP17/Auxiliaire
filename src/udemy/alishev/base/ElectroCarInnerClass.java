package udemy.alishev.base;

public class ElectroCarInnerClass {
    private int id;

    private class Motor{ // вложеный не статичный класс
        public void startMotor(){
            System.out.println("Motor " + id + "is starting"); // имеет доступ к основному классу
        }
    }

    // вложеный статический класс, не имеет доступа к нестатическим полям,
    // обычно используем извне
    // ElectroCarInnerClass.Battery battery = new ElectroCarInnerClass.Battery();
    public static class Battery{
        public void charge(){
            System.out.println("Battery is charging...");
        }
    }

    public ElectroCarInnerClass(int id) {
        this.id = id;
    }

    public void start(){
        Motor motor = new Motor();
        motor.startMotor();

        int x = 1; // чтобы иметь к ним доступ должны быть final
        // класс в методе
        class SomeClass{
            public void someMethod(){
                System.out.println(x + " " + id);
            }
        }

        System.out.println("Electrocar " + id + " is starting...");
    }
}
