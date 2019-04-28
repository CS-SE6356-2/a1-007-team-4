package gui.menu.players;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import components.Player;

public class PlayerDisplay extends JButton {
	// JComponent serial ID
	private static final long serialVersionUID = 1L;
	// Font for names
	private static final Font nameFont = new Font("Helvetica", Font.BOLD, 24);

	// Player name
	private final String name;
	// Index location
	private final int index;

	// Index, Name, and size constructor (with parent)
	public PlayerDisplay(PlayerAdder parent, int index, String name, int x, int y, int wid, int hei) {
		// Set name and index
		this.name = name;
		this.index = index;
		// Set JComponent dimensions
		setBounds(x, y, wid, hei);
		setPreferredSize(new Dimension(wid, hei));

		// Add removal button
		JButton remove = new JButton("X");
		// Save player display reference
		PlayerDisplay root = this;
		// Set to remove player on click
		remove.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Remove from parent
				parent.removePlayer(root);
			}
		});
		// Add button
		add(remove);
	}

	// Get player name
	public String getName() {
		return name;
	}

	// Get index
	public int getIndex() {
		return index;
	}

	@Override
	public void paint(Graphics graphics) {
		// Cast to Graphics2D
		Graphics2D g = (Graphics2D) graphics;
		// Set color
		g.setColor(Player.DISP_COLS[index]);
		// Fill space (background)
		g.fillRect(0, 0, getWidth(), getHeight());

		// Draw border
		// Set stroke, saving old
		Stroke oldStroke = g.getStroke();
		g.setStroke(new BasicStroke(5));
		// Set color and draw
		g.setColor(Color.BLACK);
		g.drawRect(0, 0, getWidth() - 1, getHeight() - 1);
		// Reset stroke
		g.setStroke(oldStroke);

		// Set font
		g.setFont(nameFont);
		// Get font metrics
		FontMetrics metrics = g.getFontMetrics();
		// Draw name centered vertically
		g.drawString(name, getWidth() / 4, getHeight() / 2 - metrics.getHeight() / 2 + metrics.getAscent());

		// Paint children
		super.paintChildren(graphics);
	}
}
