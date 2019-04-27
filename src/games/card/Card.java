package games.card;


import java.util.Comparator;
import java.util.Objects;

public class Card {

    private static int count = 0;
    private int idx;
    private String cardValue;
    private String suit;

    Card(String cardValue, String suit) {
        this.cardValue = cardValue;
        this.suit = suit;
        idx = count;
        count++;
    }

    public int getIdx() {
        return idx;
    }

    public String getCardValue() {
        return cardValue;
    }

    public String getSuit() {
        return suit;
    }

    /**
     * Compare cards based on idx - useful for sorting
     */
    static Comparator<Card> cardComparator = (o1, o2) -> {
        if (o1.getIdx() < o2.getIdx())
            return -1;
        else if (o1.getIdx() > o2.getIdx())
            return 1;
        return 0;
    };

    /**
     * Equals cards
     *
     * @param o - second card
     * @return - true if idx equals, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return (idx == card.idx)
                && (cardValue.equalsIgnoreCase(card.cardValue))
                && (suit.equalsIgnoreCase(card.suit));
    }

    @Override
    public int hashCode() {

        return Objects.hash(idx);
    }

    public static void main(String[] args) {
        Card c1 = new Card("A", "♤");
        Card c2 = new Card("A", "♧");
        Card c3 = new Card("A", "♡");
        Card c4 = new Card("A", "♢");
        System.out.println(c1.getIdx() + c1.getCardValue() + c1.getSuit());
        System.out.println(c2.getIdx() + c2.getCardValue() + c2.getSuit());
        System.out.println(c3.getIdx() + c3.getCardValue() + c3.getSuit());
        System.out.println(c4.getIdx() + c4.getCardValue() + c4.getSuit());

    }
}