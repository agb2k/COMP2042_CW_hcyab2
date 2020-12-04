package Model;

import javafx.scene.image.Image;

/**
 * Similarly to log class, this class inherits from the Actor class and is used to create obstacles in the game
 */

public class Obstacle extends Actor {
	private final double speed;
	@Override
	public void act(long now) {
		if(Game.pauseGame == true){

		}
		else {
			move(speed , 0);
			if (getX() > 600 && speed>0)
				setX(-200);
			if (getX() < -50 && speed<0)
				setX(600);
		}
	}
	
	public Obstacle(String imageLink, int xpos, int ypos, double s, int w, int h) {
		setImage(new Image(imageLink, w,h, true, true));
		setX(xpos);
		setY(ypos);
		speed = s;
	}

}
