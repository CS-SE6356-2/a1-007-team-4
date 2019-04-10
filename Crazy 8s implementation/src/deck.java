import java.util.*;

public class deck {
    //Create arraylist to hold a deck of cards
    private List<card> cards = new ArrayList<card>();

    // Initialization constructor
    public deck(){
        // Fill with cards
        addCards();
    }
    //Populate the arraylist with cards
    private void addCards(){
        for(int a = 0; a< 4; a++)
        {
            for(int b = 0; b < 13;b++)
            {
                cards.add(new card(a,b));
            }
        }
    }

    //Using builtin shuffle to shuffle the deck of cards
    public void shuffleDeck(){
        Collections.shuffle(cards);
    }

    //Draw the top most card from deck
    public card pullTopCard(){
        // Check empty
        if(cards.size() == 0){
            return null;
        }
        // Return top
        return cards.remove(0);
    }
    
    //Draw the bottom most card from deck
    public card pullBottomCard(){
        // Check empty
        if(cards.size() == 0){
            return null;
        }
        // Return top
        return cards.remove(cards.size() - 1);
    }

}
