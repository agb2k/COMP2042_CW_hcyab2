package Model.Actor;

import Model.Game;
import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ThreadLocalRandom;

/**
 * <pre>
 *     This class inherits the actor class
 *     Involves the digits that will be placed on the scoreboard
 * </pre>
 *
 */

public class PowerUp extends Actor{
	private final Image im1;
	private final Image im2;
	private final Image im3;
	private final Image im4;
	private final Image im5;
	private final Image im6;
	private final double speed;
	private boolean go = false;
	private int yCoordIndex;

    @Override
	public void act(long now) {
		if(Game.getPauseGame() || Game.isPowerUp()){
			setImage(null);
			setImage(null);
			go = false;
		}
		else {
			move(speed , 0);
			if (getX()>600 && speed>0)
				setX(-180);
			if (getX()<-300 && speed<0)
				setX(700);
			if(go){
				if (now/90000000  % 6 == 0) {
					setImage(im1);
				}
				else if (now/90000000 %6 == 1) {
					setImage(im2);
				}
				else if (now/90000000 %6 == 2) {
					setImage(im3);
				}
				else if (now/90000000 %6 == 3) {
					setImage(im4);
				}
				else if (now/90000000 %6 == 4) {
					setImage(im5);
				}
				else if (now/90000000 %6 == 5) {
					setImage(im6);
				}
			}
		}
	}

	/**
	 * Grabs the digit you want and places it
	 * @param dim Height and width of digit
	 * @param s Speed required
	 */

	public PowerUp(int dim, double s) {

		im1 = new Image("file:src/main/resources/Images/Frame 1.png", dim, dim, true, true);
		im2 = new Image("file:src/main/resources/Images/Frame 2.png", dim, dim, true, true);
		im3 = new Image("file:src/main/resources/Images/Frame 3.png", dim, dim, true, true);
		im4 = new Image("file:src/main/resources/Images/Frame 4.png", dim, dim, true, true);
		im5 = new Image("file:src/main/resources/Images/Frame 5.png", dim, dim, true, true);
		im6 = new Image("file:src/main/resources/Images/Frame 6.png", dim, dim, true, true);

		ArrayList <Integer> xCoordList = new ArrayList();
		xCoordList.add(0);
		xCoordList.add(440);
		xCoordList.add(50);
		xCoordList.add(490);

		ArrayList <Integer> yCoordList = new ArrayList();
		yCoordList.add(166);
		yCoordList.add(329);

		Random rn = new Random();
		int xCoordIndex = rn.nextInt(4);
		if(xCoordIndex == 0 || xCoordIndex == 2){
			yCoordIndex = 0;
		}else {
			yCoordIndex = 1;
		}

		speed = s;

        long delay = ThreadLocalRandom.current().nextLong(5000, 10000);
		setX((xCoordList.get(xCoordIndex))+55);
		setY(yCoordList.get(yCoordIndex));
		System.out.println("X Coord List Index: "+ xCoordIndex +", Y Coord List Index: "+yCoordIndex+", Delay: "+ delay);
		new Timer().schedule(new TimerTask(){
			@Override
			public void run(){
				setImage(im1);
				go = true;
			}
		}, delay);
		new Timer().schedule(new TimerTask(){
			@Override
			public void run(){
				setImage(null);
				go = false;
			}
		},(delay +20000));

	}
	
}
