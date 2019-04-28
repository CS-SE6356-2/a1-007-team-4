package gui.menu;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
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
	// Background color
	private static final Color bgcol = new Color(255, 200, 127);

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
		playerAdder = new PlayerAdder(wid / 4, hei / 4, wid / 2, hei / 2);
		// Add player adder
		add(playerAdder);

		// Initialie title
		JLabel title = new JLabel("Crazy 8's");
		title.setFont(new Font("TimesRoman", Font.BOLD, 36));
		title.setHorizontalAlignment(JLabel.CENTER);
		title.setBounds(wid / 3, hei / 12, wid / 3, hei / 6);
		title.setForeground(new Color(127, 0, 0));
		// Add title
		add(title);
		// Initialize title background
		JLabel titlebg = new JLabel("Crazy 8's");
		titlebg.setFont(new Font("TimesRoman", Font.BOLD, 36));
		titlebg.setHorizontalAlignment(JLabel.CENTER);
		final int shift = 2;
		titlebg.setBounds(wid / 3 + shift, hei / 12 + shift, wid / 3, hei / 6);
		titlebg.setForeground(new Color(63, 63, 63));
		// Add title background
		add(titlebg);

		// Initialize start button
		JButton start = new JButton("Start Game");
		start.setBounds(wid / 4, hei * 3 / 4, wid / 2, hei / 12);
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

	// Fill background behind rendering
	@Override
	public void paint(Graphics g) {
		// Fill background
		g.setColor(bgcol);
		g.fillRect(getX(), getY(), getWidth(), getHeight());
		// Do regular
		super.paint(g);
	}
}
