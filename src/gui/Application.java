package gui;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;

public final class Application {

	// Prevent instantiation
	private Application() {
		throw new RuntimeException("You shouldn't be here!");
	}

	// Frame object
	public static JFrame frame;
	// Default sizes
	private static final int defaultWid = 674, defaultHei = 780;

	// Make container window
	static void initWindow() {
		// Make window
		frame = new JFrame();
		// Set size
		frame.setPreferredSize(new Dimension(defaultWid, defaultHei));
		// Add game manager
		GameStateManager gameManager = new GameStateManager(defaultWid, defaultHei);
		frame.add(gameManager);
		// Let user select (to get key inputs)
		frame.setFocusable(true);
		// Resizable
		frame.setResizable(false);
		// Window header
		frame.setTitle("Crazy 8's");
		// Close app on close
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Pack dimensions
		frame.pack();
		// Center
		frame.setLocationRelativeTo(null);
		// Set icon
		frame.setIconImage(gameManager.getTextures().getImage(getIconLocation()));
		// Display
		frame.setVisible(true);
	}

	// Get icon location
	public static String getIconLocation() {
		return "/Icon.png";
	}

	// Main JFrame beginning
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				// Init window
				initWindow();
			}
		});
	}
}