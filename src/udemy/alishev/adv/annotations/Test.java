package udemy.alishev.adv.annotations;


public class Test {
    @MethodInfo(purpose = "Print Hello world!")
    public void printHelloWorld() {
        System.out.println("Hello world!");
    }
}
