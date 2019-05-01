package games.card;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class PokerChanceTestParameterized {

    private ArrayList<Card> example;
    private PokerComboEnum expectedCombo;

    public PokerChanceTestParameterized(ArrayList<Card> example, PokerComboEnum expectedCombo){
        this.example = example;
        this.expectedCombo = expectedCombo;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        ArrayList<Card> example1 = new ArrayList<>();
        example1.add(DeckOfCards.getCardByValSuit("A", "♤"));
        example1.add(DeckOfCards.getCardByValSuit("K", "♤"));
        example1.add(DeckOfCards.getCardByValSuit("Q", "♤"));
        example1.add(DeckOfCards.getCardByValSuit("J", "♤"));
        example1.add(DeckOfCards.getCardByValSuit("10", "♤"));
        example1.add(DeckOfCards.getCardByValSuit("10", "♧"));
        example1.add(DeckOfCards.getCardByValSuit("10", "♡"));

        Object[][] data = new Object[][]{
                {example1, PokerComboEnum.FLASHROYAL}
        };
        return Arrays.asList(data);
    }

    @Test
    public void checkCombination(){
        System.out.println(example.toString());
        System.out.println(PokerChance.getComboEnum(example));
        System.out.println(expectedCombo);
        Assert.assertTrue("MEssage", PokerChance.getComboEnum(example) == expectedCombo);
    }

}
