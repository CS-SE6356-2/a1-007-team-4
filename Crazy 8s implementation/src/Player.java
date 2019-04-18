import java.util.*;

public class player {
    private String playerName;
    private int playerNumber;
    private int score;
    private List<card> cardsOnHand = new ArrayList<card>();
    
    public player(String name, int playerNum){
        playerName = name;
        playerNumber = playerNum;
        score = 0;
    }
    
    public int getScore(){
        return score;
    }
    
    public void setScore(int points){
        score = points;
    }
    
}
