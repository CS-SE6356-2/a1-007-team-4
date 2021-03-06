package components;

import java.awt.Color;
import java.util.ArrayList;

import components.cards.Card;

public class Player {
	// Display colors
	public static final Color[] DISP_COLS = new Color[] { Color.RED, Color.BLUE, Color.YELLOW, Color.GREEN,
			Color.ORANGE, Color.CYAN, Color.MAGENTA, Color.PINK };
	// Max players
	public static final int MAX_PLAYERS = 8;

	// Player name
	private final String name;
	// Cards in player's hand
	private final ArrayList<Card> hand;
	// Current score o player
	private int score;

	public Player(String name) {
		this.name = name;
		hand = new ArrayList<Card>();
	}

	// Name getter
	public String getName() {
		return name;
	}

	// Score getter
	public int getScore() {
		return score;
	}

	// Add to score
	public void addPoints(int points) {
		score += points;
	}

	// Hand getter
	public ArrayList<Card> getHand() {
		return hand;
	}

	// Card getter
	public Card getCard(int index) {
		return hand.get(index);
	}

	// Add to hand
	public void addCard(Card card) {
		hand.add(card);
	}

	// Remove from hand
	public Card removeCard(int index) {
		return hand.remove(index);
	}

	// Remove from hand given card itself
	public void removeCard(Card c) {
		hand.remove(c);
	}

	// Clear hand
	public void clearHand() {
		hand.clear();
	}

	// Size of hand
	public int handSize() {
		return hand.size();
	}
}
