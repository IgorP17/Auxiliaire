package games.card;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class PokerChanceTest {
    @Test
    public void testFlashRoyal() {
        Assert.assertTrue("For null - High card",
                PokerChance.getComboEnum(null) == PokerComboEnum.HIGHCARD);

        ArrayList<Card> example = new ArrayList<>();
        example.add(DeckOfCards.getCardByValSuit("A", "♤"));
        example.add(DeckOfCards.getCardByValSuit("K", "♤"));
        example.add(DeckOfCards.getCardByValSuit("Q", "♤"));
        example.add(DeckOfCards.getCardByValSuit("J", "♤"));
        example.add(DeckOfCards.getCardByValSuit("10", "♤"));
        example.add(DeckOfCards.getCardByValSuit("10", "♧"));
        example.add(DeckOfCards.getCardByValSuit("10", "♧"));
        Assert.assertTrue("♤",
                PokerChance.getComboEnum(example) == PokerComboEnum.FLASHROYAL);

        example.clear();
        example.add(DeckOfCards.getCardByValSuit("2", "♤"));
        example.add(DeckOfCards.getCardByValSuit("K", "♧"));
        example.add(DeckOfCards.getCardByValSuit("Q", "♧"));
        example.add(DeckOfCards.getCardByValSuit("J", "♧"));
        example.add(DeckOfCards.getCardByValSuit("K", "♤"));
        example.add(DeckOfCards.getCardByValSuit("A", "♧"));
        example.add(DeckOfCards.getCardByValSuit("10", "♧"));
        Assert.assertTrue("♧",
                PokerChance.getComboEnum(example) == PokerComboEnum.FLASHROYAL);

        example.clear();
        example.add(DeckOfCards.getCardByValSuit("2", "♤"));
        example.add(DeckOfCards.getCardByValSuit("K", "♧"));
        example.add(DeckOfCards.getCardByValSuit("10", "♡"));
        example.add(DeckOfCards.getCardByValSuit("J", "♡"));
        example.add(DeckOfCards.getCardByValSuit("Q", "♡"));
        example.add(DeckOfCards.getCardByValSuit("K", "♡"));
        example.add(DeckOfCards.getCardByValSuit("A", "♡"));
        Assert.assertTrue("♡",
                PokerChance.getComboEnum(example) == PokerComboEnum.FLASHROYAL);

        example.clear();
        example.add(DeckOfCards.getCardByValSuit("2", "♢"));
        example.add(DeckOfCards.getCardByValSuit("K", "♢"));
        example.add(DeckOfCards.getCardByValSuit("10", "♢"));
        example.add(DeckOfCards.getCardByValSuit("J", "♢"));
        example.add(DeckOfCards.getCardByValSuit("Q", "♢"));
        example.add(DeckOfCards.getCardByValSuit("K", "♢"));
        example.add(DeckOfCards.getCardByValSuit("A", "♢"));
        Assert.assertTrue("♢",
                PokerChance.getComboEnum(example) == PokerComboEnum.FLASHROYAL);

        example.clear();
        example.add(DeckOfCards.getCardByValSuit("A", "♤"));
        example.add(DeckOfCards.getCardByValSuit("K", "♤"));
        example.add(DeckOfCards.getCardByValSuit("Q", "♤"));
        example.add(DeckOfCards.getCardByValSuit("J", "♤"));
        example.add(DeckOfCards.getCardByValSuit("10", "♡"));
        example.add(DeckOfCards.getCardByValSuit("9", "♡"));
        example.add(DeckOfCards.getCardByValSuit("8", "♡"));
        Assert.assertTrue("Street but not flash",
                PokerChance.getComboEnum(example) == PokerComboEnum.HIGHCARD);
        System.out.println("Test OK");
    }
}
