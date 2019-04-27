package games.card;

import java.util.ArrayList;
import java.util.Collection;

public class PokerChance {

    public static void main(String[] args) {

        ArrayList<Card> deck = DeckOfCards.getShuffledDeck();
        for (Card c : deck) {
            System.out.println(c.getIdx() + "\t" + c.getCardValue() + c.getSuit());
        }


    }

    /**
     * Check high combination
     * @param someCards - list of cards
     * @return - ENUM of high hand
     */
    public static PokerComboEnum getComboEnum(ArrayList<Card> someCards){

        // For FLASHROYAL we know ids of cards
        if (isFlashRoyal(someCards)){
            return PokerComboEnum.FLASHROYAL;
        }

        return PokerComboEnum.HIGHCARD;
    }

    /**
     * For FLASHROYAL we know ids of cards
     * @param someCards - list of cards
     * @return - true if Flash Royal, false otherwise
     */
    private static boolean isFlashRoyal(ArrayList<Card> someCards){
        if (someCards == null)
            return false;
        else if (someCards.contains(DeckOfCards.getCardByValSuit("A", "♤"))
                && someCards.contains(DeckOfCards.getCardByValSuit("K", "♤"))
                && someCards.contains(DeckOfCards.getCardByValSuit("Q", "♤"))
                && someCards.contains(DeckOfCards.getCardByValSuit("J", "♤"))
                && someCards.contains(DeckOfCards.getCardByValSuit("10", "♤")))
            return true;
        else if (someCards.contains(DeckOfCards.getCardByValSuit("A", "♧"))
                && someCards.contains(DeckOfCards.getCardByValSuit("K", "♧"))
                && someCards.contains(DeckOfCards.getCardByValSuit("Q", "♧"))
                && someCards.contains(DeckOfCards.getCardByValSuit("J", "♧"))
                && someCards.contains(DeckOfCards.getCardByValSuit("10", "♧")))
            return true;
        else if (someCards.contains(DeckOfCards.getCardByValSuit("A", "♡"))
                && someCards.contains(DeckOfCards.getCardByValSuit("K", "♡"))
                && someCards.contains(DeckOfCards.getCardByValSuit("Q", "♡"))
                && someCards.contains(DeckOfCards.getCardByValSuit("J", "♡"))
                && someCards.contains(DeckOfCards.getCardByValSuit("10", "♡")))
            return true;
        else if (someCards.contains(DeckOfCards.getCardByValSuit("A", "♢"))
                && someCards.contains(DeckOfCards.getCardByValSuit("K", "♢"))
                && someCards.contains(DeckOfCards.getCardByValSuit("Q", "♢"))
                && someCards.contains(DeckOfCards.getCardByValSuit("J", "♢"))
                && someCards.contains(DeckOfCards.getCardByValSuit("10", "♢")))
            return true;
        else return false;
    }

}
