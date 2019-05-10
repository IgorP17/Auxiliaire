package games.card;

import java.io.*;
import java.util.ArrayList;

public class PokerChance {

    private static ArrayList<Card> firstHand, secondHand;
    private static int count = 1000000;
    private static char[] animationChars = new char[]{'|', '/', '-', '\\'};

    private static ArrayList<Card> getHandFromConsole(String hand) {
        System.out.println("Please enter " + hand);
        System.out.println("Valid input is like: A♦ K♣");
        System.out.println("Valid Values of card: A K Q J 10 9 8 7 6 5 4 3 2");
        System.out.println("Valid Suits: ♠ ♣ ♥ ♦ ♠♣♥♦");

        try {
            PrintStream ps = new PrintStream(System.out, true, "UTF-8");
            ps.println("111Valid Suits: ♠ ♣ ♥ ♦ ♠♣♥♦");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        ArrayList<Card> result = new ArrayList<>();
        BufferedReader reader;
        String in;

        reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            in = reader.readLine();
            String[] s = in.split(" ");
            Card c1 = DeckOfCards.getCardByValSuit(
                    s[0].substring(0, s[0].length() - 1),
                    s[0].substring(s[0].length() - 1));
            Card c2 = DeckOfCards.getCardByValSuit(
                    s[1].substring(0, s[0].length() - 1),
                    s[1].substring(s[0].length() - 1));
            result.add(c1);
            result.add(c2);
            return result;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static void getCount() {
        System.out.println("Enter number of deals [default 1M, press enter]:");
        BufferedReader reader;
        String in;
        reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            in = reader.readLine();
            count = Integer.parseInt(in);
        } catch (Exception e) {
            System.out.println("Defaulting to 1M");
        }
    }

    public static void main(String[] args) {
        System.out.println("Welcome!");

        firstHand = getHandFromConsole("First Hand");
        secondHand = getHandFromConsole("Second Hand");

        getCount();
        int percentage = count / 100;
        System.out.println(percentage);

        for (int i = 0; i < count; i++) {

            System.out.print("Processing: " + i + "% " + animationChars[i % 4] + "\r");
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
        ArrayList<Card> deal = new ArrayList<>();
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
}
