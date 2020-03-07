package hyperskill.flashcards;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        FlashCards flashCards = new FlashCards();
        flashCards.run(args);
    }
}

class FlashCards {
    private Scanner scanner = new Scanner(System.in);
    private LinkedHashMap<String, String> cards = new LinkedHashMap<>();
    private LinkedHashMap<String, Integer> mistakes = new LinkedHashMap<>();
    private ArrayList<String> logs = new ArrayList<>();
    private String expFileName;

    /**
     * Main cycle
     */
    void run(String[] args) {
        if (args != null) {
            for (int i = 0; i < args.length; i++) {
                if ("-import".equalsIgnoreCase(args[i])) {
                    if ((i + 1) <  args.length) {
                        loadMap(args[i + 1]);
                    }
                }

                if ("-export".equalsIgnoreCase(args[i])){
                    if ((i + 1) <  args.length) {
                        expFileName = args[i + 1];
                    }
                }

            }
        }
        String s;
        boolean exit = false;
        while (!exit) {
            logAndSave("Input the action (add, remove, import, export, ask, exit, log, hardest card, reset stats):");
            s = scanner.nextLine();
            logs.add(s);
            switch (s) {
                case "add":
                    addCard();
                    break;
                case "remove":
                    remove();
                    break;
                case "import":
                    loadMap("");
                    break;
                case "export":
                    export("");
                    break;
                case "ask":
                    ask();
                    break;
                case "hardest card":
                    hardestCard();
                    break;
                case "reset stats":
                    resetStat();
                    break;
                case "log":
                    log();
                    break;
                case "exit":
                    logAndSave("Bye bye!");
                    if (!expFileName.isBlank()){
                        export(expFileName);
                    }
                    exit = true;
                    break;
            }
        }
    }

    /**
     * Reset stats
     */
    private void resetStat() {
        mistakes.clear();
        logAndSave("Card statistics has been reset." + System.lineSeparator());
    }

    /**
     * Out string and save it
     *
     * @param s - String to sout and save
     */
    private void logAndSave(String s) {
        System.out.println(s);
        logs.add(s);
    }

    /**
     * Save logs
     */
    private void log() {
        logAndSave("File name:");
        String fileName = scanner.nextLine();
        logs.add(fileName);
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(fileName, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert writer != null;
        for (String s : logs) {
            writer.write(s + System.lineSeparator());
        }

        writer.close();
        logAndSave("The log has been saved." + System.lineSeparator());
    }

    /**
     * Find hardest card
     */
    private void hardestCard() {
        if (mistakes.isEmpty()) {
            logAndSave("There are no cards with errors." + System.lineSeparator());
        } else {
            ArrayList<String> hardestCard = new ArrayList<>();
            // find max
            int max = 1;
            for (Map.Entry<String, Integer> entry : mistakes.entrySet()) {
                if (entry.getValue() >= max) {
                    max = entry.getValue();
                }
            }
            // get all ms
            for (Map.Entry<String, Integer> entry : mistakes.entrySet()) {
                if (entry.getValue() == max) {
                    hardestCard.add(entry.getKey());
                }
            }
            if (hardestCard.size() == 0) {
                logAndSave("There are no cards with errors." + System.lineSeparator());
            } else if (hardestCard.size() == 1) {
                logAndSave("The hardest card is \"" + hardestCard.get(0) + "\". You have " + max + " errors answering it." + System.lineSeparator());
            } else {
                StringBuilder out = new StringBuilder("The hardest cards are ");
                for (int i = 0; i < hardestCard.size(); i++) {
                    out.append("\"").append(hardestCard.get(i)).append("\"");
                    if (i == (hardestCard.size() - 1)) {
                        out.append(". You have ").append(max).append(" errors answering them.");
                    } else {
                        out.append(", ");
                    }
                }
                logAndSave(out + System.lineSeparator());
            }

        }
    }

    /**
     * Load cards
     */
    private void loadMap(String fName) {
        String fileName;
        if (fName.isBlank()) {
            logAndSave("File name:");
            fileName = scanner.nextLine();
            logs.add(fileName);
        } else {
            fileName = fName;
        }
        int counter = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line = br.readLine();

            String card;
            String definition;
            String mis;
            while (line != null) {
                card = line;
                definition = br.readLine();
                mis = br.readLine();
                line = br.readLine();
//                logAndSave(card + ":" + definition);
                cards.put(card, definition);
                mistakes.put(card, Integer.valueOf(mis));
                counter++;
            }
        } catch (IOException e) {
            logAndSave("File not found." + System.lineSeparator());
            return;
//            e.printStackTrace();
        }
        logAndSave(counter + " cards have been loaded." + System.lineSeparator());

    }

    /**
     * Save cards
     */
    private void export(String fName) {
        String fileName;
        if (fName.isBlank()) {
            logAndSave("File name:");
            fileName = scanner.nextLine();
            logs.add(fileName);
        } else {
            fileName = fName;
        }

        PrintWriter writer = null;
        try {
            writer = new PrintWriter(fileName, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (Map.Entry<String, String> entry : cards.entrySet()) {
            assert writer != null;
            writer.write(entry.getKey() + System.lineSeparator());
            writer.write(entry.getValue() + System.lineSeparator());
            writer.write(mistakes.get(entry.getKey()) + System.lineSeparator());
        }

        assert writer != null;
        writer.close();
        logAndSave(cards.size() + " cards have been saved." + System.lineSeparator());
    }

    /**
     * Remove card
     */
    private void remove() {
        logAndSave("The card:");
        String s = scanner.nextLine();
        logs.add(s);
        if (cards.containsKey(s)) {
            cards.remove(s);
            mistakes.remove(s);
            logAndSave("The card has been removed." + System.lineSeparator());
        } else {
            logAndSave("Can't remove \"" + s + "\": there is no such card." + System.lineSeparator());
        }
    }

    /**
     * Add card
     */
    private void addCard() {
        String card;
        String definition;

        logAndSave("The card:");
        card = scanner.nextLine();
        logs.add(card);

        boolean present;

        present = cards.containsKey(card);
        if (present) {
            logAndSave("The card \"" + card + "\" already exists." + System.lineSeparator());
            return;
        }

        logAndSave("The definition of the card:");
        definition = scanner.nextLine();
        logs.add(definition);

        present = cards.containsValue(definition);
        if (present) {
            logAndSave("The definition \"" + definition + "\" already exists." + System.lineSeparator());
            return;
        }

        cards.put(card, definition);
        mistakes.put(card, 0);
        logAndSave("The pair (\"" + card + "\":\"" + definition + "\") has been added." + System.lineSeparator());
    }

    /**
     * Ask card
     */
    private void ask() {
        String answer;
        boolean foundExt;
        String keyExt = "";
        logAndSave("How many times to ask?");
        int count = Integer.parseInt(scanner.nextLine());
        logs.add(String.valueOf(count));
        Random random = new Random();
        String key;
        for (int i = 0; i < count; i++) {
            key = (String) cards.keySet().toArray()[random.nextInt(cards.size())];
            logAndSave("Print the definition of \"" + key + "\":");
            answer = scanner.nextLine();
            logs.add(answer);
            if (answer.equalsIgnoreCase(cards.get(key))) {
                logAndSave("Correct answer.");
            } else {
                if (mistakes.containsKey(key)) {
                    mistakes.put(key, mistakes.get(key) + 1);
                } else {
                    mistakes.put(key, 1);
                }
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
                    logAndSave("Wrong answer. The correct one is \"" + cards.get(key) + "\", you've just written the definition of \"" + keyExt + "\".");
                } else {
                    logAndSave("Wrong answer. The correct one is \"" + cards.get(key) + "\".");
                }
            }
        }
        logAndSave("");
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