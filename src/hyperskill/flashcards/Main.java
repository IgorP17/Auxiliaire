package hyperskill.flashcards;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = Integer.parseInt(scanner.nextLine());
        String word;
        String definition;
        ArrayList<FlashCard> cards = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            System.out.println("The card #" + (i + 1) + ":");
            word = scanner.nextLine();
            System.out.println("The definition of the card #" + (i + 1) + ":");
            definition = scanner.nextLine();
            cards.add(new FlashCard(word, definition));
        }
        String answer;
        for (int i = 0; i < count; i++) {
            System.out.println("Print the definition of \"" + cards.get(i).getWord() + "\":");
            answer = scanner.nextLine();
            if (answer.equalsIgnoreCase(cards.get(i).getDefinition())) {
                System.out.println("Correct answer.");
            } else {
                System.out.println("Wrong answer. The correct one is \"" + cards.get(i).getDefinition() + "\".");
            }
        }
    }
}

class FlashCard {
    private String definition;
    private String word;

    FlashCard(String word, String definition) {
        this.word = word;
        this.definition = definition;
    }

    String getDefinition() {
        return definition;
    }

    String getWord() {
        return word;
    }
}