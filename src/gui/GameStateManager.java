package gui;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JComponent;

import gui.menu.MainMenu;
import gui.rendering.Textures;

public class GameStateManager extends JComponent {
	// JComponent serial ID
	private static final long serialVersionUID = 1L;

	// Texture loader
	private final Textures imageLoad;

	// Main menu
	private final MainMenu menu;

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
		// Remove components
		removeAll();
		// Add menu
		add(menu);
		// Refresh display
		revalidate();
		repaint();
	}

	// Start game with player names
	public void startGame(ArrayList<String> players) {
		// TODO
		System.out.println("Start Game: " + players);
	}

	// Get Texture loader
	public Textures getTextures() {
		return imageLoad;
	}

}
