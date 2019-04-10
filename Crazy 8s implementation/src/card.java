public class card{

    // Type and value of card
    private int type, value;
    // Suit and ranks
    private static final String[] suit = {"Spades", "Hearts", "Diamonds", "Clubs"};
    private static final String[] rank = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9",
            "10", "Jack", "Queen", "King"};

    // Construction initializer
    public card(int types, int values)
    {
        type = types;
        value = values;
    }

    // Express as rank and suit
    public String toString()
    {
        return rank[value] + " of " + suit[type];
    }

}