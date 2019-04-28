package game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

import components.Player;
import components.cards.Card;
import components.cards.Deck;

public abstract class CardGame {

	// Deck used by game
	protected final Deck deck;
	// Discard pile used by game
	protected final Stack<Card> discardPile = new Stack<Card>();
	// Players present in game
	protected final ArrayList<Player> players;
	// Order of players
	private final Queue<Player> playerOrder;
	// Input. TODO remove this
	Scanner input = new Scanner(System.in);
	//Player who has won. Null until game is over
	protected Player winner = null;

	// Initialization from player list
	public CardGame(ArrayList<Player> players) {
		// Set list
		this.players = players;
		// Shuffle player order
		Collections.shuffle(players);
		// Make player order queue
		playerOrder = new LinkedList<Player>(players);
		// Make new deck
		deck = new Deck();
		// Deal starting hands
		dealCards();
	}
	

	// Deal cards to each player
	protected abstract void dealCards();

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

	// Get next active player
	public Player getNextTurnPlayer() {
		// Get next in queue
		Player current = playerOrder.remove();
		// Put in back of queue
		playerOrder.add(current);
		// Return player
		return current;
	}

	// Play card
	public void playCard(Card played) {
		// Add to discard stack
		discardPile.push(played);
	}

	// Get last card played
	public Card lastCardPlayed() {
		return discardPile.peek();
	}

}
