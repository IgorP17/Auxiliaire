package hyperskill.budgetmanager;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    /*
    To end the input, the user should type End-of-file symbol that tells your operating system that
     no more input will be provided. It's Ctrl+D on Linux and Mac and Ctrl+Z on Windows.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> in = new ArrayList<>();

        while (true) {
            if (scanner.hasNext()) {
                in.add(scanner.nextLine());
            } else {
                break;
            }
        }

        Budget budget = new Budget(in);
        budget.printMe();
        budget.printTotals();
    }

}

class Budget {
    private ArrayList<String> in;
    private int totalCents = 0;

    Budget(ArrayList<String> in) {
        this.in = in;
        parseIn();
    }

    void printMe() {
        if (null != in) {
            for (String s : in) {
                System.out.println(s);
            }
        }
    }

    void printTotals() {
        System.out.println();
        System.out.println("Total: $" + totalCents / 100 + "." + totalCents % 100);
    }

    private void parseIn() {
        if (null == in) {
            System.out.println("In is null!");
        } else {
            String[] splited;
            for (String s : in) {
                splited = s.split("\\$");
                try {
                    totalCents =
                            totalCents + Integer.parseInt(splited[1].replace(".", ""));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
