package gui.menu.players;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JComponent;

public class PlayerAdder extends JComponent {
	// JComponent serial ID
	private static final long serialVersionUID = 1L;

	// List of current player names
	private final ArrayList<PlayerDisplay> players = new ArrayList<PlayerDisplay>();

	// Size constructor
	public PlayerAdder(int x, int y, int wid, int hei) {
		// Set JComponent dimensions
		setBounds(x, y, wid, hei);
		setPreferredSize(new Dimension(wid, hei));
	}

	// Can start?
	public boolean getCanStart() {
		return players.size() >= 2;
	}

	// Get player names
	public ArrayList<String> getPlayers() {
		// Make return list
		ArrayList<String> ret = new ArrayList<String>();
		// Add each player name
		for (PlayerDisplay disp : players) {
			ret.add(disp.getName());
		}
		// Return list
		return ret;
	}

	// TODO:
	// Add textbox for entering player name
	// Add "Add player" button that creates a playerDisplay and adds to list
}
