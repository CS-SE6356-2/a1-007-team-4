package components.cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	// Create arraylist to hold a deck of cards
	private List<Card> deck = new ArrayList<Card>();

	// Constructor
	public Deck() {
		// Fill with cards
		generateFullDeck();
		// Shuffle
		shuffle();
	}

	// Populate the arraylist with cards
	private void generateFullDeck() {
		for (int a = 0; a < 4; a++) {
			for (int b = 0; b < 13; b++) {
				deck.add(new Card(a, b));
			}
		}
	}

	// Using builtin shuffle to shuffle the deck of cards
	public void shuffle() {
		Collections.shuffle(deck);
	}

	// Get size of deck
	public int size() {
		return deck.size();
	}

	// Draw the top most card from deck
	public Card drawTopCard() {
		// Check empty
		if (deck.size() == 0) {
			return null;
		}
		// Return top
		return deck.remove(0);
	}

	// Draw the bottom most card from deck
	public Card drawBottomCard() {
		// Check empty
		if (deck.size() == 0) {
			return null;
		}
		// Return top
		return deck.remove(deck.size() - 1);
	}

	// Format deck as string
	@Override
	public String toString() {
		// String to return. Start with open bracket
		String ret = "[";
		// Add each card to string
		for (int i = 0; i < deck.size(); i++) {
			// Add card
			ret += deck.get(i);
			// If following, add separator
			if (i < deck.size() - 1) {
				ret += ", ";
			}
		}
		// Add closing bracket
		ret += "]";
		// Return constructed string
		return ret;
	}
}
