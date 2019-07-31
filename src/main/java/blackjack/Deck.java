package blackjack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class Deck {
    private static List<Card> cards;
    private static Iterator<Card> dealer;

    public static void setup() {
        cards = new ArrayList<>();
        for (Suit s : Suit.values()) {
            for (FaceValue fv : FaceValue.values()) {
                final Card c = new Card(s, fv);
                cards.add(c);
            }
        }
        dealer = cards.iterator();
    }

    public static void shuffle() {
        Collections.shuffle(cards);
    }

    public static List<Card> getCards() {
        return cards;
    }

    public static Card deal() {
        if (dealer.hasNext()) {
            return dealer.next();
        } else {
            throw new IllegalStateException("Out of cards");
        }
    }
}
