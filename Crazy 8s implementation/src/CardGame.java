import java.util.*;

public class CardGame
{
    private Deck deck;
    private ArrayList<Card> discardPile;
    private ArrayList<Player> players;
    

    public CardGame(ArrayList<Player> players)
    {
        this.players = players;
        deck = new Deck();
        deck.shuffle();
        
        for (int i=0; i < 5; i++){
            for(int j=0; j < players.size(); j++){
                players.get(j).addCard(deck.drawTopCard());
            }
        }
        
        discardPile.add(0, deck.drawTopCard());
    }

    
   
}
