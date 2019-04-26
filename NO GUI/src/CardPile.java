import java.util.ArrayList;
import java.util.Random;

public class CardPile {

    private String label;
    private ArrayList<Card> cards;

    // Basics to create a pile of cards
    public CardPile(String label) {
        this.label = label;
        this.cards = new ArrayList<Card>();
    }

    // Getters and setters...
    public String getLabel() {
        return label;
    }

    public Card getCard(int i) {
        return cards.get(i);
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    // Pops a card given the index of the card
    public Card popCard(int i) {
        return cards.remove(i);
    }

    // Pops the last card
    public Card popCard() {
        int i = size() - 1;
        return popCard(i);
    }

    // Provides the number of cards in pile.
    public int size() {
        return cards.size();
    }

    // Check if the pile is empty. If true, return true. Otherwise return false.
    public boolean empty() {
        return cards.size() == 0;
    }

    // Moves n number of cards to specified pile (labeled as "newPile")
    public void deal(CardPile newPile, int n) {
        for (int i = 0; i < n; i++) {
            Card card = popCard();
            newPile.addCard(card);
        }
    }

    // Moves all cards to specified pile.
    public void dealAll(CardPile newPile) {
        int n = size();
        deal(newPile, n);
    }


    // Get the information on the bottom most card of current pile.
    public Card last() {
        int i = size() - 1;
        return cards.get(i);
    }

    // Swaps two cards positions (used for shuffle)
    public void swapCards(int i, int j) {
        Card temp = cards.get(i);
        cards.set(i, cards.get(j));
        cards.set(j, temp);
    }

    // Shuffle the cards
    public void shuffle() {
        Random random = new Random();
        for (int i = size() - 1; i > 0; i--) {
            int j = random.nextInt(i);
            swapCards(i, j);
        }
    }

    // Prints out the cards in the current pile.
    public void display() {
        System.out.println(label + ": ");
        for (Card card: cards) {
            System.out.println(card);
        }
        System.out.println();
    }

}
