import java.util.*;

public class Player
{
    private String name;
    private int score;
    private ArrayList<Card> hand; 

    public Player(String name){
        this.name = name;
        hand = new ArrayList<Card>();
    }

    public String getName(){
        return name;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    private int getScore(){
        return score;
    }
    
    private void addPoints(int points){
        score += points;
    }
    
    public ArrayList<Card> getHand(){
        return hand;
    }
    
    public Card getCard(int index) {
        return hand.get(index);
    }
    
    public void addCard(Card card) {
        hand.add(card);
    }
    
    public Card removeCard(int index) {
        return hand.remove(index);
    }
    
    public int size(){
        return hand.size();
    }
    
    public boolean empty() {
        return hand.size() == 0;
    }
}
