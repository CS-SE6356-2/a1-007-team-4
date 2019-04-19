import java.util.*;

public abstract class CardGame
{
    private Deck deck;
    private ArrayList<Player> players;
	private Queue<Player> turnOrder;
    Scanner input = new Scanner(System.in);

    public CardGame(ArrayList<Player> players)
    {
        this.players = players;
        deck = new Deck();
        deck.shuffle();
    }
	
	abstract void deal();

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
	
	public Player nextPlayer()
	{
		Player current = turnOrder.remove();
		turnOrder.add(current);
		return current;
	}
}


