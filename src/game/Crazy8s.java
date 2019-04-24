package game;

import java.util.ArrayList;

import components.Player;

public class Crazy8s extends CardGame {

	// Initialize game from player names
	public Crazy8s(ArrayList<Player> players) {
		// Do CardGame initialization
		super(players);
	}

	// Gives 5 cards to each player
	protected void dealCards() {
		// Clear each player's hand
		for (int i = 0; i < players.size(); i++) {
			players.get(i).clearHand();
		}
		// Deal 5 cards (7 if 2 players)
		int cardAmt = 5;
		if (players.size() == 2) {
			cardAmt = 7;
		}
		for (int i = 0; i < cardAmt; i++) {
			for (int j = 0; j < players.size(); j++) {
				players.get(j).addCard(deck.drawTopCard());
			}
		}

		// Put one on the discard to start
		discardPile.push(deck.drawTopCard());
	}

	public static void main(String[] args) {
		// Ask for numbers of players (between 2 and 7)

	}
}
