package games.card;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * DeckOfCards - singleton
 */
public final class DeckOfCards {

//    private static DeckOfCards ourInstance = new DeckOfCards();

//    public static DeckOfCards getInstance() {
//        return ourInstance;
//    }

    // Static deck
    private static ArrayList<Card> arrayCards;

    static {
        arrayCards = new ArrayList<>();
        // Aces
        arrayCards.add(new Card("A", "♠", 0));
        arrayCards.add(new Card("A", "♣", 0));
        arrayCards.add(new Card("A", "♥", 0));
        arrayCards.add(new Card("A", "♦", 0));
        // Kings
        arrayCards.add(new Card("K", "♠", 1));
        arrayCards.add(new Card("K", "♣", 1));
        arrayCards.add(new Card("K", "♥", 1));
        arrayCards.add(new Card("K", "♦", 1));
        // Queens
        arrayCards.add(new Card("Q", "♠", 2));
        arrayCards.add(new Card("Q", "♣", 2));
        arrayCards.add(new Card("Q", "♥", 2));
        arrayCards.add(new Card("Q", "♦", 2));
        // Jack
        arrayCards.add(new Card("J", "♠", 3));
        arrayCards.add(new Card("J", "♣", 3));
        arrayCards.add(new Card("J", "♥", 3));
        arrayCards.add(new Card("J", "♦", 3));
        // 10
        arrayCards.add(new Card("10", "♠", 4));
        arrayCards.add(new Card("10", "♣", 4));
        arrayCards.add(new Card("10", "♥", 4));
        arrayCards.add(new Card("10", "♦", 4));
        // 9
        arrayCards.add(new Card("9", "♠", 5));
        arrayCards.add(new Card("9", "♣", 5));
        arrayCards.add(new Card("9", "♥", 5));
        arrayCards.add(new Card("9", "♦", 5));
        // 8
        arrayCards.add(new Card("8", "♠", 6));
        arrayCards.add(new Card("8", "♣", 6));
        arrayCards.add(new Card("8", "♥", 6));
        arrayCards.add(new Card("8", "♦", 6));
        // 7
        arrayCards.add(new Card("7", "♠", 7));
        arrayCards.add(new Card("7", "♣", 7));
        arrayCards.add(new Card("7", "♥", 7));
        arrayCards.add(new Card("7", "♦", 7));
        // 6
        arrayCards.add(new Card("6", "♠", 8));
        arrayCards.add(new Card("6", "♣", 8));
        arrayCards.add(new Card("6", "♥", 8));
        arrayCards.add(new Card("6", "♦", 8));
        // 5
        arrayCards.add(new Card("5", "♠", 9));
        arrayCards.add(new Card("5", "♣", 9));
        arrayCards.add(new Card("5", "♥", 9));
        arrayCards.add(new Card("5", "♦", 9));
        // 4
        arrayCards.add(new Card("4", "♠", 10));
        arrayCards.add(new Card("4", "♣", 10));
        arrayCards.add(new Card("4", "♥", 10));
        arrayCards.add(new Card("4", "♦", 10));
        // 3
        arrayCards.add(new Card("3", "♠", 11));
        arrayCards.add(new Card("3", "♣", 11));
        arrayCards.add(new Card("3", "♥", 11));
        arrayCards.add(new Card("3", "♦", 11));
        // 2
        arrayCards.add(new Card("2", "♠", 12));
        arrayCards.add(new Card("2", "♣", 12));
        arrayCards.add(new Card("2", "♥", 12));
        arrayCards.add(new Card("2", "♦", 12));
    }



    /**
     * Get shuffled deck with exclusions
     *
     * @param exclude - list of cards to exclude
     * @return - shuffled list exclude necessary cards
     */
    public static ArrayList<Card> getShuffledDeckExclude(ArrayList<Card> exclude) {
        ArrayList<Card> result = new ArrayList<>(arrayCards);
//        System.out.println("Excluding");
//        printCards(exclude);
        for (Card c :
                exclude) {
            result.remove(c);
        }
        Collections.shuffle(result);
//        System.out.println("shuffled: " + result.size());
        return result;
    }

    /**
     * Get Card in Deck by Val an Suite
     *
     * @param val  - Value, A,K,Q,J,10...
     * @param suit - Suit ♠♣♥♦
     * @return - Card object
     */
    public static Card getCardByValSuit(String val, String suit) {
        for (Card c :
                arrayCards) {
            if (c.getCardValue().equals(val) && c.getSuit().equals(suit))
                return c;
        }
        return null;
    }

    /**
     * Print list of cards in row
     *
     * @param cards - list of cards
     */
    public static void printCards(List<Card> cards) {
        try {
            PrintStream ps = new PrintStream(System.out, true, "UTF-8");
            for (Card c :
                    cards) {
                ps.print(c.getCardValue() + c.getSuit() + " ");
            }
            System.out.println();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    /**
     * Check if list of cards is unique
     *
     * @param arrayCards - list of cards
     * @return - true if unique
     */
    public static boolean checkUnique(ArrayList<Card> arrayCards) {
        int len = arrayCards.size();
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                // skip current card under check
                if (i == j) continue;
                if (arrayCards.get(i) == arrayCards.get(j)) {
                    System.out.println("WARNING! Found duplicates:");
                    printCards(arrayCards);
                    return false;
                }
            }
        }
        return true;
    }
}
