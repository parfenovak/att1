package Hearts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * Created by Julia Connelly
 * June 2016
 *
 * A class that represents a regular deck of 52 cards
 */

public class Deck {

    // Order of ranks of cards
    static final ArrayList<String> hierarchy = new ArrayList<>(13);

    // Hearts.Deck of cards
    private static final Card[] deck = new Card[52];

    // List of the 4 suits (Clubs, Diamonds, Spades, Hearts)
    private static final ArrayList<String> suits = new ArrayList<>(4);

    Deck() {
        // Initializes hierarchy
        for (Integer i = 2; i < 11; i++) {
            hierarchy.add(i.toString());
        }
        hierarchy.add("A");
        hierarchy.add("J");
        hierarchy.add("Q");
        hierarchy.add("K");

        // Initializes suits
        suits.add("Clubs");
        suits.add("Diamonds");
        suits.add("Spades");
        suits.add("Hearts");

        // Initializes deck and shuffles the deck
        int count = 0;
        for (String suit : suits) {
            for (String level : hierarchy) {
                Card card = new Card(suit, level);
                deck[count] = card;
                count++;
            }
        }
        shuffle();
    }

    /**
     * Get method for the deck of cards
     * @return Hearts.Card[]
     */
    private Card[] getDeck() {
        return deck;
    }

    /**
     * Shuffles the deck
     */
    private void shuffle() {
        Random random = new Random();
        int rand;
        for (int i = 51; i > 0; i--) {
            rand = random.nextInt(i + 1);
            Card tmp = deck[rand];
            deck[rand] = deck[i];
            deck[i] = tmp;
        }
    }

    /**
     * Deals the deck into 4 Hands of 13 cards each
     * @return Hearts.Hand[]
     */
    Hand[] deal() {
        Hand[] hands = new Hand[4];
        hands[0] = new Hand(Arrays.copyOfRange(deck, 39, 52));
        hands[1] = new Hand(Arrays.copyOfRange(deck, 26, 39));
        hands[2] = new Hand(Arrays.copyOfRange(deck, 13, 26));
        hands[3] = new Hand(Arrays.copyOfRange(deck, 0, 13));
        return hands;
    }

    // Hearts.Main method for testing
    public static void main(String[] args) {
        Deck deck = new Deck();
        for (int i = 0; i < 52; i++) {
            System.out.println(deck.getDeck()[i]);
        }
        Hand[] hands = deck.deal();
        for (Hand hand : hands) {
            System.out.println(hand);
        }
    }
}
