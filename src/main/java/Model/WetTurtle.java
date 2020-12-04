package Model;

import javafx.scene.image.Image;

/**
 * Class involves the wet turtle characters in the game
 * Inherits Actor class
 */

public class WetTurtle extends Actor{
	final Image turtle1;
	final Image turtle2;
	final Image turtle3;
	final Image turtle4;
	private final double speed;
	boolean sunk = false;

	/**
	 * The actions of the wet turtle required for the game
	 * @param now Time of the current frame
	 */
	@Override
	public void act(long now) {
		if(Game.pauseGame){

		}
		else {
			if (now/900000000  % 4 ==0) {
				setImage(turtle2);
				sunk = false;

			}
			else if (now/900000000 % 4 == 1) {
				setImage(turtle1);
				sunk = false;
			}
			else if (now/900000000 %4 == 2) {
				setImage(turtle3);
				sunk = false;
			} else if (now/900000000 %4 == 3) {
				setImage(turtle4);
				sunk = true;
			}

			move(speed , 0);
			if (getX() > 600 && speed>0)
				setX(-200);
			if (getX() < -75 && speed<0)
				setX(600);
		}
	}

	/**
	 * Adds wet turtles to game
	 * @param xpos x coordinate in which turtle is added
	 * @param ypos y coordinate in which turtle is added
	 * @param s Speed of turtle
	 * @param w width of image
	 * @param h height of image
	 */
	public WetTurtle(int xpos, int ypos, double s, int w, int h) {
		turtle1 = new Image("file:src/main/resources/Images/TurtleAnimation1.png", w, h, true, true);
		turtle2 = new Image("file:src/main/resources/Images/TurtleAnimation2Wet.png", w, h, true, true);
		turtle3 = new Image("file:src/main/resources/Images/TurtleAnimation3Wet.png", w, h, true, true);
		turtle4 = new Image("file:src/main/resources/Images/TurtleAnimation4Wet.png", w, h, true, true);
		setX(xpos);
		setY(ypos);
		speed = s;
		setImage(turtle2);
	}

	/**
	 * Checks if turtles sunk
	 * @return Boolean of whether they've sunken
	 */
	public boolean isSunk() {
		return sunk;
	}
}
