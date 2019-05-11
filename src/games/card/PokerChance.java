package games.card;

import java.io.*;
import java.util.ArrayList;

public class PokerChance {

    private static ArrayList<Card> firstHand = new ArrayList<>();
    private static ArrayList<Card> secondHand = new ArrayList<>();
    private static int count = 10000000;
    private static char[] animationChars = new char[]{'|', '/', '-', '\\'};


    public static void main(String[] args) {
        System.out.println("Reading config...");
        readConfig("Hands.txt");
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
        ArrayList<Card> deal = new ArrayList<>();
        ArrayList<Card> exclude = new ArrayList<>();
        exclude.addAll(firstHand);
        exclude.addAll(secondHand);
        System.out.print("Processing: " + 0 + "% " + animationChars[0 % 4] + "\r");
        for (int i = 0; i < count; i++) {
            // Show progress
            if (i == percCounter) {
                percCounter += count / 100;
                System.out.print("Processing: " + percentage + "% " + animationChars[percentage % 4] + "\r");
                percentage += 1;
            }
            // Get 5 random cards
            deal = (ArrayList<Card>) DeckOfCards.getShuffledDeckExclude(exclude).subList(0, 5);
            // add first hand and deal
            firstHandDeal.addAll(firstHand);
            firstHandDeal.addAll(deal);
            // add second hand and deal
            secondHandDeal.addAll(secondHand);
            secondHandDeal.addAll(deal);


            // clear hands deal
            deal.clear();
            firstHandDeal.clear();
            secondHandDeal.clear();
        }
        System.out.println("Processing: Done!          ");
        System.exit(0);


        ArrayList<Card> example = new ArrayList<>();
        example.add(DeckOfCards.getCardByValSuit("A", "♠"));
        example.add(DeckOfCards.getCardByValSuit("A", "♣"));
//        example.add(DeckOfCards.getCardByValSuit("K", "♦"));
//        example.add(DeckOfCards.getCardByValSuit("Q", "♦"));
        int
                cntFlashRoyal = 0,
                cntStreetFlash = 0,
                cntCare = 0,
                cntFullHouse = 0,
                cntFlash = 0,
                cntStreet = 0,
                cntSet = 0,
                cntPairs = 0,
                cntPair = 0,
                cntHighCard = 0;
//        ArrayList<Card> deal = new ArrayList<>();
        int count = 10000000;
        for (int i = 0; i < count; i++) {
            if (i == count / 4) System.out.println("25% done");
            if (i == count / 2) System.out.println("50% done");
            if (i == count / 2 + count / 4) System.out.println("75% done");
            deal.addAll(example);
            deal.addAll(DeckOfCards.getShuffledDeckExclude(example).subList(0, 5));
            switch (PokerComboGetter.getComboEnum(deal)) {
                case FLASHROYAL:
                    cntFlashRoyal++;
                    break;
                case STREETFLASH:
                    cntStreetFlash++;
                    break;
                case CARE:
                    cntCare++;
                    break;
                case FULLHOUSE:
                    cntFullHouse++;
                    break;
                case FLASH:
                    cntFlash++;
                    break;
                case STREET:
                    cntStreet++;
                    break;
                case SET:
                    cntSet++;
                    break;
                case PAIRS:
                    cntPairs++;
                    break;
                case PAIR:
                    cntPair++;
                    break;
                case HIGHCARD:
                    cntHighCard++;
                    break;
                default:
                    System.out.println("WTF!!!");
                    System.exit(1);

            }
            deal.clear();
        }
        System.out.println("Flash Royal  = " + 100.0 * cntFlashRoyal / count + "%");
        System.out.println("Street Flash = " + 100.0 * cntStreetFlash / count + "%");
        System.out.println("Care         = " + 100.0 * cntCare / count + "%");
        System.out.println("Full House   = " + 100.0 * cntFullHouse / count + "%");
        System.out.println("Flash        = " + 100.0 * cntFlash / count + "%");
        System.out.println("Street       = " + 100.0 * cntStreet / count + "%");
        System.out.println("Set          = " + 100.0 * cntSet / count + "%");
        System.out.println("Pairs        = " + 100.0 * cntPairs / count + "%");
        System.out.println("Pair         = " + 100.0 * cntPair / count + "%");
        System.out.println("High Card    = " + 100.0 * cntHighCard / count + "%");
        System.out.println("Total        = " + (cntFlashRoyal +
                cntStreetFlash + cntCare + cntFullHouse + cntFlash + cntStreet +
                cntSet + cntPairs + cntPair + cntHighCard) * 100.0 / count + "%");
    }

    /**
     * Read config with UTF-8 support
     *
     * @param s - path to config
     */
    private static void readConfig(String s) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(
                new FileInputStream(s), "UTF8"))) {
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
                    } else if (line.startsWith("Deals")){
                        count = Integer.parseInt(line.split("=")[1]);
                    }
                }
                line = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
