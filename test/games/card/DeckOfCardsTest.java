package games.card;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class DeckOfCardsTest {

    /**
     * Test method unique
     */
    @Test
    public void testUnique() {
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
