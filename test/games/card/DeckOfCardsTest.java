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
        ArrayList<Card> deck = DeckOfCards.getShuffledDeck();
        System.out.println("First shuffled card is " + deck.get(0).getIdx() + " " + deck.get(0).getCardValue() + deck.get(0).getSuit());
        System.out.println("Last shuffled card is " + deck.get(51).getIdx() + " " + deck.get(51).getCardValue() + deck.get(51).getSuit());
        deck.sort(cardComparator);
        Assert.assertEquals("First idx = 0", 0, deck.get(0).getIdx());
        Assert.assertEquals("Last idx = 51", 51, deck.get(51).getIdx());
        // and again (if id's went over 51)
        deck = DeckOfCards.getShuffledDeck();
        System.out.println("First shuffled card is " + deck.get(0).getIdx() + " " + deck.get(0).getCardValue() + deck.get(0).getSuit());
        System.out.println("Last shuffled card is " + deck.get(51).getIdx() + " " + deck.get(51).getCardValue() + deck.get(51).getSuit());
        deck.sort(cardComparator);
        Assert.assertEquals("First idx = 0", 0, deck.get(0).getIdx());
        Assert.assertEquals("Last idx = 51", 51, deck.get(51).getIdx());
        System.out.println("Test OK");
    }

    /**
     * Test method unique
     */
    @Test
    public void testUnique(){
        ArrayList<Card> test = new ArrayList<>();
        System.out.println("Test 1 - all unique");
        test.add(DeckOfCards.getCardByValSuit("A", "♠"));
        test.add(DeckOfCards.getCardByValSuit("A", "♣"));
        test.add(DeckOfCards.getCardByValSuit("A", "♥"));
        test.add(DeckOfCards.getCardByValSuit("A", "♦"));
        Assert.assertTrue("All cards are NOT different", DeckOfCards.checkUnique(test));

        System.out.println("Test 2 - not all unique");
        test.clear();
        test.add(DeckOfCards.getCardByValSuit("A", "♠"));
        test.add(DeckOfCards.getCardByValSuit("A", "♣"));
        test.add(DeckOfCards.getCardByValSuit("A", "♣"));
        test.add(DeckOfCards.getCardByValSuit("A", "♦"));
        Assert.assertFalse("Cards ARE different", DeckOfCards.checkUnique(test));
    }
}
