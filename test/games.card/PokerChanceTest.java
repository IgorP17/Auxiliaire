package games.card;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class PokerChanceTest {
    @Test
    public void testFlashRoyal() {
        // TODO uncomment
        Assert.assertTrue("For null - null",
                PokerChance.getComboEnum(null) == null);

        ArrayList<Card> example = new ArrayList<>();
        example.add(DeckOfCards.getCardByValSuit("A", "♤"));
        example.add(DeckOfCards.getCardByValSuit("K", "♤"));
        example.add(DeckOfCards.getCardByValSuit("Q", "♤"));
        example.add(DeckOfCards.getCardByValSuit("J", "♤"));
        example.add(DeckOfCards.getCardByValSuit("10", "♤"));
        example.add(DeckOfCards.getCardByValSuit("10", "♧"));
        example.add(DeckOfCards.getCardByValSuit("10", "♡"));
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

        /*example.clear();
        example.add(DeckOfCards.getCardByValSuit("A", "♤"));
        example.add(DeckOfCards.getCardByValSuit("K", "♤"));
        example.add(DeckOfCards.getCardByValSuit("Q", "♤"));
        example.add(DeckOfCards.getCardByValSuit("J", "♤"));
        example.add(DeckOfCards.getCardByValSuit("10", "♡"));
        example.add(DeckOfCards.getCardByValSuit("9", "♡"));
        example.add(DeckOfCards.getCardByValSuit("8", "♡"));
        Assert.assertTrue("Street but not flash",
                PokerChance.getComboEnum(example) == PokerComboEnum.HIGHCARD);*/

        // TODO add street flash

        System.out.println("Test Flash Royal OK");
    }

    @Test
    public void testStreetFlash() {
        // TODO uncomment
        ArrayList<Card> example = new ArrayList<>();
        example.add(DeckOfCards.getCardByValSuit("K", "♤"));
        example.add(DeckOfCards.getCardByValSuit("Q", "♤"));
        example.add(DeckOfCards.getCardByValSuit("J", "♤"));
        example.add(DeckOfCards.getCardByValSuit("10", "♤"));
        example.add(DeckOfCards.getCardByValSuit("9", "♤"));
        example.add(DeckOfCards.getCardByValSuit("10", "♧"));
        example.add(DeckOfCards.getCardByValSuit("10", "♡"));
        Assert.assertTrue("Street Flash ♤",
                PokerChance.getComboEnum(example) == PokerComboEnum.STREETFLASH);
        example.clear();
        example.add(DeckOfCards.getCardByValSuit("9", "♧"));
        example.add(DeckOfCards.getCardByValSuit("2", "♤"));
        example.add(DeckOfCards.getCardByValSuit("10", "♧"));
        example.add(DeckOfCards.getCardByValSuit("J", "♧"));
        example.add(DeckOfCards.getCardByValSuit("Q", "♧"));
        example.add(DeckOfCards.getCardByValSuit("K", "♧"));
        example.add(DeckOfCards.getCardByValSuit("A", "♡"));
        Assert.assertTrue("Street Flash ♧",
                PokerChance.getComboEnum(example) == PokerComboEnum.STREETFLASH);
        example.clear();
        example.add(DeckOfCards.getCardByValSuit("2", "♡"));
        example.add(DeckOfCards.getCardByValSuit("3", "♡"));
        example.add(DeckOfCards.getCardByValSuit("10", "♧"));
        example.add(DeckOfCards.getCardByValSuit("J", "♧"));
        example.add(DeckOfCards.getCardByValSuit("4", "♡"));
        example.add(DeckOfCards.getCardByValSuit("5", "♡"));
        example.add(DeckOfCards.getCardByValSuit("6", "♡"));
        Assert.assertTrue("Street Flash ♡",
                PokerChance.getComboEnum(example) == PokerComboEnum.STREETFLASH);
        example.clear();
        example.add(DeckOfCards.getCardByValSuit("J", "♢"));
        example.add(DeckOfCards.getCardByValSuit("8", "♢"));
        example.add(DeckOfCards.getCardByValSuit("10", "♢"));
        example.add(DeckOfCards.getCardByValSuit("J", "♧"));
        example.add(DeckOfCards.getCardByValSuit("Q", "♢"));
        example.add(DeckOfCards.getCardByValSuit("5", "♡"));
        example.add(DeckOfCards.getCardByValSuit("9", "♢"));
        Assert.assertTrue("Street Flash ♢",
                PokerChance.getComboEnum(example) == PokerComboEnum.STREETFLASH);
//        example.clear();
//        example.add(DeckOfCards.getCardByValSuit("J", "♢"));
//        example.add(DeckOfCards.getCardByValSuit("8", "♢"));
//        example.add(DeckOfCards.getCardByValSuit("10", "♢"));
//        example.add(DeckOfCards.getCardByValSuit("J", "♧"));
//        example.add(DeckOfCards.getCardByValSuit("Q", "♧"));
//        example.add(DeckOfCards.getCardByValSuit("5", "♡"));
//        example.add(DeckOfCards.getCardByValSuit("9", "♢"));
//        Assert.assertTrue("Street but not flash",
//                PokerChance.getComboEnum(example) == PokerComboEnum.STREET);

//        example.clear();
//        example.add(DeckOfCards.getCardByValSuit("A", "♢"));
//        example.add(DeckOfCards.getCardByValSuit("Q", "♢"));
//        example.add(DeckOfCards.getCardByValSuit("10", "♢"));
//        example.add(DeckOfCards.getCardByValSuit("8", "♢"));
//        example.add(DeckOfCards.getCardByValSuit("6", "♢"));
//        example.add(DeckOfCards.getCardByValSuit("5", "♡"));
//        example.add(DeckOfCards.getCardByValSuit("9", "♡"));
//        Assert.assertTrue("Flash but not street",
//                PokerChance.getComboEnum(example) == PokerComboEnum.FLASH);
        System.out.println("Test Street Flash OK");
    }

    @Test
    public void testCare(){
        // TODO ALL CARE
        ArrayList<Card> example = new ArrayList<>();
        example.add(DeckOfCards.getCardByValSuit("A", "♤"));
        example.add(DeckOfCards.getCardByValSuit("A", "♧"));
        example.add(DeckOfCards.getCardByValSuit("A", "♢"));
        example.add(DeckOfCards.getCardByValSuit("A", "♡"));
        example.add(DeckOfCards.getCardByValSuit("9", "♤"));
        example.add(DeckOfCards.getCardByValSuit("10", "♧"));
        example.add(DeckOfCards.getCardByValSuit("10", "♡"));
        Assert.assertTrue("Care A",
                PokerChance.getComboEnum(example) == PokerComboEnum.CARE);
    }

}
