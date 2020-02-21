package hyperskill.flashcards;

import java.util.Scanner;

public class FlashCard {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        String def = scanner.nextLine();
        String term = scanner.nextLine();
        String answer = scanner.nextLine();

        termAnswer(term, answer);
    }

    private static void termAnswer(String term, String answer){
        if (term.equalsIgnoreCase(answer)){
            System.out.println("Your answer is right!");
        }else {
            System.out.println("Your answer is wrong...");
        }
    }

}
