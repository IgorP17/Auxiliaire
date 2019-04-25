package games.card;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;


import static games.card.Card.cardComparator;

public class DeckOfCardsTest {

    /**
     * Test if id's of deck are the same for couple instances
     */
    @Test
    public void testDeck() {
        ArrayList<Card> deck1 = DeckOfCards.getInstance().getDeck();
        ArrayList<Card> deck2 = DeckOfCards.getInstance().getDeck();
        ArrayList<Card> deck3 = DeckOfCards.getInstance().getShuffledDeck();
        ArrayList<Card> deck4 = DeckOfCards.getInstance().getShuffledDeck();


//        Collections.sort(deck3, cardComparator);
//        deck3.add(new Card("A", "♤"));
        for (Card c: deck3
             ) {
            System.out.println(c.getIdx());
        }


    }
}
