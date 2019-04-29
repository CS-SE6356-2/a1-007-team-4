package game;

import java.util.ArrayList;

import components.Player;
import components.cards.Card;

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
				players.get(j).addCard(drawCard());
			}
		}

		// Put one on the discard to start
		discardPile.push(drawCard());
	}

	// Check valid suit or rank
	protected boolean validCardSuit(Card c) {
		return (c.getSuit() == lastCardPlayed().getSuit());
	}

	protected boolean validCardRank(Card c) {
		return (c.getRank() == lastCardPlayed().getRank());
	}

	// Play card by player
	public boolean playCard(Card c, Player p) // determines whether a card can be played, then plays it if valid
	{
		if (c.getRank() == "8") // player plays an 8, gets to set suit
		{
			p.removeCard(c);
			playCardToDiscard(c, p);
			// TODO ask the player what the suit should be set to
			return true;
		} else if (validCardSuit(c)) // card matches suit
		{
			p.removeCard(c);
			playCardToDiscard(c, p);
			return true;
		} else if (validCardRank(c)) // card matches rank
		{
			p.removeCard(c);
			playCardToDiscard(c, p);
			return true;
		} else
			return false;
	}
}
