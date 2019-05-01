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

        System.out.println("0. Test Flash Royal - OK");
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
        System.out.println("1. Test Street Flash - OK");
    }

    @Test
    public void testCare(){
        // TODO uncomment
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
        example.clear();
        example.add(DeckOfCards.getCardByValSuit("K", "♤"));
        example.add(DeckOfCards.getCardByValSuit("K", "♧"));
        example.add(DeckOfCards.getCardByValSuit("K", "♢"));
        example.add(DeckOfCards.getCardByValSuit("9", "♤"));
        example.add(DeckOfCards.getCardByValSuit("K", "♡"));
        example.add(DeckOfCards.getCardByValSuit("10", "♧"));
        example.add(DeckOfCards.getCardByValSuit("10", "♡"));
        Assert.assertTrue("Care K",
                PokerChance.getComboEnum(example) == PokerComboEnum.CARE);
        example.clear();
        example.add(DeckOfCards.getCardByValSuit("Q", "♤"));
        example.add(DeckOfCards.getCardByValSuit("Q", "♧"));
        example.add(DeckOfCards.getCardByValSuit("Q", "♢"));
        example.add(DeckOfCards.getCardByValSuit("9", "♤"));
        example.add(DeckOfCards.getCardByValSuit("Q", "♡"));
        example.add(DeckOfCards.getCardByValSuit("10", "♧"));
        example.add(DeckOfCards.getCardByValSuit("10", "♡"));
        Assert.assertTrue("Care Q",
                PokerChance.getComboEnum(example) == PokerComboEnum.CARE);
        example.clear();
        example.add(DeckOfCards.getCardByValSuit("J", "♤"));
        example.add(DeckOfCards.getCardByValSuit("J", "♧"));
        example.add(DeckOfCards.getCardByValSuit("J", "♢"));
        example.add(DeckOfCards.getCardByValSuit("9", "♤"));
        example.add(DeckOfCards.getCardByValSuit("J", "♡"));
        example.add(DeckOfCards.getCardByValSuit("10", "♧"));
        example.add(DeckOfCards.getCardByValSuit("10", "♡"));
        Assert.assertTrue("Care J",
                PokerChance.getComboEnum(example) == PokerComboEnum.CARE);
        example.clear();
        example.add(DeckOfCards.getCardByValSuit("10", "♤"));
        example.add(DeckOfCards.getCardByValSuit("10", "♧"));
        example.add(DeckOfCards.getCardByValSuit("10", "♢"));
        example.add(DeckOfCards.getCardByValSuit("9", "♤"));
        example.add(DeckOfCards.getCardByValSuit("10", "♡"));
        example.add(DeckOfCards.getCardByValSuit("J", "♧"));
        example.add(DeckOfCards.getCardByValSuit("J", "♡"));
        Assert.assertTrue("Care 10",
                PokerChance.getComboEnum(example) == PokerComboEnum.CARE);
        example.clear();
        example.add(DeckOfCards.getCardByValSuit("K", "♤"));
        example.add(DeckOfCards.getCardByValSuit("9", "♤"));
        example.add(DeckOfCards.getCardByValSuit("9", "♧"));
        example.add(DeckOfCards.getCardByValSuit("9", "♢"));
        example.add(DeckOfCards.getCardByValSuit("9", "♡"));
        example.add(DeckOfCards.getCardByValSuit("J", "♧"));
        example.add(DeckOfCards.getCardByValSuit("J", "♡"));
        Assert.assertTrue("Care 9",
                PokerChance.getComboEnum(example) == PokerComboEnum.CARE);
        example.clear();
        example.add(DeckOfCards.getCardByValSuit("K", "♤"));
        example.add(DeckOfCards.getCardByValSuit("8", "♤"));
        example.add(DeckOfCards.getCardByValSuit("8", "♧"));
        example.add(DeckOfCards.getCardByValSuit("8", "♢"));
        example.add(DeckOfCards.getCardByValSuit("8", "♡"));
        example.add(DeckOfCards.getCardByValSuit("J", "♧"));
        example.add(DeckOfCards.getCardByValSuit("J", "♡"));
        Assert.assertTrue("Care 8",
                PokerChance.getComboEnum(example) == PokerComboEnum.CARE);
        example.clear();
        example.add(DeckOfCards.getCardByValSuit("K", "♤"));
        example.add(DeckOfCards.getCardByValSuit("7", "♤"));
        example.add(DeckOfCards.getCardByValSuit("7", "♧"));
        example.add(DeckOfCards.getCardByValSuit("7", "♢"));
        example.add(DeckOfCards.getCardByValSuit("7", "♡"));
        example.add(DeckOfCards.getCardByValSuit("J", "♧"));
        example.add(DeckOfCards.getCardByValSuit("J", "♡"));
        Assert.assertTrue("Care 7",
                PokerChance.getComboEnum(example) == PokerComboEnum.CARE);
        example.clear();
        example.add(DeckOfCards.getCardByValSuit("K", "♤"));
        example.add(DeckOfCards.getCardByValSuit("6", "♤"));
        example.add(DeckOfCards.getCardByValSuit("6", "♧"));
        example.add(DeckOfCards.getCardByValSuit("6", "♢"));
        example.add(DeckOfCards.getCardByValSuit("J", "♧"));
        example.add(DeckOfCards.getCardByValSuit("6", "♡"));
        example.add(DeckOfCards.getCardByValSuit("J", "♡"));
        Assert.assertTrue("Care 6",
                PokerChance.getComboEnum(example) == PokerComboEnum.CARE);
        example.clear();
        example.add(DeckOfCards.getCardByValSuit("5", "♤"));
        example.add(DeckOfCards.getCardByValSuit("K", "♤"));
        example.add(DeckOfCards.getCardByValSuit("5", "♧"));
        example.add(DeckOfCards.getCardByValSuit("J", "♧"));
        example.add(DeckOfCards.getCardByValSuit("5", "♢"));
        example.add(DeckOfCards.getCardByValSuit("J", "♡"));
        example.add(DeckOfCards.getCardByValSuit("5", "♡"));
        Assert.assertTrue("Care 5",
                PokerChance.getComboEnum(example) == PokerComboEnum.CARE);
        example.clear();
        example.add(DeckOfCards.getCardByValSuit("4", "♤"));
        example.add(DeckOfCards.getCardByValSuit("K", "♤"));
        example.add(DeckOfCards.getCardByValSuit("4", "♧"));
        example.add(DeckOfCards.getCardByValSuit("4", "♢"));
        example.add(DeckOfCards.getCardByValSuit("4", "♡"));
        example.add(DeckOfCards.getCardByValSuit("J", "♧"));
        example.add(DeckOfCards.getCardByValSuit("J", "♡"));
        Assert.assertTrue("Care 4",
                PokerChance.getComboEnum(example) == PokerComboEnum.CARE);
        example.clear();
        example.add(DeckOfCards.getCardByValSuit("K", "♤"));
        example.add(DeckOfCards.getCardByValSuit("3", "♤"));
        example.add(DeckOfCards.getCardByValSuit("3", "♧"));
        example.add(DeckOfCards.getCardByValSuit("3", "♢"));
        example.add(DeckOfCards.getCardByValSuit("3", "♡"));
        example.add(DeckOfCards.getCardByValSuit("J", "♧"));
        example.add(DeckOfCards.getCardByValSuit("J", "♡"));
        Assert.assertTrue("Care 3",
                PokerChance.getComboEnum(example) == PokerComboEnum.CARE);
        example.clear();
        example.add(DeckOfCards.getCardByValSuit("2", "♤"));
        example.add(DeckOfCards.getCardByValSuit("K", "♤"));
        example.add(DeckOfCards.getCardByValSuit("2", "♧"));
        example.add(DeckOfCards.getCardByValSuit("2", "♢"));
        example.add(DeckOfCards.getCardByValSuit("2", "♡"));
        example.add(DeckOfCards.getCardByValSuit("J", "♧"));
        example.add(DeckOfCards.getCardByValSuit("J", "♡"));
        Assert.assertTrue("Care 2",
                PokerChance.getComboEnum(example) == PokerComboEnum.CARE);
//        example.clear();
//        example.add(DeckOfCards.getCardByValSuit("K", "♤"));
//        example.add(DeckOfCards.getCardByValSuit("7", "♤"));
//        example.add(DeckOfCards.getCardByValSuit("7", "♧"));
//        example.add(DeckOfCards.getCardByValSuit("7", "♢"));
//        example.add(DeckOfCards.getCardByValSuit("Q", "♡"));
//        example.add(DeckOfCards.getCardByValSuit("J", "♧"));
//        example.add(DeckOfCards.getCardByValSuit("J", "♡"));
//        Assert.assertTrue("Set",
//                PokerChance.getComboEnum(example) == PokerComboEnum.SET);
        System.out.println("2. Test Care - OK");
    }

    @Test
    public void testFullHouse(){
        ArrayList<Card> example = new ArrayList<>();
        example.add(DeckOfCards.getCardByValSuit("A", "♤"));
        example.add(DeckOfCards.getCardByValSuit("A", "♧"));
        example.add(DeckOfCards.getCardByValSuit("A", "♢"));
        example.add(DeckOfCards.getCardByValSuit("J", "♡"));
        example.add(DeckOfCards.getCardByValSuit("9", "♤"));
        example.add(DeckOfCards.getCardByValSuit("10", "♧"));
        example.add(DeckOfCards.getCardByValSuit("10", "♡"));
        Assert.assertTrue("Full House AAA 10 10",
                PokerChance.getComboEnum(example) == PokerComboEnum.FULLHOUSE);
        example.clear();
        example.add(DeckOfCards.getCardByValSuit("A", "♤"));
        example.add(DeckOfCards.getCardByValSuit("A", "♧"));
        example.add(DeckOfCards.getCardByValSuit("10", "♢"));
        example.add(DeckOfCards.getCardByValSuit("J", "♡"));
        example.add(DeckOfCards.getCardByValSuit("9", "♤"));
        example.add(DeckOfCards.getCardByValSuit("10", "♧"));
        example.add(DeckOfCards.getCardByValSuit("10", "♡"));
        Assert.assertTrue("Full House AA 10 10 10",
                PokerChance.getComboEnum(example) == PokerComboEnum.FULLHOUSE);

        System.out.println("3. Test Full House - OK");
    }
}
