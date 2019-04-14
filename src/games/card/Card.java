package games.card;

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