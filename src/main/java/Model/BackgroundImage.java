package Model;

import javafx.scene.image.Image;

/**
 *The type BackgroundImage
 *This class inherit the class Actor
 *Involves the background image use in the game
 */

public class BackgroundImage extends Actor{

	@Override
	public void act(long now) {
		
		
	}

	/**
	 * Used to display background image of game
	 * @param imageLink Background image
	 */

	public BackgroundImage(String imageLink) {
		setImage(new Image(imageLink, 0, 857, true, true));
	}

}
