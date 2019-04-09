public class card{

    int type, value;
    String[] suit = {"Spades", "Hearts", "Diamonds", "Clubs"};
    String[] rank = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9",
            "10", "Jack", "Queen", "King"};

    public card(int types, int values)
    {
        type = types;
        value = values;
    }

    public String toString()
    {
        String finalCard = rank[value] + " of " + suit[type];

        return finalCard;
    }

}