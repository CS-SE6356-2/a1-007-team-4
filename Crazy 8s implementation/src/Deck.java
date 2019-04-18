import java.util.*;

public class Deck {
    //Create arraylist to hold a deck of cards
    private List<Card> deck = new ArrayList<Card>();

    // Constructor
    public Deck(){
        // Fill with cards
        addCards();
    }
    //Populate the arraylist with cards
    private void addCards(){
        for(int a = 0; a< 4; a++)
        {
            for(int b = 0; b < 13;b++)
            {
                deck.add(new Card(a,b));
            }
        }
    }

    //Using builtin shuffle to shuffle the deck of cards
    public void shuffle(){
        Collections.shuffle(deck);
    }

    //Draw the top most card from deck
    public Card drawTopCard(){
        // Check empty
        if(deck.size() == 0){
            return null;
        }
        // Return top
        return deck.remove(0);
    }
    
    //Draw the bottom most card from deck
    public Card drawBottomCard(){
        // Check empty
        if(deck.size() == 0){
            return null;
        }
        // Return top
        return deck.remove(deck.size() - 1);
    }
    
    //Print all the cards in the deck
    public void print(){
        deck.forEach(card ->{
            System.out.println(card);
        
        });
    }
}
