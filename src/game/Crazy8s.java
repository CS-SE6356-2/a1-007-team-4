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
	
	private String currentSuit;

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
		updateSuit();
	}
	
	protected void updateSuit()
	{
		currentSuit=lastCardPlayed().getSuit();
	}
	
	protected boolean validCardSuit(Card c)
	{
		return (c.getSuit()==currentSuit);
	}
	
	protected boolean validCardRank(Card c)
	{
		return (c.getRank()==lastCardPlayed().getRank());
	}
	
	protected boolean playCard(Card c, Player p) //determines whether a card can be played, then plays it if valid
	{
		if(c.getRank()=="8") //player plays an 8, gets to set suit
		{
			p.removeCard(c);
			playCard(c);
			//TODO ask the player what the suit should be set to (don't use updateSuit here)
			return true;
		}
		else if(validCardSuit(c)) //card matches suit
		{
			p.removeCard(c);
			playCard(c);
			return true;
		}
		else if(validCardRank(c)) //card matches rank
		{
			p.removeCard(c);
			playCard(c);
			updateSuit();
			return true;
		}
		else return false;
	}
}
