package Model;

import javafx.scene.image.Image;

/**
 * This class inherit the class Actor
 * Involves the background image use in the game
 */

public class BackgroundImage extends Actor{

	@Override
	public void act(long now) {
		
		
	}
//	Changed the zoom settings
	/**
	 * @param imageLink Background image
	 */
	public BackgroundImage(String imageLink) {
		setImage(new Image(imageLink, 700, 857, true, true));
		
	}

}
