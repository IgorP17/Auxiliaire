package hyperskill.readabilityscore;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String all = scanner.nextLine();

        if (!all.endsWith(".") || !all.endsWith("!")){
            all = all + ".";
        }

        // count words
        int w = all.split(" ").length;
        // count sentences
        int s = all.split("[.!]").length;
//        System.out.println("Words = " + w + ", sentences = " + s);

    }
}
