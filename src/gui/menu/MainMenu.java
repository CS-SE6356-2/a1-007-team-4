package gui.menu;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;

import gui.GameStateManager;
import gui.menu.players.PlayerAdder;

public class MainMenu extends JComponent {
	// JComponent serial ID
	private static final long serialVersionUID = 1L;

	// Parent container
	private final GameStateManager parent;

	// Player adder component
	private final PlayerAdder playerAdder;

	// Size constructor
	public MainMenu(GameStateManager parent, int wid, int hei) {
		// Set parent
		this.parent = parent;
		// Set JComponent dimensions
		setBounds(0, 0, wid, hei);
		setPreferredSize(new Dimension(wid, hei));
		// Set layout to freeform
		setLayout(null);

		// Initialize player adder at position
		playerAdder = new PlayerAdder(wid / 2, hei / 3, wid / 3, hei / 4);
		// Add player adder
		add(playerAdder);

		// Initialie title
		JLabel title = new JLabel("Crazy 8's");
		title.setFont(new Font("TimesRoman", Font.BOLD, 24));
		title.setLocation(wid / 2, hei / 4);
		// Add title
		add(title);

		// Initialize start button
		JButton start = new JButton("Start Game");
		start.setBounds(wid / 3, hei * 2 / 3, wid / 3, hei / 6);
		// Configure to call pressStart on click
		start.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Call game start
				pressStart();
			}
		});
		// Add button
		add(start);

	}

	// Press start button
	private void pressStart() {
		// Check if can start
		if (playerAdder.getCanStart()) {
			// Start with player names
			parent.startGame(playerAdder.getPlayers());
		}
	}
}
