package games.card;

import java.io.*;
import java.util.*;

class PokerChance {

    private static ArrayList<Card> firstHand = new ArrayList<>();
    private static ArrayList<Card> secondHand = new ArrayList<>();
    private static int count = 10000000;
    private static char[] animationChars = new char[]{'|', '/', '-', '\\'};


    public static void main(String[] args) {
        System.out.println("Reading config...");
        // read config
        readConfig();
        System.out.println("Done!");
        System.out.println("First hand:");
        DeckOfCards.printCards(firstHand);
        System.out.println("Second hand:");
        DeckOfCards.printCards(secondHand);
        System.out.println("Number of Deals = " + count);

        int percCounter = count / 100;
        int percentage = 0;
        ArrayList<Card> firstHandDeal = new ArrayList<>();
        ArrayList<Card> secondHandDeal = new ArrayList<>();
        List<Card> deal;
        ArrayList<Card> exclude = new ArrayList<>();
        int[][] wins = {
                {0, 0, 0},
                {0, 0, 0}};// first hand wins, lose, draw, second hand the same
        PokerComboEnum firstE, secondE;
        HashMap<PokerComboEnum, Integer> mapFirstHand = initHandMap();
        HashMap<PokerComboEnum, Integer> mapSecondHand = initHandMap();

        exclude.addAll(firstHand);
        exclude.addAll(secondHand);
        long ms = System.currentTimeMillis();
        System.out.print("Processing: " + 0 + "% " + animationChars[0 % 4] + "\r");
        for (int i = 0; i < count; i++) {
            // Show progress
            if (i == percCounter) {
                percCounter += count / 100;
                System.out.print("Processing: " + percentage + "% " + animationChars[percentage % 4] + "\r");
                percentage += 1;
            }
            // Get 5 random cards
            deal = DeckOfCards.getShuffledDeckExclude(exclude).subList(0, 5);
//            System.out.println("Deal number " + i + " is:");
//            DeckOfCards.printCards(deal);
            // add first hand and deal
            firstHandDeal.addAll(firstHand);
            firstHandDeal.addAll(deal);
            // add second hand and deal
            secondHandDeal.addAll(secondHand);
            secondHandDeal.addAll(deal);

            // check if we have unique deal
            if (!DeckOfCards.checkUnique(firstHandDeal) ||
                    !DeckOfCards.checkUnique(secondHandDeal)) {
                System.out.println("ERROR! Deal is not unique");
                System.exit(1);
            }

            // check winner
            firstE = PokerComboGetter.getComboEnum(firstHandDeal);
            secondE = PokerComboGetter.getComboEnum(secondHandDeal);
//            System.out.println(firstE + " " + secondE);
            if (firstE.getPriority() < secondE.getPriority()) {
                // first hand win
//                System.out.println("First hand win! With " + firstE);
                wins[0][0]++;
                wins[1][1]++;
            } else if (firstE.getPriority() > secondE.getPriority()) {
                // second hand win
//                System.out.println("Second hand win! With " + secondE);
                wins[0][1]++;
                wins[1][0]++;
            } else {
                // draw
                // TODO check high cards
//                System.out.println("Draw! " + firstE + " " + secondE);
                wins[0][2]++;
                wins[1][2]++;
            }
            // fill HashMap
            mapFirstHand.replace(firstE, mapFirstHand.get(firstE) + 1);
            mapSecondHand.replace(secondE, mapSecondHand.get(secondE) + 1);

            // clear hands deal
            deal.clear();
            firstHandDeal.clear();
            secondHandDeal.clear();
        }
        System.out.println("Processing: Done!          ");

        // print results
        System.out.println("Results\t\t\tWIN\t\tLOS\t\tDRAW");
        System.out.println("First hand\t\t" + Math.round(wins[0][0] * 100.0 / count)
                + "%\t\t" + Math.round(wins[0][1] * 100.0 / count)
                + "%\t\t" + Math.round(wins[0][2] * 100.0 / count) + "%");

        System.out.println("Second hand\t\t" + Math.round(wins[1][0] * 100.0 / count)
                + "%\t\t" + Math.round(wins[1][1] * 100.0 / count)
                + "%\t\t" + Math.round(wins[1][2] * 100.0 / count) + "%");

        System.out.println("==================================");
        // print stat for hand
        PokerComboEnum[] pke = PokerComboEnum.values();
        // sort
        Arrays.sort(pke, Comparator.comparingInt(PokerComboEnum::getPriority));
        for (PokerComboEnum pokerComboEnum :
                pke) {
           System.out.printf("%-15s%-15d%d%n", pokerComboEnum,
                   mapFirstHand.get(pokerComboEnum),
                   mapSecondHand.get(pokerComboEnum));
        }
        ms = System.currentTimeMillis() - ms;
        System.out.println("Elapsed: " + ms + " ms");
    }

    /**
     * Read config with UTF-8 support
     */
    private static void readConfig() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(
                new FileInputStream("Hands.txt"), "UTF8"))) {
            String line = br.readLine();
            while (line != null) {
                line = line.trim();
                if (!line.equalsIgnoreCase("") &&
                        !line.startsWith("#")) {
                    if (line.startsWith("Hands")) {
                        String vals = line.split("=")[1];
                        String[] cards = vals.split(";");
                        String hand1Card1 = cards[0].split(",")[0];
                        String hand1Card2 = cards[0].split(",")[1];
                        String hand2Card1 = cards[1].split(",")[0];
                        String hand2Card2 = cards[1].split(",")[1];

                        firstHand.add(DeckOfCards.getCardByValSuit(
                                hand1Card1.substring(0, hand1Card1.length() - 1),
                                hand1Card1.substring(hand1Card1.length() - 1)));
                        firstHand.add(DeckOfCards.getCardByValSuit(
                                hand1Card2.substring(0, hand1Card2.length() - 1),
                                hand1Card2.substring(hand1Card2.length() - 1)));
                        secondHand.add(DeckOfCards.getCardByValSuit(
                                hand2Card1.substring(0, hand2Card1.length() - 1),
                                hand2Card1.substring(hand2Card1.length() - 1)));
                        secondHand.add(DeckOfCards.getCardByValSuit(
                                hand2Card2.substring(0, hand2Card2.length() - 1),
                                hand2Card2.substring(hand2Card2.length() - 1)));
                    } else if (line.startsWith("Deals")) {
                        count = Integer.parseInt(line.split("=")[1]);
                    }
                }
                line = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Init HashMap with result combinations
     *
     * @return - init HashMap
     */
    private static HashMap<PokerComboEnum, Integer> initHandMap() {
        HashMap<PokerComboEnum, Integer> result = new HashMap<>();
        result.put(PokerComboEnum.FLASHROYAL, 0);
        result.put(PokerComboEnum.STREETFLASH, 0);
        result.put(PokerComboEnum.CARE, 0);
        result.put(PokerComboEnum.FULLHOUSE, 0);
        result.put(PokerComboEnum.FLASH, 0);
        result.put(PokerComboEnum.STREET, 0);
        result.put(PokerComboEnum.SET, 0);
        result.put(PokerComboEnum.PAIRS, 0);
        result.put(PokerComboEnum.PAIR, 0);
        result.put(PokerComboEnum.HIGHCARD, 0);
        return result;
    }
}
