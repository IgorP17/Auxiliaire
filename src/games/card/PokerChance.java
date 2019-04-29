package games.card;

import java.util.ArrayList;

import static games.card.Card.cardComparator;

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
        else return someCards.contains(DeckOfCards.getCardByValSuit("A", "♢"))
                    && someCards.contains(DeckOfCards.getCardByValSuit("K", "♢"))
                    && someCards.contains(DeckOfCards.getCardByValSuit("Q", "♢"))
                    && someCards.contains(DeckOfCards.getCardByValSuit("J", "♢"))
                    && someCards.contains(DeckOfCards.getCardByValSuit("10", "♢"));
    }

    /**
     * If we have Street Flash
     *
     * @param someCards - list of cards
     * @return - true if Street Flash, false otherwise
     */
    private static boolean isStreetFlash(ArrayList<Card> someCards) {
        return someCards.size() > 4 && isFlash(someCards) && isStreet(someCards);
    }

    /**
     * If we have Street
     *
     * @param someCards - list of cards
     * @return - true if Street
     */
    private static boolean isStreet(ArrayList<Card> someCards) {
        someCards.sort(cardComparator);
        // get unique card values
        StringBuilder cardValuesBuilder = new StringBuilder();
        for (Card c :
                someCards) {
            if (!cardValuesBuilder.toString().contains(c.getCardValue())) {
                cardValuesBuilder.append(c.getCardValue());
            }
        }
        String cardValues = cardValuesBuilder.toString();

        boolean result =
                cardValues.equalsIgnoreCase("AKQJ10") ||
                        cardValues.equalsIgnoreCase("KQJ109") ||
                        cardValues.equalsIgnoreCase("QJ1098") ||
                        cardValues.equalsIgnoreCase("J10987") ||
                        cardValues.equalsIgnoreCase("109876") ||
                        cardValues.equalsIgnoreCase("98765") ||
                        cardValues.equalsIgnoreCase("87654") ||
                        cardValues.equalsIgnoreCase("76543") ||
                        cardValues.equalsIgnoreCase("65432");
        System.out.println("Street will return - " + result);
        return result;
    }

    /**
     * If we have Flash
     * @param someCards - list of cards
     * @return - true if Flash
     */
    private static boolean isFlash(ArrayList<Card> someCards) {
        int countSpade = 0;
        int countClub = 0;
        int countHearts = 0;
        int countDiamond = 0;
        for (Card c :
                someCards) {
            switch (c.getSuit()) {
                case "♤":
                    countSpade++;
                    break;
                case "♧":
                    countClub++;
                    break;
                case "♡":
                    countHearts++;
                    break;
                case "♢":
                    countDiamond++;
                    break;
            }
        }
        boolean result = (countSpade > 4) || (countClub > 4) || (countHearts > 4) || (countDiamond > 4);
        System.out.println("FLash will return - " + result);
        return result;
    }
}
