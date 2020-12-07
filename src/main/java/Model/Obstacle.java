package Model;

import javafx.scene.image.Image;

/**
 * Similarly to log class, this class inherits from the Actor class and is used to create obstacles in the game
 */

public class Obstacle extends Actor {
	private final double speed;

	/**
	 * The actions of the obstacles(vehicles) required for the game
	 * @param now Time of the current frame
	 */
	@Override
	public void act(long now) {
		if(Game.getPauseGame() == true){

		}
		else {
			move(speed , 0);
			if (getX() > 600 && speed>0)
				setX(-200);
			if (getX() < -50 && speed<0)
				setX(600);
		}
	}

	/**
	 * Adds the obstacles to the game
	 * @param imageLink Image file path
	 * @param xpos X coordinate where the image of the obstacle is placed
	 * @param ypos Y coordinate where the image of the obstacle is placed
	 * @param s Speed of obstacle
	 * @param w Width of obstacle
	 * @param h Height of obstacle
	 */
	public Obstacle(String imageLink, int xpos, int ypos, double s, int w, int h) {
		setImage(new Image(imageLink, w,h, true, true));
		setX(xpos);
		setY(ypos);
		speed = s;
	}

}
