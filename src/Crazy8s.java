import java.util.*;

public class Crazy8s extends SheddingGame
{	
	private void deal() //give 5 cards to each player
	{
		for (int i=0; i < 5; i++){
            for(int j=0; j < players.size(); j++){
                players.get(j).addCard(deck.drawTopCard());
            }
        }
        
        discardPile.push(0, deck.drawTopCard());
	}
	
	private void twoPlayerDeal() //give 7 cards to each player
	{
		for (int i=0; i < 7; i++){
            for(int j=0; j < players.size(); j++){
                players.get(j).addCard(deck.drawTopCard());
            }
        }
        
        discardPile.push(0, deck.drawTopCard());
	}
	
	public Card lastCardPlayed() //shows the last card played
	{
		return discardPile.peek();
	}	


    //Calls the method to create player and gives the new player starting hand.
    public void startingHand(int playerCount) {
        Player player = new Player(playerName());
        createPlayer(player);
        //If playerCount == 2, give 7 cards to each player
		if(playerCount == 2)
			twoPlayerDeal();
		else
			deal();
        //Else, give 5 cards to each player

    }

    public static void main(String[] args){
        //Ask for numbers of players (between 2 and 7)

    }
}


