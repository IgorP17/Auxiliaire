package hyperskill.calculator;

import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
        String matcher = "0\\.[0-9]{2}9{0,2}5*";
        System.out.println("0.129955".matches(matcher));
        System.out.println("0.1295".matches(matcher));
        System.out.println("0.125".matches(matcher));
        System.out.println("0.129995".matches(matcher));
        System.out.println("0.1299".matches(matcher));

        Scanner scanner = new Scanner(System.in);
        char[] operands = {'+', '-'};
        String line;
        while (true){
            line = scanner.nextLine();
            if ("/exit".equalsIgnoreCase(line)){
                System.out.println("Bye!");
                break;
            }
            if ("/help".equalsIgnoreCase(line)){
                System.out.println("Use + and - operand both unary and binary");
            } else {
                // remove spaces
                line = line.replace(" ", "");
                // reading
                for (char ch: line.toCharArray()){

                }
            }
        }
    }

}
