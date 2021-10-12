package Hearts;

/**
 * Created by Julia Connelly
 * June 2016
 *
 * A hash that provides an index from 0 to 51
 * Sorts by rank and suit (Clubs, Diamonds, Spades, Hearts)
 */

class Hasher {

    /**
     * Returns the index of the given Hearts.Card if the whole deck where sorted by suit and rank
     * @param toHash Hearts.Card
     * @return int
     */
    static int hash(Card toHash) {
        int index = 0;
        if (toHash.suit().equals("Diamonds")) {
            index = 12;
        }else if (toHash.suit().equals("Spades")) {
            index = 25;
        }else if (toHash.suit().equals("Hearts")) {
            index = 39;
        }
        return index + Deck.hierarchy.indexOf(toHash.rank());
    }
}
