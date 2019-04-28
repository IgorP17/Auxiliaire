package games.card;

import java.util.ArrayList;

public class PokerChance {

    public static void main(String[] args) {
        ArrayList<Card> deck = DeckOfCards.getShuffledDeck();
        for (Card c : deck) {
            System.out.println(c.getIdx() + "\t" + c.getCardValue() + c.getSuit());
        }
    }

    /**
     * Check high combination
     *
     * @param someCards - list of cards
     * @return - ENUM of high hand
     */
    public static PokerComboEnum getComboEnum(ArrayList<Card> someCards) {

        if (someCards == null) return null;

        // For FLASHROYAL we know combinations
        if (isFlashRoyal(someCards)) {
            return PokerComboEnum.FLASHROYAL;
        } else if (isStreetFlash(someCards)) {
            return PokerComboEnum.STREETFLASH;
        }

        return PokerComboEnum.HIGHCARD;
    }



    /**
     * For FLASHROYAL we know all combinations
     *
     * @param someCards - list of cards
     * @return - true if Flash Royal, false otherwise
     */
    private static boolean isFlashRoyal(ArrayList<Card> someCards) {

        if (someCards.contains(DeckOfCards.getCardByValSuit("A", "♤"))
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

    /**
     * If we have Street Flash
     *
     * @param someCards - list of cards
     * @return - true if Street Flash, false otherwise
     */
    private static boolean isStreetFlash(ArrayList<Card> someCards) {
        return true;
    }
}
