package games.card;

import java.util.ArrayList;
import java.util.Collection;

public class PokerChance {

    public static void main(String[] args) {

        ArrayList<Card> deck = DeckOfCards.getInstance().getShuffledDeck();
        for (Card c : deck) {
            System.out.println(c.getIdx() + "\t" + c.getCardValue() + c.getSuit());
        }


    }

}
