package blackjack;

public final class Card {
    private final Suit suit;
    private final FaceValue value;

    public Card(Suit suit, FaceValue value) {
        this.suit = suit;
        this.value = value;
    }

    @Override
    public String toString() {
        return value + " OF " + suit;
    }

    public Suit getSuit() {
        return suit;
    }

    public FaceValue getValue() {
        return value;
    }
}
