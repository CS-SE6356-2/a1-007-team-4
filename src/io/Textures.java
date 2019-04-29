package io;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;

public class Textures {
	// Directory to pull from
	private String directory;

	// Image cache
	private HashMap<String, BufferedImage> imageCache = new HashMap<String, BufferedImage>();

	// Directory constructor
	public Textures(String directory) {
		// Direct set
		this.directory = directory;
	}

	// Get image from location
	public BufferedImage getImage(String location) {
		// Check cache
		if (imageCache.containsKey(location)) {
			return imageCache.get(location);
		}
		// Load from file
		BufferedImage img;
		try {
			img = ImageIO.read(new File(directory + location));
		} catch (IOException e) {
			// Error reading from file.
			e.printStackTrace();
			// Assume empty image
			img = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
		}
		// Add to cache
		imageCache.put(location, img);
		// Return loaded image
		return img;
	}
}
