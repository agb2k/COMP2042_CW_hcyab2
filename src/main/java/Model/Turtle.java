package Model;

import javafx.scene.image.Image;

/**
 * Class involves the turtle characters in the game
 * Inherits Actor class
 */

public class Turtle extends Actor{
	final Image turtle1;
	final Image turtle2;
	final Image turtle3;
	private final double speed;
	int i = 1;
	boolean bool = true;
	@Override
	public void act(long now) {
		if(Game.pauseGame == true){

		}
		else {
			if (now/900000000  % 3 ==0) {
				setImage(turtle2);

			}
			else if (now/900000000 % 3 == 1) {
				setImage(turtle1);

			}
			else if (now/900000000 %3 == 2) {
				setImage(turtle3);

			}

			move(speed , 0);
			if (getX() > 600 && speed>0)
				setX(-200);
			if (getX() < -75 && speed<0)
				setX(600);
		}
	}
	public Turtle(int xpos, int ypos, double s, int w, int h) {
		turtle1 = new Image("file:src/main/resources/Images/TurtleAnimation1.png", w, h, true, true);
		turtle2 = new Image("file:src/main/resources/Images/TurtleAnimation2.png", w, h, true, true);
		turtle3 = new Image("file:src/main/resources/Images/TurtleAnimation3.png", w, h, true, true);
		setX(xpos);
		setY(ypos);
		speed = s;
		setImage(turtle2);
	}
}
