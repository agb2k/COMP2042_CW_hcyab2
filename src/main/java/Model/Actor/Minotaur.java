package Model.Actor;

import Model.Game;
import javafx.scene.image.Image;

/**
 * Similarly to log class, this class inherits from the Actor class and is used to create obstacles in the game
 */

public class Minotaur extends Actor {
	private final double speed;
	private final Image min1;
	private final Image min2;
	private final Image min3;
	private final Image min4;
	private final Image min5;
	private final Image min6;
	private final Image min7;
	private final Image min8;

	/**
	 * The actions of the obstacles(vehicles) required for the game
	 * @param now Time of the current frame
	 */
	@Override
	public void act(long now) {
		if(Game.getPauseGame() || Game.isPowerUp()){

		}
		else {
			if (now/90000000  % 8 == 0) {
				setImage(min1);

			}
			else if (now/90000000 % 8 == 1) {
				setImage(min2);

			}
			else if (now/90000000 %8 == 2) {
				setImage(min3);

			}
			else if (now/90000000 %8 == 3) {
				setImage(min4);

			}
			else if (now/90000000 %8 == 4) {
				setImage(min5);

			}
			else if (now/90000000 %8 == 5) {
				setImage(min6);

			}
			else if (now/90000000 %8 == 6) {
				setImage(min7);

			}
			else if (now/90000000 %8 == 7) {
				setImage(min8);

			}


			move(speed , 0);
			if (getX() > 600 && speed>0)
				setX(-200);
			if (getX() < -50 && speed<0)
				setX(600);
		}
	}

	/**
	 * Adds the minotaur to the game
	 * @param xpos X coordinate where the image of the obstacle is placed
	 * @param ypos Y coordinate where the image of the obstacle is placed
	 * @param s Speed of obstacle
	 * @param w Width of obstacle
	 * @param h Height of obstacle
	 */
	public Minotaur(int xpos, int ypos, double s, int w, int h) {
		min1 = new Image("file:src/main/resources/Images/MinFlip1.png", w, h, true, true);
		min2 = new Image("file:src/main/resources/Images/MinFlip2.png", w, h, true, true);
		min3 = new Image("file:src/main/resources/Images/MinFlip3.png", w, h, true, true);
		min4 = new Image("file:src/main/resources/Images/MinFlip4.png", w, h, true, true);
		min5 = new Image("file:src/main/resources/Images/MinFlip5.png", w, h, true, true);
		min6 = new Image("file:src/main/resources/Images/MinFlip6.png", w, h, true, true);
		min7 = new Image("file:src/main/resources/Images/MinFlip7.png", w, h, true, true);
		min8 = new Image("file:src/main/resources/Images/MinFlip8.png", w, h, true, true);
		setX(xpos);
		setY(ypos);
		speed = s;
		setImage(min1);
	}

}
