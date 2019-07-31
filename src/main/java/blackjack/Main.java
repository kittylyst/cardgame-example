package blackjack;

import java.util.ArrayList;
import java.util.List;

public final class Main {

    private static final int BUST_SCORE = 22;
    private final List<Player> players;

    public Main(int numPlayers) {
        players = new ArrayList<>(numPlayers);
        for (int i=0; i < numPlayers; i = i + 1) {
            players.add(new Player("Player "+ i));
        }
    }

    public static void main(String[] args) {
        Main m = new Main(4);
        Deck.setup();
        Deck.shuffle();
        m.dealHand();
        m.round();
        m.findWinner();
    }

    void findWinner() {
        int winningScore = 0;
        Player winner = null;
        for (Player p : players) {
            int playerScore = p.calculateScore();
            if (playerScore > winningScore && playerScore < BUST_SCORE) {
                winner = p;
                winningScore = playerScore;
            }
        }
        if (winner == null) {
            System.out.println("Nobody won!");
        } else {
            System.out.println(winner +" won with a score of "+ winningScore);
        }
    }

    private void dealHand() {
        for (Player p : players) {
            Card c1 = Deck.deal();
            Card c2 = Deck.deal();
            p.initialHand(c1, c2);
        }
    }

    void round() {
        for (Player p : players) {
            p.takeTurn();
        }
    }
}
