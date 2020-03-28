package hyperskill.calculator;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {

        boolean isExit = false;
        Scanner scanner = new Scanner(System.in);
        String s;
        while (!isExit) {
            s = scanner.nextLine();
            switch (s) {
                case "/exit":
                    System.out.println("Bye!");
                    isExit = true;
                    break;
                case "/help":
                    help();
                    break;
                default:
                    calculate(s);
                    break;
            }
        }

    }

    private static void calculate(String all) {
        String in = all.replaceAll(" ", "");
        if (!(in.startsWith("+") || in.startsWith("-"))) {
            in = "+" + in;
        }
//        System.out.println(in);
        // split to args
        Pattern pattern = Pattern.compile("[-+]+\\d+", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(in);
        ArrayList<String> args = new ArrayList<>();
        while (matcher.find()) {
//            System.out.println(matcher.group());
            args.add(matcher.group());
        }
        int result = 0;
        Integer c;
        for (String s : args){
            c = refine(s);
            if (null == c){
                System.out.println("Refine failed! Value = " + s);
                System.exit(1);
            }
            result = result + c;
        }
        System.out.println(result);
    }

    /**
     * Refine smth like "---5"
     * @param s string to evaluate
     * @return integer
     */
    private static Integer refine(String s) {
//        System.out.println("Got " + s);
        Pattern pattern = Pattern.compile("[-+]", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(s);
        String current = "+";
        while (matcher.find()) {
//            System.out.println(matcher.group());
            if ("-".equalsIgnoreCase((matcher.group()))){
                // need invert
                if ("+".equalsIgnoreCase(current)){
                    current = "-";
                } else {
                    current = "+";
                }
            }
        }
        pattern = Pattern.compile("\\d+", Pattern.CASE_INSENSITIVE);
        matcher = pattern.matcher(s);
        if (matcher.find()){
            if ("+".equalsIgnoreCase(current)){
                return Integer.parseInt(matcher.group());
            } else {
                return -Integer.parseInt(matcher.group());
            }
        }
        return null;
    }


    private static void help() {
        System.out.println("Enter line to calculate");
        System.out.println("For example 9 +++ 10 -- 8");
    }

}
