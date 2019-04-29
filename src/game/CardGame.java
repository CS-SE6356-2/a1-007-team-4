package game;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import components.Player;
import components.cards.Card;
import components.cards.Deck;
import gui.displayGame.GameDisplay;

public abstract class CardGame {

	// Deck used by game
	protected final Deck deck;
	// Discard pile used by game
	protected final Stack<Card> discardPile = new Stack<Card>();
	// Players present in game
	protected final ArrayList<Player> players;
	// Order of players
	private final Queue<Player> playerOrder;
	// Player who has won. Null until game is over
	protected Player winner = null;

	// Active player
	private Player active = null;

	// Renderer
	private GameDisplay render = null;

	// Initialization from player list
	public CardGame(ArrayList<Player> players) {
		// Set list
		this.players = players;
		// Make player order queue
		playerOrder = new LinkedList<Player>(players);
		// Make new deck
		deck = new Deck();
		// If over 5 players, double deck
		if (players.size() >= 5) {
			deck.addAll(new Deck());
		}
		// Deal starting hands
		dealCards();
		// Start game
		nextTurn();
	}

	// Draw card
	public Card drawCard() {
		// Check if deck is empty
		if (deck.size() == 0) {
			// Refresh from discard pile
			// Save top card
			Card top = discardPile.pop();
			// Clear out rest
			while (!discardPile.isEmpty()) {
				deck.addCard(discardPile.pop());
			}
			// Add top card to discard again
			discardPile.add(top);
		}
		// Draw from deck
		return deck.drawTopCard();
	}

	// Deal cards to each player
	protected abstract void dealCards();

	// Do next turn
	protected void nextTurn() {
		// Set active player
		active = getNextTurnPlayer();
		// Update display
		if (render != null) {
			render.setWaitingPlayerName(active.getName());
		}
	}

	// Get next active player
	private Player getNextTurnPlayer() {
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
		// Do next turn
		nextTurn();
	}

	// Get last card played
	public Card lastCardPlayed() {
		return discardPile.peek();
	}

	// Get players
	public ArrayList<Player> getPlayers() {
		return players;
	}

	// Get active player
	public Player getActive() {
		return active;
	}

	// Get discard
	public Stack<Card> getDiscard() {
		return discardPile;
	}

	// Get deck
	public Deck getDeck() {
		return deck;
	}

	// Set renderer
	public void setRenderer(GameDisplay disp) {
		render = disp;
	}

}
