public class Player {

    private String name;
    private CardPile hand;
    private int score;

    // The basics for a player, the name is provided from input and a new hand is created.
    public Player(String name) {
        this.name = name;
        this.hand = new CardPile(name);
    }

    // Getters and setters...
    public String getName() {
        return name;
    }

    public CardPile getHand() {
        return hand;
    }

    public int getScore(){ return score; }

    public void setscore(int newScore) { score = score + newScore; }

    public int getPoints() { return points(); }

    public void resetHand() { hand = null; }

    //Displays the cards on hand.
    public void display() {
        hand.display();
    }

    // A brute force CPU player, simply gets a card that matches the rules of Crazy 8's.
    // If none available on hand, draw from pile until a match is found.
    public Card play(Eights eights, Card prev) {
        Card ecard = new Card(0, 0);
        ecard = ecard.convert(searchForMatch(prev));

        if (ecard == null) {

            ecard = drawForMatch(eights, prev);
            return ecard;
        }
        return ecard;
    }

    // Search the current player hand for a matching card.
    public Card searchForMatch(Card prev) {
        for (int i = 0; i < hand.size(); i++) {
            Card card = hand.getCard(i);
            Card ecard = new Card(0,0);
            ecard = ecard.convert(card);
            if (ecard.cardMatches(prev)) {
                //return prev;
                return hand.popCard(i);
            }else{
                //return null;
            }
        }
        return null;
    }

    // Draw a card from the draw pile, if it does not match, keep drawing
    public Card drawForMatch(Eights eights, Card prev) {
        while (true) {
            Card card = eights.draw();
            System.out.println(getName() + " draws " + card);
            if (card.cardMatches(prev)) {
                return card;
            }
            hand.addCard(card);
        }
    }

    // Sums up the value of cards on player's hand to get the points for player
    public int points() {
        int sum = 0;
        for (int i = 0; i < hand.size(); i++) {
            Card card = hand.getCard(i);
            int rank = card.getRank();
            if (rank == 9) {
                sum += 50;
            } else if (rank == 0) {
                sum += 1;
            } else if (rank > 10) {
                sum += 10;
            } else {
                sum += rank;
            }
        }
        return sum;
    }

    // Show the number of points a player has along with their name
    public void showPoints() {
        System.out.println(getName() + " has " + points() + " points");
    }

}