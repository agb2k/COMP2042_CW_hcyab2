package Model;

import javafx.scene.image.Image;

/**
 * This class inherits the properties of the actor class
 * This is the class involved in giving the logs in the game functions
 */

public class Log extends Actor {

	private final double speed;

	/**
	 * Gives the object an action to do
	 * @param now Time of the current frame
	 */
	@Override
	public void act(long now) {
		if(Game.getPauseGame() || Game.isPowerUp()){
			//Do nothing
		}
		else{
			move(speed , 0);
			if (getX()>600 && speed>0)
				setX(-180);
			if (getX()<-300 && speed<0)
				setX(700);
		}

	}

	/**
	 * Adds the logs to the game
	 * @param imageLink Log image file path
	 * @param size Size of image
	 * @param xpos x coordinate of image
	 * @param ypos y coordinate of image
	 * @param s Speed of log
	 */
	public Log(String imageLink, int size, int xpos, int ypos, double s) {
		setImage(new Image(imageLink, size,size, true, true));
		setX(xpos);
		setY(ypos);
		speed = s;
	}

	/**
	 * Used to determine if log is moving to the left i.e. speed is less than 0
	 * @return Boolean value of whether speed is less than 0
	 */
	public boolean getLeft() {
		return speed < 0;
	}
}
