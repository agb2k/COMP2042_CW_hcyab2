package Model.Actor;

import Model.Game;
import javafx.scene.image.Image;

/**
 * Similarly to log class, this class inherits from the Actor class and is used to create dragons in the game
 */

public class Dragon extends Actor {
	private final double speed;
	private final Image min1;
	private final Image min2;
	private final Image min3;

	/**
	 * The actions of the dragons required for the game
	 * @param now Time of the current frame
	 */
	@Override
	public void act(long now) {
		if(Game.getPauseGame() || Game.isPowerUp()){
			//Do Nothing
		}
		else {
			if (now/100000000  % 3 == 0) {
				setImage(min1);

			}
			else if (now/100000000 % 3 == 1) {
				setImage(min2);

			}
			else if (now/100000000 % 3 == 2) {
				setImage(min3);
			}



			move(speed , 0);
			if (getX() > 600 && speed>0)
				setX(-200);
			if (getX() < -50 && speed<0)
				setX(600);
		}
	}

	/**
	 * Adds the dragon to the game
	 * @param xpos X coordinate where the image of the dragon is placed
	 * @param ypos Y coordinate where the image of the dragon is placed
	 * @param s Speed of dragon
	 * @param w Width of dragon
	 * @param h Height of dragon
	 */
	public Dragon(int xpos, int ypos, double s, int w, int h) {
		min1 = new Image("file:src/main/resources/Images/Dragon1.png", w, h, true, true);
		min2 = new Image("file:src/main/resources/Images/Dragon2.png", w, h, true, true);
		min3 = new Image("file:src/main/resources/Images/Dragon3.png", w, h, true, true);
		setX(xpos);
		setY(ypos);
		speed = s;
		setImage(min1);
	}

}
