package game;
import java.util.*;

import Player;
import cards.Deck;

public abstract class CardGame {
	protected Deck deck;
	protected ArrayList<Player> players;
	protected Queue<Player> turnOrder;
	Scanner input = new Scanner(System.in);

	public CardGame(ArrayList<Player> players) {
		this.players = players;
		for (Player p : players) {
			turnOrder.add(p);
		}
		deck = new Deck();
		deck.shuffle();
	}

	public CardGame() {
		deck = new Deck();
		deck.shuffle();
	}

	abstract void deal();

	// Creates player
	public void createPlayer(Player player) {
		players.add(player);
		turnOrder.add(player);
	}

	// Enter the new player's name
	public String playerName() {
		System.out.println("Enter player name: ");
		String name = input.next();
		// If empty, wait until something is entered to be considered a name.
		while (name == "") {
			name = input.nextLine();
		}
		return name;
	}

	public Player nextPlayer() // gets next player and puts them at the back of the turn list
	{
		Player current = turnOrder.remove();
		turnOrder.add(current);
		return current;
	}
}
