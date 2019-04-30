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
        } else if (isCare(someCards)) {
            return PokerComboEnum.CARE;
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
     * If we have Care
     *
     * @param someCards - list of cards
     * @return - true if Care
     */
    private static boolean isCare(ArrayList<Card> someCards) {
        // we should have at least 4 cards
        if (someCards.size() < 4) return false;
        // sort and get fours
        someCards.sort(cardComparator);
        StringBuilder sbVal = new StringBuilder();
        for (Card c :
                someCards) {
            sbVal.append(c.getCardValue());
        }
        String values = sbVal.toString();
        String s1, s2, s3, s4;
        System.out.println("DEBUG Care values " + values);
        for (int i = 0; i < values.length() - 4; i++) {
            s1 = values.substring(i, i + 1);
            s2 = values.substring(i + 1, i + 2);
            s3 = values.substring(i + 2, i + 3);
            s4 = values.substring(i + 3, i + 4);
            if (s1.equalsIgnoreCase(s2) &&
                    s2.equalsIgnoreCase(s3) &&
                    s3.equalsIgnoreCase(s4)) {
                return true;
            }
        }
        return false;
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
        System.out.println("DEBUG is street" + cardValues);

        boolean result =
                cardValues.contains("AKQJ10") ||
                        cardValues.contains("KQJ109") ||
                        cardValues.contains("QJ1098") ||
                        cardValues.contains("J10987") ||
                        cardValues.contains("109876") ||
                        cardValues.contains("98765") ||
                        cardValues.contains("87654") ||
                        cardValues.contains("76543") ||
                        cardValues.contains("65432");
        System.out.println("DEBUG Street will return - " + result);
        return result;
    }

    /**
     * If we have Flash
     *
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
        System.out.println("DEBUG Flash will return - " + result);
        return result;
    }
}
