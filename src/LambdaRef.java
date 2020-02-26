import java.util.ArrayList;
import java.util.Collection;

public class LambdaRef {

    public static void main(String[] args) {
        Collection<String> languages = new ArrayList<>();

        languages.add("English");
        languages.add("Deutsch");
        languages.add("Français");

        languages.forEach(System.out::println); // with method reference
        languages.forEach(elem -> System.out.println(elem)); // with lambda expression
    }
}
