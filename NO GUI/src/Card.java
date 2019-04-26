public class Card {

    public static final String[] RANKS = {
            null, "Ace", "2", "3", "4", "5", "6", "7",
            "8", "9", "10", "Jack", "Queen", "King"};
    public static final String[] SUITS = {
            "Clubs", "Diamonds", "Hearts", "Spades"};

    private final int rank;
    private final int suit;

    public Card(int rank, int suit) {
        this.rank = rank;
        this.suit = suit;
    }

    // Getters only, no setters needed as cards should be static.

    public int getRank() {
        return rank;
    }

    public int getSuit() {
        return suit;
    }

    public String toString() {
        return RANKS[rank] + " of " + SUITS[suit];
    }

    // Checks to see if the card provided has the same suit OR same rank OR is an 8. If none of these, return false.
    // A main rule for Crazy 8's
    public boolean cardMatches(Card that) {
        if (getSuit() == that.getSuit()) {
            return true;
        }
        if (getRank() == that.getRank()) {
            return true;
        }
        if (getRank() == 8) {
            return true;
        }
        return false;
    }

    // Converts the card to the proper format
    public Card convert(Card card) {
        if (card != null) {
            Card result = new Card(card.getRank(), card.getSuit());
            return result;
        }
        return null;
    }
}
