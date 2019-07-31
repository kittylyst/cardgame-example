package blackjack;

import org.junit.Test;

import static org.junit.Assert.*;

public class TestDeck {

    @Test
    public void givenDeck52CardsArePresent() {
        Deck.setup();
        assertEquals("Should be 52 cards in deck", 52, Deck.getCards().size());
    }

    @Test
    public void givenShuffledDeck52CardsArePresent() {
        Deck.setup();
        Deck.shuffle();
        assertEquals("Should be 52 cards in deck", 52, Deck.getCards().size());
    }
}
