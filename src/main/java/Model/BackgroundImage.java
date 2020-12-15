package Model;

import javafx.scene.image.Image;

/**
 * <pre>
 *     The type BackgroundImage
 *     This class inherit the class Actor
 *     Involves the background image use in the game
 * </pre>
 */

public class BackgroundImage extends Actor{

	@Override
	public void act(long now) {
		
		
	}
//	Changed the zoom settings
	/**
	 * Used to display background image of game
	 * @param imageLink Background image
	 */

//	700, 857
	public BackgroundImage(String imageLink) {
		setImage(new Image(imageLink, 0, 857, true, true));
	}

}
