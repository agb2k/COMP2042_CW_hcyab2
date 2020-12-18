package Model.Actor;

import javafx.scene.image.Image;

/**
 * <pre>
 * Class inherits actor class
 * Class is involved in the end point of the game
 * </pre>
 *
 */

public class End extends Actor {
	private boolean activated = false;

	@Override
	public void act(long now) {
	}

	/**
	 * Function takes in coordinates to set the end point
	 * @param x X coordinate for the end point to be placed
	 * @param y Y coordinate for the end point to be placed
	 */
	public End(int x, int y) {
		setX(x);
		setY(y);
		setImage(new Image("file:src/main/resources/Images/End.png", 60, 60, true, true));
	}

	/**
	 *Function replaces the initial end point image with one with a frog in it
	 */
	public void setEnd() {
		setImage(new Image("file:src/main/resources/Images/FrogEnd.png", 70, 70, true, true));
		activated = true;
	}

	/**
	 * Function prevents frog from jumping onto the same end block more than once
	 * @return The boolean, activated which tells whether the end block is activated, is returned
	 */

	public boolean isActivated() {
		return activated;
	}
	

}
