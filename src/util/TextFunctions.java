package util;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics2D;

public abstract class TextFunctions {

	// Draw text left align
	public static void drawLAText(Graphics2D g, String text, float x, float y) {
		FontMetrics metrics = g.getFontMetrics();
		float tlx = x;
		float tly = y - metrics.getHeight() / 2 + metrics.getAscent();
		g.drawString(text, tlx, tly);
	}

	// Draw text centered
	public static void drawCenteredText(Graphics2D g, String text, float x, float y) {
		FontMetrics metrics = g.getFontMetrics();
		float tlx = x - metrics.stringWidth(text) / 2;
		float tly = y - metrics.getHeight() / 2 + metrics.getAscent();
		g.drawString(text, tlx, tly);
	}

	// Draw text with outline
	public static void drawTextOutline(Graphics2D g, String text, Color inside, Color outside, int x, int y,
			int thickness) {
		FontMetrics metrics = g.getFontMetrics();
		int tlx = x;
		int tly = y - metrics.getHeight() / 2 + metrics.getAscent();
		g.setColor(outside);
		for (int i = -thickness; i <= thickness; i++) {
			for (int j = -thickness; j <= thickness; j++) {
				g.drawString(text, tlx + i, tly + j);
			}
		}

		g.setColor(inside);
		g.drawString(text, tlx, tly);
	}

	// Draw text centered with outline
	public static void drawCenteredTextOutline(Graphics2D g, String text, Color inside, Color outside, int x, int y,
			int thickness) {
		FontMetrics metrics = g.getFontMetrics();
		int tlx = x - metrics.stringWidth(text) / 2;
		int tly = y - metrics.getHeight() / 2 + metrics.getAscent();
		g.setColor(outside);
		for (int i = -thickness; i <= thickness; i++) {
			for (int j = -thickness; j <= thickness; j++) {
				g.drawString(text, tlx + i, tly + j);
			}
		}

		g.setColor(inside);
		g.drawString(text, tlx, tly);
	}

}
