package components;

import java.util.*;

import components.cards.Card;

public class Player {
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

	// Clear hand
	public void clearHand() {
		hand.clear();
	}

	// Size of hand
	public int handSize() {
		return hand.size();
	}
}
