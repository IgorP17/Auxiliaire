package games.card;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;


import static games.card.Card.cardComparator;

public class DeckOfCardsTest {

    /**
     * Test if id's of deck are 0 - 51
     */
    @Test
    public void testDeck() {
        ArrayList<Card> deck = DeckOfCards.getInstance().getShuffledDeck();
        System.out.println("First card is " + deck.get(0).getIdx() + " " + deck.get(0).getCardValue() + deck.get(0).getSuit());
        System.out.println("Last card is " + deck.get(51).getIdx() + " " + deck.get(51).getCardValue() + deck.get(51).getSuit());
        deck.sort(cardComparator);
        Assert.assertTrue("First idx = 0", deck.get(0).getIdx() == 0);
        Assert.assertTrue("Last idx = 51", deck.get(51).getIdx() == 51);
        // and again (if id's went over 51)
        deck = DeckOfCards.getInstance().getShuffledDeck();
        System.out.println("First card is " + deck.get(0).getIdx() + " " + deck.get(0).getCardValue() + deck.get(0).getSuit());
        System.out.println("Last card is " + deck.get(51).getIdx() + " " + deck.get(51).getCardValue() + deck.get(51).getSuit());
        deck.sort(cardComparator);
        Assert.assertTrue("First idx = 0", deck.get(0).getIdx() == 0);
        Assert.assertTrue("Last idx = 51", deck.get(51).getIdx() == 51);
    }
}
