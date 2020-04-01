package hyperskill.calculator;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {

        boolean isExit = false;
        Scanner scanner = new Scanner(System.in);
        String s;
        while (!isExit) {
            s = scanner.nextLine();
            if (s.startsWith("/")) {
                switch (s) {
                    case "/exit":
                        System.out.println("Bye!");
                        isExit = true;
                        break;
                    case "/help":
                        help();
                        break;
                    default:
                        System.out.println("Unknown command");
                        break;
                }
            } else {
                if (!s.isEmpty()) {
                    ArrayList<String> reversed = getReversePolish(s);
                    System.out.println(calcPolish(reversed));
//                    for (String s1 : reversed){
//                        System.out.print(s1 + " ");
//                    }

                }
            }
        }

    }

    /**
     * Evaluate polish string
     *
     * @param in reversed polish string as ArrayList
     * @return eval value
     */
    private static int calcPolish(ArrayList<String> in) {
        Stack<String> current = new Stack<>();

//        System.out.println("Got " + in);

        for (String s : in) {
//            System.out.println("Current = " + current.toString());
            if (s.matches("\\d+")) {
                // we got an operand put in stack
                current.push(s);
            } else {
                // we got operator
                // get right value
                int right = Integer.parseInt(current.pop());
                // get left value
                int left = Integer.parseInt(current.pop());

                switch (s) {
                    case "+":
//                        System.out.println("Have addition = " + (left + right));
                        // need add result
                        current.push(String.valueOf(left + right));
                        break;
                    case "-":
//                        System.out.println("Have substraction = " + (left - right));
                        // need add result
                        current.push(String.valueOf(left - right));
                }
            }
        }
        if (current.size() == 1) {
            return Integer.parseInt(current.pop());
        } else {
            throw new RuntimeException("Illegal result stack!");
        }
    }

    /**
     * Get reversed polish notation
     * https://ru.wikipedia.org/wiki/%D0%9E%D0%B1%D1%80%D0%B0%D1%82%D0%BD%D0%B0%D1%8F_%D0%BF%D0%BE%D0%BB%D1%8C%D1%81%D0%BA%D0%B0%D1%8F_%D0%B7%D0%B0%D0%BF%D0%B8%D1%81%D1%8C
     * WARNING use + and - sign // TODO implement others with priority
     *
     * @param in string like 3 + 4
     * @return reversed polish notation string
     */
    private static ArrayList<String> getReversePolish(String in) {
        in = "0 + " + in;
        ArrayList<String> result = new ArrayList<>();
        // reading string
        // assume we have operators + - and operands
        StringBuilder operand = new StringBuilder();
        StringBuilder operator = new StringBuilder();
        boolean isReadingOperand = false;
        boolean isReadingOperator = false;
        char ch;
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < in.length(); i++) {
            ch = in.charAt(i);
            if (Character.isDigit(ch)) {
                isReadingOperand = true;
                operand.append(ch);

                // if we return to read after operand
                if (isReadingOperator) {
                    // we finish read operator
                    isReadingOperator = false;
                    // add operator to Stack
                    // actually if we have +- pop and push
                    if (stack.size() != 0) {
                        result.add(stack.pop());
                    }
                    stack.push(refineOperator(operator.toString()));
                    // flush operator
                    operator = new StringBuilder();
                }

                // the last symbol should be a digit
                if (i == in.length() - 1) {
                    // add to out
                    result.add(operand.toString());
                }
            } else {
                if (isReadingOperand) {
                    // we just finish reading operand
                    isReadingOperand = false;
                    // add operand to out
                    result.add(operand.toString());
                    // flush operand
                    operand = new StringBuilder();
                }
                // if it is last symbol throw
                if (i == in.length() - 1) {
                    throw new RuntimeException("Last is not digit!");
                }
                // so we are reading operator
                isReadingOperator = true;
                operator.append(ch);
            }
        }
        // print stack
//        while (!stack.isEmpty()) {
//            System.out.println(stack.pop());
//        }

        // put stack in
        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }
        return result;
    }


    private static String refineOperator(String operator) {
        boolean isPlusMinusFound = false;
        char result = '+';
        for (char c : operator.toCharArray()) {
            if ('+' == c) {
                isPlusMinusFound = true;
            }

            if ('-' == c) {
                isPlusMinusFound = true;
                if ('+' == result) {
                    result = '-';
                } else {
                    result = '+';
                }
            }
        }
        if (!isPlusMinusFound) {
            throw new RuntimeException("Bad operator");
        }
        return String.valueOf(result);
    }

    /**
     * Print some help
     */
    private static void help() {
        System.out.println("Enter line to calculate");
        System.out.println("For example 9 +++ 10 -- 8");
    }

}
