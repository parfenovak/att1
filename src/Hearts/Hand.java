package Hearts;

import javafx.scene.layout.GridPane;

/**
 * Class that represents a sorted hand of 13 cards
 */

class Hand {

    // Hearts.Hand of 13 sorted cards
    private Card[] hand = new Card[13];
    GridPane[] cardPanes = new GridPane[13];

    /**
     * Creates a sorted hand of 13 cards
     * @param unsortedHand Hearts.Card[]
     */
    Hand(Card[] unsortedHand) {
        // Insertion sort
        Card key;
        int i;
        for (int j = 1; j < 13; j++) {
            key = unsortedHand[j];
            for (i = j - 1; i >= 0 && Hasher.hash(unsortedHand[i]) > Hasher.hash(key); i--) {
                unsortedHand[i + 1] = unsortedHand[i];
            }
            unsortedHand[i + 1] = key;
        }
        hand = unsortedHand;

        for (int k = 0; k < 13; k++) {
            cardPanes[k] = hand[k].pane();
        }
    }

    /**
     * Get method for hand
     * @return Hearts.Card[]
     */
    public Card[] getHandAsArray() {
        return hand;
    }

    public GridPane[] getHandAsPanes() {
        return cardPanes;
    }

    /**
     * Returns a string that represents the Hearts.Hand nicely formatted for printing
     * @return String
     */
    public String toString() {
        String str = "";
        for (int i = 0; i < 13; i++) {
            str += hand[i].toString() + "  ";
        }
        return str;
    }
}
