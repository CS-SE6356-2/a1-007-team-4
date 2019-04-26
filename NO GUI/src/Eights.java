import java.util.ArrayList;
import java.util.Scanner;


public class Eights {

    private CardPile drawPile;
    private CardPile discardPile;
    private Scanner in;
    private ArrayList<Player> players;


    //Basics needed to have a game of Crazy 8's, a deck of cards, a list of players, a discard pile, and a draw pile.
    public Eights() {
        Deck deck = new Deck("Deck");
        deck.shuffle();

        this.players = new ArrayList<Player>();

        // Top card is given to discard pile and is visible.
        discardPile = new CardPile("Discards");
        deck.deal(discardPile, 1);

        // Rest of cards go to draw pile.
        drawPile = new CardPile("Draw pile");
        deck.dealAll(drawPile);
    }

    // Add a player to the arraylist.
    public void createPlayer(Player player) {
        players.add(player);
    }

    // Gets the player name from console
    public String playerName() {
        System.out.println("Enter player name: ");
        String name = in.next();
        while (name == "") {
            name = in.nextLine();
        }
        return name;
    }

    // Give a player 5 cards to start a game.
    public void equipPlayer() {
        Player player = new Player(playerName());
        createPlayer(player);
        drawPile.deal(player.getHand(), 5);
    }

    // Get a player from the arraylist.
    public Player getPlayer(int i) {
        return players.get(i);
    }

    // Get the index number of a player from the arraylist
    public int getPlayerIndex(Player player) {
        return players.indexOf(player);
    }


    // Once a player runs out of cards, a round is over.
    public boolean noCards() {
        for (int x = 0; x < players.size(); x++) {
            if (getPlayer(x).getHand().empty()) {
                return true;
            }
        }
        return false;
    }

    //  Get the cards from the discard pile and combine with the draw pile. Once done, shuffle cards.
    public void reshuffle() {
        // save the top card
        Card convert = discardPile.popCard();
        Card prev = new Card(0, 0);
        prev = prev.convert(convert);

        // move the rest of the cards
        discardPile.dealAll(drawPile);

        // put the top card back
        discardPile.addCard(prev);

        // shuffle the draw pile
        drawPile.shuffle();
    }

    // Draws a card from the bottom of the draw pile.
    public Card draw() {
        if (drawPile.empty()) {
            reshuffle();
        }
        Card convert = drawPile.popCard();
        Card prev = new Card(0, 0);
        return prev.convert(convert);
    }

    // Goes to the next player.
    public Player nextPlayer(Player current) {

        if (getPlayerIndex(current) < players.size() - 1) {
            return getPlayer(getPlayerIndex(current) + 1);
        }
        if (getPlayerIndex(current) == players.size() - 1) {
            return getPlayer(getPlayerIndex(current) + 1 - players.size());
        }
        return null;

    }

    // Shows the cards each players have and how many are left in the draw pile
    public void displayState() {
        for (int x = 0; x < players.size(); x++) {
            getPlayer(x).display();
        }
        discardPile.display();
        System.out.print("Draw pile: ");
        System.out.println(drawPile.size() + " cards");
    }


    // Player plays a turn
    public void takeTurn(Player player) {
        Card convert = discardPile.last();
        Card prev = new Card(0, 0);
        prev = prev.convert(convert);
        Card next = player.play(this, prev);
        discardPile.addCard(next);

        System.out.println(player.getName() + " plays " + next);
        System.out.println();
    }

    // Plays the Crazy 8's. Ask for number of players and number of points needed to win, then asks for player names.
    // Once done, game is played.
    public void playGame() {

        in = new Scanner(System.in);
        System.out.println("Enter number of players: ");

        int nop = in.nextInt();
        while (nop > 5 || nop < 2) {
            System.err.println("Number of players must be between 2 and 5!");
            System.out.println();
            System.out.println("Re-enter number of players: ");
            nop = in.nextInt();
        }

        System.out.println("Enter number of points to win:");
        int points = in.nextInt();

        while (nop > 1000 || nop < 1) {
            System.err.println("At least 1 point and at most 1000");
            System.out.println();
            System.out.println("Re-enter number of points: ");
            points = in.nextInt();
        }

        for (int i = 0; i < nop; i++) {
            equipPlayer();
        }
        Player player = getPlayer(0);

        boolean notReached = false;
        int counter = 1;
        int[] scoring = new int[nop];
        //Play until score has reached.
        while (notReached == false) {
            while (!noCards()) {
                displayState();
                takeTurn(player);
                player = nextPlayer(player);
            }
            System.out.println("Round "  + counter + " complete!");

            int winner = -1, sum = 0;

            // Display score for each player in this round.
            for (int x = 0; x < players.size(); x++) {
                getPlayer(x).showPoints();
                sum = sum + getPlayer(x).getPoints();
                //If score is 0, this is the winner
                if(getPlayer(x).getPoints() == 0){
                    winner = x;
                }
            }

            // Get the total points fromm all players and award to winner of this round
            getPlayer(winner).setscore(sum);


            // Find out if any player has reached the score limit. Once reached, game is over
            for (int x = 0; x < players.size(); x++) {
                //We have a winner!
                if(getPlayer(x).getScore() >= points){
                    System.out.println("Winner is Player " + getPlayer(x).getName() + " !");
                    System.out.println("Score for winner is " + getPlayer(x).getScore());
                    getPlayer(x).resetHand();
                    notReached = true;
                }
            }

            counter++;

            Deck deck = new Deck("Deck");
            deck.shuffle();

            // turn one card face up
            discardPile = new CardPile("Discards");
            deck.deal(discardPile, 1);

            // put the rest of the deck face down
            drawPile = new CardPile("Draw pile");
            deck.dealAll(drawPile);

            drawPile.deal(player.getHand(), 5);
        }
    }

    //Plays the game
    public static void main(String[] args) {

        Eights game = new Eights();
        game.playGame();

    }
}
