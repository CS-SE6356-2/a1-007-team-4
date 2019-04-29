package gui.displayGame;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JComponent;

import components.cards.Card;
import game.Crazy8s;
import gui.GameStateManager;

public class GameDisplay extends JComponent {
	// JComponent serial ID
	private static final long serialVersionUID = 1L;

	// Manager
	private final GameStateManager manager;
	// Game tracking
	private final Crazy8s game;
	// Between turn name display (null for not between turns)
	private String betweenTurnString = null;

	private boolean gameIsOver = false;

	// Game and size constructor
	public GameDisplay(Crazy8s target, int x, int y, int w, int h, GameStateManager manager) {
		game = target;
		this.manager = manager;
		// Set target
		game.setRenderer(this);
		// Set JComponent dimensions
		setBounds(0, 0, w, h);
		setPreferredSize(new Dimension(w, h));
		// Save reference
		GameDisplay root = this;
		// Add mouse listener
		addMouseListener(new MouseListener() {
			@Override
			public void mousePressed(MouseEvent e) {
				// Call click at location
				root.mousePressed(e.getX(), e.getY());
			}

			// Unused
			@Override
			public void mouseClicked(MouseEvent e) {
			}

			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}
		});
	}

	// Set waiting player
	public void setWaitingPlayerName(String set) {
		// Set to text
		betweenTurnString = set + "'s Turn";
		// Repaint
		repaint();
	}

	// Set won
	public void setWinningScreen(String set) {
		// Game is over
		gameIsOver = true;
		betweenTurnString = set;
	}

	// Set scored
	public void setScoringScreen(String set) {
		// Set to text
		betweenTurnString = set;
		// Repaint
		repaint();

	}

	// Render board
	@Override
	public void paint(Graphics graphics) {
		// Cast to graphics2D
		Graphics2D g = (Graphics2D) graphics;

		// If between turns, wait until player is ready
		if (betweenTurnString != null) {
			Frame.paintBetweenTurns(g, betweenTurnString, getWidth(), getHeight(), gameIsOver);
			return;
		}
		// Draw frame
		Frame.paintFrame(g, getWidth(), getHeight());
		// Draw names
		Frame.paintNames(g, getWidth(), getHeight(), game.getPlayers(), game.getPlayers().indexOf(game.getActive()));

		// Draw discard
		Frame.drawDiscard(g, getWidth(), getHeight(), game.getDiscard(), manager);
		// Draw deck
		Frame.drawDeck(g, getWidth(), getHeight(), game.getDeck(), manager);
		// Draw hand
		Frame.drawHand(g, getWidth(), getHeight(), game.getActive(), manager);
	}

	// Clicked at location on screen
	private void mousePressed(int x, int y) {
		// If between turns, clear
		if (betweenTurnString != null) {
			// Can only click off if game is not over
			if (!gameIsOver) {
				betweenTurnString = null;
				// Re-render
				repaint();
			}
			return;
		}
		// Check if clicked on deck
		if (clickedDeck(x, y)) {
			// Done
			return;
		}
		// Check if clicked on hand
		if (clickedCard(x, y)) {
			// Done
			return;
		}

		// Print coordinates for fun
		System.out.println(x + " " + y);
	}

	// Check if clicked on deck
	private boolean clickedDeck(int x, int y) {
		int deckX = getWidth() / 2;
		int deckY = Frame.getDeckLoc(getHeight());
		// Check if out range
		if (Math.abs(x - deckX) > Card.pxWid / 2) {
			return false;
		}
		if (Math.abs(y - deckY) > Card.pxHei / 2) {
			return false;
		}

		// In range. Draw card
		game.getActive().addCard(game.drawCard());
		// Repaint
		repaint();
		// Clicked
		return true;
	}

	// Check if clicked on cards in hand
	private boolean clickedCard(int x, int y) {
		// Get active player's hand
		ArrayList<Card> cards = game.getActive().getHand();
		// Get positions
		int minWid = getWidth() / 12, maxWid = getWidth() * 11 / 12;
		int xdif = (maxWid - minWid) / cards.size();
		int handHei = Frame.getHandLoc(getHeight());
		// Check each card
		for (int i = cards.size() - 1; i >= 0; i--) {
			// Get ranges
			int cardX = minWid + xdif * i;
			// Check if out of range
			if (Math.abs(x - cardX) > Card.pxWid / 2) {
				continue;
			}
			if (Math.abs(y - handHei) > Card.pxHei / 2) {
				continue;
			}

			// Clicked on card in index i. Try to play
			if (game.playCard(cards.get(i), game.getActive())) {
				// Repaint
				repaint();
				// Clicked
				return true;
			}
		}

		// None found, return false
		return false;

	}
}
