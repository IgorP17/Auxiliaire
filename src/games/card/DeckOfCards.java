package games.card;

import java.util.ArrayList;
import java.util.Collections;

/**
 * DeckOfCards - singleton
 */
public final class DeckOfCards {

    private static DeckOfCards ourInstance = new DeckOfCards();

    public static DeckOfCards getInstance() {
        return ourInstance;
    }

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
    private DeckOfCards() {

    }

    public ArrayList<Card> getDeck() {
        return arrayCards;
    }

    public ArrayList<Card> getShuffledDeck() {
        ArrayList<Card> result = arrayCards;
        Collections.shuffle(result);
        return result;
    }

    public static void main(String[] args) {
        ArrayList<Card> deck = new DeckOfCards().getDeck();
        for (Card c : deck) {
            System.out.println(c.getIdx() + "\t" + c.getCardValue() + c.getSuit());
        }
        System.out.println("========================");
        deck = new DeckOfCards().getDeck();
        for (Card c : deck) {
            System.out.println(c.getIdx() + "\t" + c.getCardValue() + c.getSuit());
        }
        System.out.println("========================");
        deck = new DeckOfCards().getShuffledDeck();
        for (Card c : deck) {
            System.out.println(c.getIdx() + "\t" + c.getCardValue() + c.getSuit());
        }
    }
}
