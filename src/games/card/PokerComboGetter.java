package games.card;

import java.util.ArrayList;

public class PokerComboGetter {
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
        } else if (isFullHouse(someCards)) {
            return PokerComboEnum.FULLHOUSE;
        } else if (isFlash(someCards)) {
            return PokerComboEnum.FLASH;
        } else if (isStreet(someCards)) {
            return PokerComboEnum.STREET;
        } else if (isSet(someCards)) {
            return PokerComboEnum.SET;
        } else if (isPairs(someCards)) {
            return PokerComboEnum.PAIRS;
        } else if (isPair(someCards)) {
            return PokerComboEnum.PAIR;
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

        return
                (someCards.contains(DeckOfCards.getCardByValSuit("A", "♠")) &&
                        someCards.contains(DeckOfCards.getCardByValSuit("K", "♠")) &&
                        someCards.contains(DeckOfCards.getCardByValSuit("Q", "♠")) &&
                        someCards.contains(DeckOfCards.getCardByValSuit("J", "♠")) &&
                        someCards.contains(DeckOfCards.getCardByValSuit("10", "♠")))
                        ||
                        (someCards.contains(DeckOfCards.getCardByValSuit("A", "♣")) &&
                                someCards.contains(DeckOfCards.getCardByValSuit("K", "♣")) &&
                                someCards.contains(DeckOfCards.getCardByValSuit("Q", "♣")) &&
                                someCards.contains(DeckOfCards.getCardByValSuit("J", "♣")) &&
                                someCards.contains(DeckOfCards.getCardByValSuit("10", "♣")))
                        ||
                        (someCards.contains(DeckOfCards.getCardByValSuit("A", "♥")) &&
                                someCards.contains(DeckOfCards.getCardByValSuit("K", "♥")) &&
                                someCards.contains(DeckOfCards.getCardByValSuit("Q", "♥")) &&
                                someCards.contains(DeckOfCards.getCardByValSuit("J", "♥")) &&
                                someCards.contains(DeckOfCards.getCardByValSuit("10", "♥")))
                        ||
                        (someCards.contains(DeckOfCards.getCardByValSuit("A", "♦")) &&
                                someCards.contains(DeckOfCards.getCardByValSuit("K", "♦")) &&
                                someCards.contains(DeckOfCards.getCardByValSuit("Q", "♦")) &&
                                someCards.contains(DeckOfCards.getCardByValSuit("J", "♦")) &&
                                someCards.contains(DeckOfCards.getCardByValSuit("10", "♦")));
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
        someCards.sort(Card.cardComparator);
        String[] s = new String[someCards.size()];
        for (int i = 0; i < someCards.size(); i++) {
            s[i] = someCards.get(i).getCardValue();
//            System.out.print(s[i]);
        }
//        System.out.println();
        for (int i = 0; i < s.length - 3; i++) {
//            System.out.println(s[i] + s[i + 1] + s[i + 2] + s[i + 3]);
            if (s[i].equalsIgnoreCase(s[i + 1]) &&
                    s[i + 1].equalsIgnoreCase(s[i + 2]) &&
                    s[i + 2].equalsIgnoreCase(s[i + 3])) {
                return true;
            }
        }
        return false;
    }

    /**
     * If we have Full House
     *
     * @param someCards - list of cards
     * @return - true if Full House
     */
    private static boolean isFullHouse(ArrayList<Card> someCards) {
        // Main idea - find set, remember set value, find pair
        someCards.sort(Card.cardComparator);
        String[] s = new String[someCards.size()];
        for (int i = 0; i < someCards.size(); i++) {
            s[i] = someCards.get(i).getCardValue();
        }
        String setValue;
        // find set
        for (int i = 0; i < s.length - 2; i++) {
            if (s[i].equalsIgnoreCase(s[i + 1]) &&
                    s[i + 1].equalsIgnoreCase(s[i + 2])) {
                // we found set
                setValue = s[i];
                // search pair
                for (int j = 0; j < s.length - 1; j++) {
                    if (s[j].equalsIgnoreCase(s[j + 1]) &&
                            !s[j].equalsIgnoreCase(setValue)) {
                        //we found pair
                        return true;
                    }
                }
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
        someCards.sort(Card.cardComparator);
        // get unique card values
        StringBuilder cardValuesBuilder = new StringBuilder();
        for (Card c :
                someCards) {
            if (!cardValuesBuilder.toString().contains(c.getCardValue())) {
                cardValuesBuilder.append(c.getCardValue());
            }
        }
        String cardValues = cardValuesBuilder.toString();

        return cardValues.contains("AKQJ10") ||
                cardValues.contains("KQJ109") ||
                cardValues.contains("QJ1098") ||
                cardValues.contains("J10987") ||
                cardValues.contains("109876") ||
                cardValues.contains("98765") ||
                cardValues.contains("87654") ||
                cardValues.contains("76543") ||
                cardValues.contains("65432");
    }

    /**
     * If we have Flash
     *
     * @param someCards - list of cards
     * @return - true if Flash
     */
    private static boolean isFlash(ArrayList<Card> someCards) {
        if (someCards.size() < 4) return false;
        int countSpade = 0;
        int countClub = 0;
        int countHearts = 0;
        int countDiamond = 0;
        for (Card c :
                someCards) {
            switch (c.getSuit()) {
                case "♠":
                    countSpade++;
                    break;
                case "♣":
                    countClub++;
                    break;
                case "♥":
                    countHearts++;
                    break;
                case "♦":
                    countDiamond++;
                    break;
            }
        }
        return (countSpade > 4) || (countClub > 4) || (countHearts > 4) || (countDiamond > 4);
    }

    /**
     * Check if we have set
     *
     * @param someCards - list of cards
     * @return - tre if set found
     */
    private static boolean isSet(ArrayList<Card> someCards) {
        someCards.sort(Card.cardComparator);
        String[] s = new String[someCards.size()];
        for (int i = 0; i < someCards.size(); i++) {
            s[i] = someCards.get(i).getCardValue();
//            System.out.print(s[i]);
        }
        for (int i = 0; i < s.length - 2; i++) {
            if (s[i].equalsIgnoreCase(s[i + 1]) &&
                    s[i + 1].equalsIgnoreCase(s[i + 2])) {
//                System.out.println(" - " + s[i] + s[i + 1] + s[i + 2]);
                return true;
            }
        }
//        System.out.println();
        return false;
    }

    /**
     * Check if we have 2 pairs
     *
     * @param someCards - list of cards
     * @return - true is 2 pairs found
     */
    private static boolean isPairs(ArrayList<Card> someCards) {
        someCards.sort(Card.cardComparator);
        String[] s = new String[someCards.size()];
        for (int i = 0; i < someCards.size(); i++) {
            s[i] = someCards.get(i).getCardValue();
        }
        String firstPairValue;
        for (int i = 0; i < s.length - 1; i++) {
            if (s[i].equalsIgnoreCase(s[i + 1])) {
                // found first pair
                firstPairValue = s[i];
                // second pair is not the same as first pair
                for (int j = 0; j < s.length - 1; j++) {
                    if (s[j].equalsIgnoreCase(s[j + 1]) &&
                            !s[j].equalsIgnoreCase(firstPairValue)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * Check if we have pair
     *
     * @param someCards - list of cards
     * @return - true if we have pair
     */
    private static boolean isPair(ArrayList<Card> someCards) {
        someCards.sort(Card.cardComparator);
        String[] s = new String[someCards.size()];
        for (int i = 0; i < someCards.size(); i++) {
            s[i] = someCards.get(i).getCardValue();
        }
        for (int i = 0; i < s.length - 1; i++) {
            if (s[i].equalsIgnoreCase(s[i + 1])) {
                return true;
            }
        }
        return false;
    }
}