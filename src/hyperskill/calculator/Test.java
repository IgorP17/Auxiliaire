package hyperskill.calculator;

import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String s = scanner.nextLine();
        // Valid IP
        //System.out.println(s.matches("((1?[0-9]{1,2}|2[0-4][0-9]|25[0-5])\\.){3}(1?[0-9]{1,2}|2[0-4][0-9]|25[0-5])") ? "YES" : "NO");
        //final String bytePattern = "(1?\\d?\\d|2[0-4]\\d|25[0-5])";
        //final String ipPattern = String.join(
        //        "\\.", bytePattern, bytePattern, bytePattern, bytePattern

        // Valid password
// ^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\S+$).{8,}$
// ^                 # start-of-string
// (?=.*[0-9])       # a digit must occur at least once
// (?=.*[a-z])       # a lower case letter must occur at least once
// (?=.*[A-Z])       # an upper case letter must occur at least once
// (?=.*[@#$%^&+=])  # a special character must occur at least once
// (?=\S+$)          # no whitespace allowed in the entire string
// .{8,}             # anything, at least eight places though
// $                 # end-of-string
        System.out.println(s.matches("") ? "YES" : "NO");

        char[] operands = {'+', '-'};
        String line;
        while (true) {
            line = scanner.nextLine();
            if ("/exit".equalsIgnoreCase(line)) {
                System.out.println("Bye!");
                break;
            }
            if ("/help".equalsIgnoreCase(line)) {
                System.out.println("Use + and - operand both unary and binary");
            } else {
                // remove spaces
                line = line.replace(" ", "");
                // reading

            }
        }
    }

}
