package gui.displayGame;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Stroke;

import util.TextFunctions;

public final class Frame {

	// Frame class for painting background/frame of game display

	// Not instantiable
	private Frame() {
	}

	// Background color (game)
	private static final Color bgcol = new Color(255, 200, 127);
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
	public static void paintBetweenTurns(Graphics2D g, String name, int wid, int hei) {
		// Fill background
		g.setColor(betcol);
		g.fillRect(0, 0, wid, hei);
		// Set font
		g.setFont(betfnt);
		// Draw name centered, with outline
		TextFunctions.drawCenteredTextOutline(g, name + "'s Turn", Color.WHITE, Color.BLACK, wid / 2, hei / 2, 1);
		// Draw "Click to Start", with outline
		TextFunctions.drawCenteredTextOutline(g, "Click to Start", Color.WHITE, Color.BLACK, wid / 2, hei * 3 / 5, 1);
	}

	// Get game separator position
	public static int getGameSeparator(int hei) {
		return (int) (0.6 * hei);
	}

	// Get card separator position
	public static int getCardSeparator(int hei) {
		return (int) (0.7 * hei);
	}
}
