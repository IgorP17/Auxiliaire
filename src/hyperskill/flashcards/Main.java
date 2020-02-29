package hyperskill.flashcards;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        FlashCards flashCards = new FlashCards();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input the number of cards:");
        int count = Integer.parseInt(scanner.nextLine());
        String card;
        String definition;
        for (int i = 0; i < count; i++) {
            System.out.println("The card # " + (i + 1) + ":");
            card = scanner.nextLine();
            boolean present;
            do {
                present = flashCards.checkCard(card);
                if (present) {
                    System.out.println("The card \"" + card + "\" already exists. Try again:");
                    card = scanner.nextLine();
                }
            } while (present);
            System.out.println("The definition of the card #" + (i + 1) + ":");
            definition = scanner.nextLine();
            do {
                present = flashCards.checkDefinition(definition);
                if (present) {
                    System.out.println("The definition \"" + definition + "\" already exists. Try again:");
                    definition = scanner.nextLine();
                }
            } while (present);
            flashCards.addCard(card, definition);
        }
        flashCards.ask();
    }
}

class FlashCards {
    private LinkedHashMap<String, String> cards = new LinkedHashMap<>();

    void addCard(String card, String definition) {
        if (!checkCard(card)) {
            cards.put(card, definition);
        }
    }

    boolean checkCard(String card) {
        return cards.containsKey(card);
    }

    boolean checkDefinition(String definition) {
        return cards.containsValue(definition);
    }

    void ask() {
        Scanner scanner = new Scanner(System.in);
        String answer;
        boolean foundExt;
        String keyExt = "";
        for (Map.Entry<String, String> entry : cards.entrySet()) {
            System.out.println("Print the definition of \"" + entry.getKey() + "\":");
            answer = scanner.nextLine();
            if (answer.equalsIgnoreCase(entry.getValue())) {
                System.out.println("Correct answer.");
            } else {
                // find correct
                foundExt = false;
                for (Map.Entry<String, String> entry2 : cards.entrySet()) {
                    if (entry2.getValue().equalsIgnoreCase(answer)) {
                        foundExt = true;
                        keyExt = entry2.getKey();
                        break;
                    }
                }
                if (foundExt) {
                    System.out.println("Wrong answer. The correct one is \"" + entry.getValue() + "\", you've just written the definition of \"" + keyExt + "\".");
                } else {
                    System.out.println("Wrong answer. The correct one is \"" + entry.getValue() + "\".");
                }
            }
        }

    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<String, String> entry : cards.entrySet()) {
            stringBuilder.append(entry.getKey()).append(":").append(entry.getValue()).append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }
}