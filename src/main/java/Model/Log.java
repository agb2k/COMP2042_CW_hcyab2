package Model;

import javafx.scene.image.Image;

/**
 * This class inherits the properties of the actor class
 * This is the class involved in giving the logs in the game functions
 */

public class Log extends Actor {

	private final double speed;
	@Override
	public void act(long now) {
		if(Game.pauseGame == true){

		}
		else{
			move(speed , 0);
			if (getX()>600 && speed>0)
				setX(-180);
			if (getX()<-300 && speed<0)
				setX(700);
		}

	}
	
	public Log(String imageLink, int size, int xpos, int ypos, double s) {
		setImage(new Image(imageLink, size,size, true, true));
		setX(xpos);
		setY(ypos);
		speed = s;
	}

	public boolean getLeft() {
		return speed < 0;
	}
}
