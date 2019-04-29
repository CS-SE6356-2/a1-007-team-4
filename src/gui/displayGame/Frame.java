package gui.displayGame;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.util.ArrayList;
import java.util.Stack;

import components.Player;
import components.cards.Card;
import components.cards.Deck;
import gui.GameStateManager;
import util.TextFunctions;

public final class Frame {

	// Frame class for painting background/frame of game display

	// Not instantiable
	private Frame() {
	}

	// Background color (game)
	private static final Color bgcol = new Color(255, 200, 127);
	// Background color (players)
	private static final Color playercol = new Color(255, 200, 127);
	// Font (players)
	private static final Font playerfnt = new Font("TimesRoman", Font.PLAIN, 24);
	// Font (score)
	private static final Font scorefnt = new Font("TimesRoman", Font.PLAIN, 12);
	// Background color (between turns)
	private static final Color betcol = new Color(127, 127, 127);
	// Font (between turns)
	private static final Font betfnt = new Font("TimesRoman", Font.PLAIN, 48);
	// Separator color
	private static final Color sepcol = new Color(127, 50, 50);

	// Static frame paint method
	public static void paintFrame(Graphics2D g, int wid, int hei) {
		// Fill background
		g.setColor(bgcol);
		g.fillRect(0, 0, wid, hei);

		// Get separator positions
		final int gameHei = getGameSeparator(hei);
		final int cardHei = getCardSeparator(hei);
		// Change stroke and color
		Stroke old = g.getStroke();
		g.setStroke(new BasicStroke(5));
		g.setColor(sepcol);
		// Draw separators with stroke
		g.drawLine(0, gameHei, wid, gameHei);
		g.drawLine(0, cardHei, wid, cardHei);
		// Restore stroke
		g.setStroke(old);
	}

	// Static paint between turns method
	public static void paintBetweenTurns(Graphics2D g, String str, int wid, int hei, boolean drawSecondLine) {
		// Fill background
		g.setColor(betcol);
		g.fillRect(0, 0, wid, hei);
		// Set font
		g.setFont(betfnt);
		// Draw name centered, with outline
		TextFunctions.drawCenteredTextOutline(g, str, Color.WHITE, Color.BLACK, wid / 2, hei / 2, 1);
		if (drawSecondLine) {
			// Draw "Click to Start", with outline
			TextFunctions.drawCenteredTextOutline(g, "Click to Start", Color.WHITE, Color.BLACK, wid / 2, hei * 3 / 5,
					1);
		}
	}

	// Draw names
	public static void paintNames(Graphics2D g, int wid, int hei, ArrayList<Player> players, int index) {
		// Get top and bot heights
		final int topHei = getGameSeparator(hei), botHei = getCardSeparator(hei);

		// Draw each player's name and score
		for (int i = 0; i < players.size(); i++) {
			// Find minX and maxX
			int minX = wid * i / players.size();
			int maxX = wid * (i + 1) / players.size();
			// Fill background with player color (if active), or playercol (if not)
			if (i == index) {
				g.setColor(Player.DISP_COLS[i]);
			} else {
				g.setColor(playercol);

			}
			g.fillRect(minX, topHei, maxX - minX, botHei - topHei);
			// Draw stroke at points
			g.setColor(sepcol);
			Stroke old = g.getStroke();
			g.setStroke(new BasicStroke(3));
			g.drawLine(minX, topHei, minX, botHei);
			g.drawLine(maxX, topHei, maxX, botHei);
			// Restore stroke
			g.setStroke(old);
			// Draw name, centered
			g.setFont(playerfnt);
			TextFunctions.drawCenteredTextOutline(g, players.get(i).getName(), Color.WHITE, Color.BLACK,
					(maxX + minX) / 2, (topHei + botHei) / 2, 1);
			// Draw score, centered
			g.setFont(scorefnt);
			TextFunctions.drawCenteredTextOutline(g, Integer.toString(players.get(i).getScore()) + " Points",
					Color.WHITE, Color.BLACK, (maxX + minX) / 2, (topHei + botHei * 5) / 6, 1);

		}
	}

	// Draw discard pile
	public static void drawDiscard(Graphics2D g, int wid, int hei, Stack<Card> discards, GameStateManager man) {
		// Get center location
		int centerX = wid / 2;
		int centerY = getDiscardLoc(hei);
		// Draw cards behind
		for (int i = discards.size() / 4; i > 0; i--) {
			Card.drawCardBack(g, centerX + 2 * i, centerY + 2 * i, man);
		}
		// Draw front card
		discards.peek().drawCardFront(g, centerX, centerY, man);
	}

	// Draw deck
	public static void drawDeck(Graphics2D g, int wid, int hei, Deck deck, GameStateManager man) {
		// Get center location
		int centerX = wid / 2;
		int centerY = getDeckLoc(hei);
		// Draw deck
		deck.drawDeck(g, centerX, centerY, man);
	}

	// Draw hand
	public static void drawHand(Graphics2D g, int wid, int hei, Player active, GameStateManager man) {
		// Get cards
		ArrayList<Card> cards = active.getHand();
		// Get positions
		int minWid = wid / 12, maxWid = wid * 11 / 12;
		int xdif = (maxWid - minWid) / cards.size();
		int handHei = getHandLoc(hei);
		// Draw each card
		for (int i = cards.size() - 1; i >= 0; i--) {
			cards.get(i).drawCardFront(g, minWid + xdif * i, handHei, man);
		}
	}

	// Get discard pile position
	public static int getDiscardLoc(int hei) {
		return (int) (0.2 * hei);
	}

	// Get game separator position
	public static int getGameSeparator(int hei) {
		return (int) (0.45 * hei);
	}

	// Get card separator position
	public static int getCardSeparator(int hei) {
		return (int) (0.55 * hei);
	}

	// Get hand position
	public static int getHandLoc(int hei) {
		return (int) (0.7 * hei);
	}

	// Get deck position
	public static int getDeckLoc(int hei) {
		return (int) (0.9 * hei);
	}
}
