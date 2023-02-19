package udemy.alishev.base;

public class Lesson02_PrimTypes {
    // last watched 52 lesson
    public static void main(String[] args) {
        byte b = 2;
        short s = 32_000;
        int i = 64_000;
        long l = 3_000_000_000L;

        double d = 3.14;
        float f = 2.71f;

        boolean bool = false;

        char ch = 'g';

        System.out.printf("1. byte = %d\n" +
                        "2. short = %d\n" +
                        "3. int = %d\n" +
                        "4. long = %d\n" +
                        "5. double = %f\n" +
                        "6. float = %f\n" +
                        "7. boolean = %b\n" +
                        "8. char = %s\n",
                b, s, i, l, d, f, bool, ch);

        // static field and method example
        System.out.println(Math.pow(2, 4));
        System.out.println(Math.PI);

        System.out.println("=== Enum");
        AnimalEnum animalEnum = AnimalEnum.FROG;
        System.out.println(animalEnum instanceof AnimalEnum);
        System.out.println(animalEnum instanceof Enum);
        System.out.println(animalEnum instanceof Object);
        System.out.println(animalEnum);
        System.out.println(animalEnum.name());
        System.out.println("Порядковый номер - " + animalEnum.ordinal());
        switch (animalEnum){
            case CAT:
                System.out.println("It's cat(" + animalEnum.getRuName() + "), id " + animalEnum.getId());
                break;
            case FROG:
                System.out.println("It's frog(" + animalEnum.getRuName() + "), id " + animalEnum.getId());
                break;
            default:
                System.out.println("Other animal");
        }

        AnimalEnum animalEnumIn = AnimalEnum.valueOf("DOG"); // ввод с клавиатуры -> enum
        System.out.println(animalEnumIn);
    }
}
