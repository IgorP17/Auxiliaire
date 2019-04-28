package games.card;

import java.util.ArrayList;
import java.util.Collections;

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
        arrayCards.add(new Card("A", "♤"));
        arrayCards.add(new Card("A", "♧"));
        arrayCards.add(new Card("A", "♡"));
        arrayCards.add(new Card("A", "♢"));
        // Kings
        arrayCards.add(new Card("K", "♤"));
        arrayCards.add(new Card("K", "♧"));
        arrayCards.add(new Card("K", "♡"));
        arrayCards.add(new Card("K", "♢"));
        // Queens
        arrayCards.add(new Card("Q", "♤"));
        arrayCards.add(new Card("Q", "♧"));
        arrayCards.add(new Card("Q", "♡"));
        arrayCards.add(new Card("Q", "♢"));
        // Jack
        arrayCards.add(new Card("J", "♤"));
        arrayCards.add(new Card("J", "♧"));
        arrayCards.add(new Card("J", "♡"));
        arrayCards.add(new Card("J", "♢"));
        // 10
        arrayCards.add(new Card("10", "♤"));
        arrayCards.add(new Card("10", "♧"));
        arrayCards.add(new Card("10", "♡"));
        arrayCards.add(new Card("10", "♢"));
        // 9
        arrayCards.add(new Card("9", "♤"));
        arrayCards.add(new Card("9", "♧"));
        arrayCards.add(new Card("9", "♡"));
        arrayCards.add(new Card("9", "♢"));
        // 8
        arrayCards.add(new Card("8", "♤"));
        arrayCards.add(new Card("8", "♧"));
        arrayCards.add(new Card("8", "♡"));
        arrayCards.add(new Card("8", "♢"));
        // 7
        arrayCards.add(new Card("7", "♤"));
        arrayCards.add(new Card("7", "♧"));
        arrayCards.add(new Card("7", "♡"));
        arrayCards.add(new Card("7", "♢"));
        // 6
        arrayCards.add(new Card("6", "♤"));
        arrayCards.add(new Card("6", "♧"));
        arrayCards.add(new Card("6", "♡"));
        arrayCards.add(new Card("6", "♢"));
        // 5
        arrayCards.add(new Card("5", "♤"));
        arrayCards.add(new Card("5", "♧"));
        arrayCards.add(new Card("5", "♡"));
        arrayCards.add(new Card("5", "♢"));
        // 4
        arrayCards.add(new Card("4", "♤"));
        arrayCards.add(new Card("4", "♧"));
        arrayCards.add(new Card("4", "♡"));
        arrayCards.add(new Card("4", "♢"));
        // 3
        arrayCards.add(new Card("3", "♤"));
        arrayCards.add(new Card("3", "♧"));
        arrayCards.add(new Card("3", "♡"));
        arrayCards.add(new Card("3", "♢"));
        // 2
        arrayCards.add(new Card("2", "♤"));
        arrayCards.add(new Card("2", "♧"));
        arrayCards.add(new Card("2", "♡"));
        arrayCards.add(new Card("2", "♢"));
    }

    // Constructor
    DeckOfCards() {

    }

    /**
     * Get shuffled deck
     *
     * @return - Array list of cards shuffled
     */
    public static ArrayList<Card> getShuffledDeck() {
        ArrayList<Card> result = arrayCards;
        Collections.shuffle(result);
        return result;
    }

    /**
     * Get Card in Deck by Val an Suite
     *
     * @param val  - Value, A,K,Q,J,10...
     * @param suit - Suit ♤♧♡♢
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


    public static void main(String[] args) {
        ArrayList<Card> deck = DeckOfCards.getShuffledDeck();
        for (Card c : deck) {
            System.out.println(c.getIdx() + "\t" + c.getCardValue() + c.getSuit());
        }
    }
}
