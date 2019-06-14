package games.card;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

@RunWith(Parameterized.class)
public class PokerComboGetterTestParameterized {

    private String comment;
    private ArrayList<Card> firstHand;
    private ArrayList<Card> secondHand;
    private ArrayList<Card> deal;
    private int winHand;

    public PokerComboGetterTestParameterized(String comment,
                                             ArrayList<Card> firstHand,
                                             ArrayList<Card> secondHand,
                                             ArrayList<Card> deal,
                                             int winHand) {
        this.comment = comment;
        this.firstHand = firstHand;
        this.secondHand = secondHand;
        this.deal = deal;
        this.winHand = winHand;
    }

    // @Parameters( name = "{index}: fib({0})={1}" )
    // testFib[1: fib(1)=1], testFib[4: fib(4)=3]
    @Parameterized.Parameters(name = "{index}: {0}")
    public static Collection<Object[]> data() {
//        ArrayList<Card> example1 = new ArrayList<>();
//        example1.add(DeckOfCards.getCardByValSuit("A", "♠"));
//        example1.add(DeckOfCards.getCardByValSuit("K", "♠"));
//        example1.add(DeckOfCards.getCardByValSuit("Q", "♠"));
//        example1.add(DeckOfCards.getCardByValSuit("J", "♠"));
//        example1.add(DeckOfCards.getCardByValSuit("10", "♠"));
//        example1.add(DeckOfCards.getCardByValSuit("10", "♣"));
//        example1.add(DeckOfCards.getCardByValSuit("10", "♥"));

//        Object[][] data = new Object[][]{
//                {"Test Flash Royal ♠", example1, PokerComboEnum.FLASHROYAL},
//                {"Test Flash Royal ♠", example1, PokerComboEnum.FLASHROYAL}
//        };

//        return Arrays.asList(data);
        return readTests();
    }

    @Test
    public void checkCombination() {
        System.out.println(comment);
        for (Card c :
                firstHand) {
            System.out.print(c.getCardValue() + c.getSuit());
        }
        System.out.print(" ");
        for (Card c :
                secondHand) {
            System.out.print(c.getCardValue() + c.getSuit());
        }
        System.out.print(" ");
        for (Card c :
                deal) {
            System.out.print(c.getCardValue() + c.getSuit());
        }
        System.out.println();
        System.out.println("Expecting - " + winHand);
        int result = PokerComboGetter.getHighCombo(firstHand, secondHand, deal);
        System.out.println("Actual - " + result);
        Assert.assertTrue("If expecting equals actual", winHand == result);
    }

    /**
     * Reading tests
     *
     * @return - object of tests
     */
    private static ArrayList<Object[]> readTests() {
        String comment;
        ArrayList<Card> firstHand, secondHand, deal;
        int winHand;
        String[] splittedString;
        ArrayList<Object[]> result = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("test/games/card/TwoHands.txt"))) {
//            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
//                System.out.println("Read line:" + line);
                line = line.trim();
                if (!line.equalsIgnoreCase("") &&
                        !line.startsWith("#") &&
                        line.split(";").length == 5) {
//                sb.append(line);
//                sb.append(System.lineSeparator());
//                System.out.println(line);
                    splittedString = line.split(";");
                    comment = splittedString[0];
                    firstHand = getArrayListOfCards(splittedString[1]);
                    secondHand = getArrayListOfCards(splittedString[2]);
                    deal = getArrayListOfCards(splittedString[3]);
                    winHand = Integer.parseInt(splittedString[4]);
                    result.add(new Object[]{comment, firstHand, secondHand, deal, winHand});
                }
                line = br.readLine();
            }
//            String everything = sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * Create ArrayList of Cards from String
     *
     * @param s - smth like A♠,K♠,Q♠,J♠,10♠,10♣,10♥
     * @return - ArrayList of Cards
     */
    private static ArrayList<Card> getArrayListOfCards(String s) {
        String[] cards = s.split(",");
        ArrayList<Card> result = new ArrayList<>();
        for (String card : cards) {
            result.add(DeckOfCards.getCardByValSuit(
                    card.substring(0, card.length() - 1),
                    card.substring(card.length() - 1)));
        }
        return result;
    }
}
