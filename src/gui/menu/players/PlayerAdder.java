package gui.menu.players;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JTextField;

import components.Player;

public class PlayerAdder extends JComponent {
	// JComponent serial ID
	private static final long serialVersionUID = 1L;

	// List of current player names
	private final ArrayList<PlayerDisplay> players = new ArrayList<PlayerDisplay>();

	// Base Y pos for player displays
	private final int yPos;
	// Height for player displays
	private final int yHei;
	// Base X pos for player displays
	private final int xPos;
	// Width for player displays
	private final int xWid;

	// Size constructor
	public PlayerAdder(int x, int y, int wid, int hei) {
		// Set JComponent dimensions
		setBounds(x, y, wid, hei);
		setPreferredSize(new Dimension(wid, hei));
		// Add JTextfield for names
		JTextField namefield = new JTextField();
		namefield.setBounds(wid / 4, 0, wid / 2, hei / 10);
		namefield.setFont(new Font("Helvetica", Font.PLAIN, 12));
		add(namefield);

		// Add JButton for adding player
		JButton addPlayer = new JButton("Add Player");
		addPlayer.setBounds(wid / 4, hei / 8, wid / 2, hei / 12);
		addPlayer.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Make player from current name
				addPlayer(namefield.getText());
				// Clear current text
				namefield.setText("");
			}
		});
		add(addPlayer);

		// Initialize sizes for displays
		xPos = 0;
		xWid = wid;
		yPos = hei / 4;
		yHei = (hei * 3 / 4) / Player.MAX_PLAYERS;
	}

	// Can start?
	public boolean getCanStart() {
		return players.size() >= 2;
	}

	// Add player and make display
	private void addPlayer(String name) {
		// If already at capacity, don't
		if (players.size() >= Player.MAX_PLAYERS) {
			return;
		}
		// Make display
		PlayerDisplay disp = new PlayerDisplay(this, players.size(), name, xPos, yPos + yHei * players.size(), xWid,
				yHei);
		// Add display to list
		players.add(disp);
		// Add display to JComponent
		add(disp);
		// Refresh
		revalidate();
		repaint();
	}

	// Remove player by display
	public void removePlayer(PlayerDisplay disp) {
		// Remove from list
		players.remove(disp.getIndex());
		// Remove from JFrame
		remove(disp);
		// Refresh all: Remove all, then re-add
		// List to store player names in
		ArrayList<String> tempNames = new ArrayList<String>();
		while (players.size() > disp.getIndex()) {
			// Remove from list
			PlayerDisplay removed = players.remove(disp.getIndex());
			// Remove from JFrame
			remove(removed);
			// Add name to names list
			tempNames.add(removed.getName());
		}
		// All removed, re-add each name
		for (String name : tempNames) {
			addPlayer(name);
		}
		// Refresh
		revalidate();
		repaint();

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
