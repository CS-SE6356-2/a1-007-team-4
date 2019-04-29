package gui.displayGame;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JComponent;

import game.Crazy8s;

public class GameDisplay extends JComponent {
	// JComponent serial ID
	private static final long serialVersionUID = 1L;

	// Game tracking
	private final Crazy8s game;
	// Between turn name display (null for not between turns)
	private String betweenTurnName = "TEST";

	// Game and size constructor
	public GameDisplay(Crazy8s target, int x, int y, int w, int h) {
		game = target;
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

	@Override
	public void paint(Graphics graphics) {
		// Cast to graphics2D
		Graphics2D g = (Graphics2D) graphics;

		// If between turns, wait until player is ready
		if (betweenTurnName != null) {
			Frame.paintBetweenTurns(g, betweenTurnName, getWidth(), getHeight());
			return;
		}
		// Draw frame
		Frame.paintFrame(g, getWidth(), getHeight());
	}

	// Clicked at location on screen
	private void mousePressed(int x, int y) {
		// If between turns, clear
		if (betweenTurnName != null) {
			betweenTurnName = null;
			// Re-render
			repaint();
			return;
		}
		// TODO
		System.out.println(x + " " + y);
	}

}
