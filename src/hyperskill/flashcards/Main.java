package hyperskill.flashcards;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        FlashCards flashCards = new FlashCards();
        flashCards.run();
    }
}

class FlashCards {
    private Scanner scanner = new Scanner(System.in);
    private LinkedHashMap<String, String> cards = new LinkedHashMap<>();

    /**
     * Main cycle
     */
    void run() {
        String s;
        boolean exit = false;
        while (!exit) {
            System.out.println("Input the action (add, remove, import, export, ask, exit):");
            s = scanner.nextLine();
            switch (s) {
                case "add":
                    addCard();
                    break;
                case "remove":
                    remove();
                    break;
                case "import":
                    loadMap();
                    break;
                case "export":
                    export();
                    break;
                case "ask":
                    ask();
                    break;
                case "exit":
                    System.out.println("Bye bye!");
                    exit = true;
                    break;
            }
        }
    }

    /**
     * Load cards
     */
    private void loadMap() {
        System.out.println("File name:");
        String fileName = scanner.nextLine();

        int counter = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line = br.readLine();

            String card;
            String definition;
            while (line != null) {
                card = line;
                definition = br.readLine();
                line = br.readLine();
//                System.out.println(card + ":" + definition);
                cards.put(card, definition);
                counter++;
            }
        } catch (IOException e) {
            System.out.println("File not found." + System.lineSeparator());
            return;
//            e.printStackTrace();
        }

        System.out.println(counter + " cards have been loaded." + System.lineSeparator());
    }

    /**
     * Save cards
     */
    private void export() {
        System.out.println("File name:");
        String fileName = scanner.nextLine();

        PrintWriter writer = null;
        try {
            writer = new PrintWriter(fileName, "UTF-8");
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        for (Map.Entry<String, String> entry : cards.entrySet()) {
            assert writer != null;
            writer.write(entry.getKey() + System.lineSeparator());
            writer.write(entry.getValue() + System.lineSeparator());
        }

        assert writer != null;
        writer.close();
        System.out.println(cards.size() + " cards have been saved." + System.lineSeparator());
    }

    /**
     * Remove card
     */
    private void remove() {
        System.out.println("The card:");
        String s = scanner.nextLine();
        if (cards.containsKey(s)) {
            cards.remove(s);
            System.out.println("The card has been removed." + System.lineSeparator());
        } else {
            System.out.println("Can't remove \"" + s + "\": there is no such card." + System.lineSeparator());
        }
    }

    /**
     * Add card
     */
    private void addCard() {
        String card;
        String definition;

        System.out.println("The card:");
        card = scanner.nextLine();
        boolean present;

        present = checkCard(card);
        if (present) {
            System.out.println("The card \"" + card + "\" already exists." + System.lineSeparator());
            return;
        }

        System.out.println("The definition of the card:");
        definition = scanner.nextLine();

        present = checkDefinition(definition);
        if (present) {
            System.out.println("The definition \"" + definition + "\" already exists." + System.lineSeparator());
            return;
        }

        cards.put(card, definition);
        System.out.println("The pair (\"" + card + "\":\"" + definition + "\") has been added." + System.lineSeparator());
    }

    private boolean checkCard(String card) {
        return cards.containsKey(card);
    }

    private boolean checkDefinition(String definition) {
        return cards.containsValue(definition);
    }

    /**
     * Ask card
     */
    private void ask() {
        String answer;
        boolean foundExt;
        String keyExt = "";
        System.out.println("How many times to ask?");
        int count = Integer.parseInt(scanner.nextLine());
        Random random = new Random();
        String key;
        for (int i = 0; i < count; i++) {
            key = (String) cards.keySet().toArray()[random.nextInt(cards.size())];
            System.out.println("Print the definition of \"" + key + "\":");
            answer = scanner.nextLine();
            if (answer.equalsIgnoreCase(cards.get(key))) {
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
                    System.out.println("Wrong answer. The correct one is \"" + cards.get(key) + "\", you've just written the definition of \"" + keyExt + "\".");
                } else {
                    System.out.println("Wrong answer. The correct one is \"" + cards.get(key)+ "\".");
                }
            }
        }
        System.out.println();
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