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

	// Winning point values
	private static final int winningPoints = 100;

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

	// Allocate points to player. Returns if player wins
	protected boolean allocatePoints(Player p) {
		// Get point total from each
		int pointTotal = 0;
		// Add points of remaining cards to each
		for (Player player : players) {
			// Loop through hand and add card values
			for (Card c : player.getHand()) {
				pointTotal += c.getPoints();
			}
		}
		// Add points to player
		p.addPoints(pointTotal);

		// If above value, wins
		if (p.getScore() >= winningPoints) {
			// Set display
			if (render != null) {
				render.setWinningScreen(p.getName() + " Wins!");
			}
			return true;
		}

		// Set scoring screen
		if (render != null) {
			render.setScoringScreen(p.getName() + " Scored " + pointTotal + " points.");
		}
		// Return game still running
		return false;
	}

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

	// Play card to pile
	protected void playCardToDiscard(Card played, Player player) {
		// Add to discard stack
		discardPile.push(played);
		// Check if hand empty
		if (player.handSize() == 0) {
			// Allocate points to winner
			if (allocatePoints(player)) {
				// Player wins!
				// Handled internally
				return;
			}
			// Deal again, and refresh
			dealCards();
		} else {
			// Do next turn
			nextTurn();
		}
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
