package gui.menu.players;

import java.awt.Dimension;

import javax.swing.JComponent;

public class PlayerDisplay extends JComponent {
	// JComponent serial ID
	private static final long serialVersionUID = 1L;

	// Player name
	private final String name;

	// Name and size constructor
	public PlayerDisplay(String name, int x, int y, int wid, int hei) {
		// Set name
		this.name = name;
		// Set JComponent dimensions
		setBounds(x, y, wid, hei);
		setPreferredSize(new Dimension(wid, hei));
	}

	// Get player name
	public String getName() {
		return name;
	}

	// TODO: Include drawing functionality

}
