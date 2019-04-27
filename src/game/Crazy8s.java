package game;

import java.util.ArrayList;

import components.Player;

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
	
	protected boolean playCard(Card c, player p) //determines whether a card can be played, then plays it if valid
	{
		if(c.getRank()=="8") //player plays an 8, gets to set suit
		{
			p.removeCard(c);
			discardPile.push(c);
			//TODO ask the player what the suit should be set to (don't use updateSuit here)
			return true;
		}
		else if(validCardSuit(c)) //card matches suit
		{
			p.removeCard(c);
			discardPile.push(c);
			return true;
		}
		else if(validCardRank(c))
		{
			p.removeCard(c);
			discardPile.push(c);
			updateSuit();
			return true;
		}
		else return false;
	}

	public static void main(String[] args) {
		// Ask for numbers of players (between 2 and 7)
		System.out.println("Enter number of players (Min=2 Max=7):");
		int playerCount = input.nextInt();
		for(int i=0; i<playerCount; i++) //get names frp players, create the player classes, add to player list
		{
			System.out.println("Player "+i);
			String name = playerName();
			System.out.println("Player "+i+" is "+name);
			players.add(new Player(name));
		}
		for(player p : players) //copy from player list to turn order
		{
			playerOrder.add(p);
		}
		dealCards();
		while(winner==null)//game is not over yet
		{
			Player current = getNextTurnPlayer();
			//TODO ask the player which card to play, call playCard, update points, check for winner
		}
	}
}
