package gui;

import javax.swing.JComponent;

import gui.rendering.Textures;

public class GameStateManager extends JComponent {
	// JComponent serial ID
	private static final long serialVersionUID = 1L;

	// Texture loader
	private final Textures imageLoad;

	// JComponent size constructor
	public GameStateManager(int defaultwid, int defaulthei) {
		// TODO Auto-generated constructor stub

		// Make texture loader on images folder
		imageLoad = new Textures("images/");
	}

	// Get Texture loader
	public Textures getTextures() {
		return imageLoad;
	}

}
