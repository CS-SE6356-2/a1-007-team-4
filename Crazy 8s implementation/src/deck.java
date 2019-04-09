import java.util.*;

public class deck {
    //Create arraylist to hold a deck of cards
    List<card> cards = new ArrayList<card>();

    //Populate the arraylist with cards
    void createDeck(){
        for(int a =0; a<=3; a++)
        {
            for(int b =0; b<=12;b++)
            {
                cards.add(new card(a,b));
            }
        }
    }

    //Using builtin shuffle to shuffle the deck of cards
    void shuffleDeck(){
        Collections.shuffle(cards);
    }

    //Locate the top most card from deck
    void topCard(){

    }

    //Draw the top most card from deck
    card drawCard(){

    }
}
