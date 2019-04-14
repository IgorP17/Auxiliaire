package games.card;

import java.util.ArrayList;
import java.util.Collection;

public class PokerChance {

    public static void main(String[] args) {

        ArrayList<Card> deck = DeckOfCards.getInstance().getShuffledDeck();

        Card myFirstCard = deck.get(0);
        Card mySecondCard = deck.get(1);
        Card cOne = deck.get(2);
        Card cTwo = deck.get(3);
        Card cThree = deck.get(4);
        Card cFour = deck.get(5);
        Card cFive = deck.get(6);

        // Flash Royal

        // Street Flash

        // Care

        // Full house

        // Flash

        // Street

        // Set

        // 2 pairs

        // Pair

        // High card

    }

}
