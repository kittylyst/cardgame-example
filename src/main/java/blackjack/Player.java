package blackjack;

import java.util.HashSet;
import java.util.Set;

public final class Player {
    private static final int THRESHOLD = 15;
    private final Set<Card> hand;
    private final String name;

    public Player(String s) {
        hand = new HashSet<>();
        name = s;
    }

    public void takeTurn() {
        int initialScore = calculateScore();
        while (initialScore < THRESHOLD) {
            Card newCard = Deck.deal();
            hand.add(newCard);
            initialScore = calculateScore();
        }
    }

    public int calculateScore() {
        int score = 0;
        for (Card c : hand) {
            score += c.getValue().getValue();
        }
        return score;
    }

    public void initialHand(Card c1, Card c2) {
        hand.add(c1);
        hand.add(c2);
    }

    @Override
    public String toString() {
        return "Player{" +
                "hand=" + hand +
                ", name='" + name + '\'' +
                '}';
    }
}
