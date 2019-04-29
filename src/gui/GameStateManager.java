package gui;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JComponent;

import components.Player;
import game.Crazy8s;
import gui.displayGame.GameDisplay;
import gui.menu.MainMenu;
import io.Textures;

public class GameStateManager extends JComponent {
	// JComponent serial ID
	private static final long serialVersionUID = 1L;

	// Texture loader
	private final Textures imageLoad;

	// Main menu
	private final MainMenu menu;

	// Game
	private Crazy8s game;

	// JComponent size constructor
	public GameStateManager(int wid, int hei) {
		// Set JComponent dimensions
		setBounds(0, 0, wid, hei);
		setPreferredSize(new Dimension(wid, hei));

		// Make menu
		menu = new MainMenu(this, wid, hei);

		// Make texture loader on images folder
		imageLoad = new Textures("images/");
		// Init on main menu
		loadMainMenu();
	}

	// Load main menu
	public void loadMainMenu() {
		// Clear game
		game = null;
		// Remove components
		removeAll();
		// Add menu
		add(menu);
		// Refresh display
		revalidate();
		repaint();
	}

	// Start game with player names
	public void startGame(ArrayList<String> playerNames) {
		// Remove all components
		removeAll();
		// Make player array
		ArrayList<Player> players = new ArrayList<Player>();
		// Initialize players
		for (String name : playerNames) {
			players.add(new Player(name));
		}
		// Add new game
		game = new Crazy8s(players);
		add(new GameDisplay(game, 0, 0, getWidth(), getHeight(), this));
		// Refresh display
		revalidate();
		repaint();
	}

	// Get Texture loader
	public Textures getTextures() {
		return imageLoad;
	}

}
