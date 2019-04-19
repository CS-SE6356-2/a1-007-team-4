import java.util.*;

public class CardGame
{
    private Deck deck;
    private ArrayList<Card> discardPile;
    private ArrayList<Player> players;
    Scanner input = new Scanner(System.in);

    public CardGame(ArrayList<Player> players)
    {
        this.players = players;
        deck = new Deck();
        deck.shuffle();
    }
	
	public void deal()
	{
		for (int i=0; i < 5; i++){
            for(int j=0; j < players.size(); j++){
                players.get(j).addCard(deck.drawTopCard());
            }
        }
        
        discardPile.add(0, deck.drawTopCard());
	}
	
	public void twoPlayerDeal()
	{
		for (int i=0; i < 7; i++){
            for(int j=0; j < players.size(); j++){
                players.get(j).addCard(deck.drawTopCard());
            }
        }
        
        discardPile.add(0, deck.drawTopCard());
	}

    //Creates player
    public void createPlayer(Player player) {
        players.add(player);
    }

    //Enter the new player's name
    public String playerName() {
        System.out.println("Enter player name: ");
        String name = input.next();
        //If empty, wait until something is entered to be considered a name.
        while (name == "") {
            name = input.nextLine();
        }
        return name;
    }

    //Calls the method to create player and gives the new player starting hand.
    public void startingHand(int playerCount) {
        Player player = new Player(playerName());
        createPlayer(player);
        //If playerCount == 2, give 7 cards to each player
		if(playerCount == 2)
			twoPlayerDeal();
		else
			deal();
        //Else, give 5 cards to each player

    }

    public static void main(String[] args){
        //Ask for numbers of players (between 2 and 7)

    }
}


