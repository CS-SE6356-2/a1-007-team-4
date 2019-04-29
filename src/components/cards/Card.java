package components.cards;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import gui.GameStateManager;

public class Card {

	// Type and value of card
	private int type, value;
	// Suit and ranks
	private static final String[] suit = { "Spades", "Hearts", "Diamonds", "Clubs" };
	private static final String[] rank = { "Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen",
			"King" };

	// Card width in px
	public static final int pxWid = 71;
	// Card height in px
	public static final int pxHei = 95;

	// Construction initializer
	public Card(int type, int value) {
		this.type = type;
		this.value = value;
	}

	// Get rank of card
	public String getRank() {
		return rank[value];
	}

	// Get suit of card
	public String getSuit() {
		return suit[type];
	}

	// Express as rank and suit
	public String toString() {
		return "(" + rank[value] + " of " + suit[type] + ")";
	}

	// Draw front of card
	public void drawCardFront(Graphics2D g, int cx, int cy, GameStateManager man) {
		// Get image
		BufferedImage front = man.getTextures().getImage("cards/" + rank[value] + suit[type] + ".png");
		// Draw centered on position
		g.drawImage(front, cx - front.getWidth() / 2, cy - front.getHeight() / 2, null);

	}

	// Draw back of card
	public static void drawCardBack(Graphics2D g, int cx, int cy, GameStateManager man) {
		// Get image
		BufferedImage back = man.getTextures().getImage("cards/back.png");
		// Draw centered on position
		g.drawImage(back, cx - back.getWidth() / 2, cy - back.getHeight() / 2, null);

	}

}
