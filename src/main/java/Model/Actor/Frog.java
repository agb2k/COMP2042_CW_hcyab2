package Model.Actor;

import Controller.FrogController;
import Model.Util.AddObjects;
import Model.Game;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import javax.swing.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Timer;
import java.util.TimerTask;

/**
 * This class inherits all the properties of the actor class
 * This class is involved in the processes the main character(frog) goes through i.e. movements, death etc.
 */


//Observer
public class Frog extends Actor{

	private final FrogController frogController = new FrogController(this);

	/**
	 * The points of the frog
	 */
	private int points = 0;
	/**
	 * Tally points to be used for each life
	 */
	private int pointTally = 0;
	/**
	 * Used to check for end game
	 */
	private int end = 0;

	/**
	 * Boolean to see if the frog is moving
	 */
	private boolean noMove = false;

	/**
	 * Number of units the frog moves forward on the Y-axis
	 */
	private final double movement = 13.3333333 * 2;


	/**
	 * Image size
	 */
	private final int imgSize = 40;
	/**
	 * Boolean that tells whether a car death has taken place
	 */
	private boolean carDeath = false;

	/**
	 * Boolean that tells whether water death has taken place
	 */
	private boolean waterDeath = false;

	/**
	 * Boolean that tells whether the score has changed
	 */
	private boolean changeScore = false;

	/**
	 * Car death integer
	 */
	private int carD = 0;

	/**
	 * Max score
	 */
	private double w = 800;

	/**
	 * Frog lives
	 */
	private int lives = 5;

	/**
	 * String placeholder
	 */
	private String text = "";

	/**
	 * Boolean to see if life changed
	 */
	private static boolean changeLife = false;
	/**
	 * Boolean to see if it's the first powerUp colission
	 */
	private boolean first = true;

	/**
	 * Initializes the frog character to frogController and switch to the respective image when particular buttons are clicked
	 * Also, increases the score whenever moved upwards
	 */
	public Frog() {
		setImage(new Image("file:src/main/resources/Images/froggerUp.png", imgSize, imgSize, true, true));
		setX(300);
		setY(679.8 + movement);
		frogController.buttonClickCheck();
	}

	/**
	 * Used to initialize the requirements for the frog and it's surrounding obstacles
	 * @param now Time of the current frame
	 */
	@Override
	public void act(long now) {
		outOfBounds();
		Death(now);
		collision();
	}

	/**
	 * Checks if the frog collides with any of the other objects and performs the corresponding tasks
	 */
	private void collision() {
		if (getIntersectingObjects(Vehicles.class).size() >= 1) {
			carDeath = true;
		}
		if (getIntersectingObjects(Minotaur.class).size() >= 1) {
			carDeath = true;
		}
		if (getIntersectingObjects(Skeleton.class).size() >= 1) {
			carDeath = true;
		}
		if (getIntersectingObjects(Dragon.class).size() >= 1) {
			carDeath = true;
		}
		if (getIntersectingObjects(PowerUp.class).size() >= 1 && first) {
			first = false;
			System.out.println("powerUp collision taken place");
			new Timer().schedule(new TimerTask(){
				@Override
				public void run(){
					Game.setPowerUp(true);
				}
			},50);
			new Timer().schedule(new TimerTask(){
				@Override
				public void run(){
					Game.setPowerUp(false);
				}
			},5000);
		}

		if(Game.isPowerUp()){
			if ((getIntersectingObjects(Log.class).size() >= 1 || getIntersectingObjects(Turtle.class).size() >= 1) && !noMove) {
				move(0,0);
			}
			else if (getIntersectingObjects(WetTurtle.class).size() >= 1) {
				if (getIntersectingObjects(WetTurtle.class).get(0).isSunk()) {
					waterDeath = true;
				} else {
					move(0,0);
				}
			}
			else if (getIntersectingObjects(End.class).size() >= 1) {
				if (getIntersectingObjects(End.class).get(0).isActivated()) {
					end--;
					points-=50;
					pointTally-=50;
				}
				points+=50;
				pointTally+=50;
				changeScore = true;
				w=800;
				getIntersectingObjects(End.class).get(0).setEnd();
				end++;
				setX(300);
				setY(679.8+movement);
			}
			else if (getY()<413){
				waterDeath = true;
			}
		}
		else{
			if (getIntersectingObjects(Log.class).size() >= 1 && !noMove) {
				if(getIntersectingObjects(Log.class).get(0).getLeft())
					move(-2* AddObjects.getSpeedFactor(),0);
				else{
					move (.75*AddObjects.getSpeedFactor(),0);
				}
			}
			else if (getIntersectingObjects(Turtle.class).size() >= 1 && !noMove) {
				move(-1*AddObjects.getSpeedFactor(),0);
			}
			else if (getIntersectingObjects(WetTurtle.class).size() >= 1) {
				if (getIntersectingObjects(WetTurtle.class).get(0).isSunk()) {
					waterDeath = true;
				} else {
					move(-1*AddObjects.getSpeedFactor(),0);
				}
			}
			else if (getIntersectingObjects(End.class).size() >= 1) {
				if (getIntersectingObjects(End.class).get(0).isActivated()) {
					end--;
					points-=50;
					pointTally-=50;
				}
				points+=50;
				pointTally+=50;
				changeScore = true;
				w=800;
				getIntersectingObjects(End.class).get(0).setEnd();
				end++;
				setX(300);
				setY(679.8+movement);
			}
			else if (getY()<413){
				waterDeath = true;
			}
		}

	}

	/**
	 * Checks if the frog is out of bounds of the map
	 */
	private void outOfBounds() {
		if (getY()<0 || getY()>734) {
			setX(300);
			setY(679.8+movement);
		}
		if (getX()<0) {
			move(movement*2, 0);
		}
		if (getX()>600) {
			move(-movement*2, 0);
		}
	}


	/**
	 * The actions involved when the frog dies
	 * @param now Time of the current frame
	 */
	private void Death(long now){
		if(waterDeath || carDeath){
			noMove = true;
			String str = null;
			if(waterDeath){
				str = "water";
			}else {
				str = "car";
			}

			if (now % 11 ==0) {
				carD++;
			}
			if (carD==1) {
				setImage(new Image("file:src/main/resources/Images/"+str+"death1.png", imgSize,imgSize , true, true));
			}
			if (carD==2) {
				setImage(new Image("file:src/main/resources/Images/"+str+"death2.png", imgSize,imgSize , true, true));
			}
			if (carD==3) {
				setImage(new Image("file:src/main/resources/Images/"+str+"death3.png", imgSize,imgSize , true, true));
			}
			if (carD == 4) {
				setImage(new Image("file:src/main/resources/Images/"+str+"death4.png", imgSize,imgSize , true, true));
			}
			if (carD == 5) {
				setX(300);
				setY(679.8+movement);
				waterDeath = false;
				carDeath = false;
				carD = 0;
				setImage(new Image("file:src/main/resources/Images/froggerUp.png", imgSize, imgSize, true, true));
				noMove = false;
				if (points>50) {
					points-=50;
					pointTally -=50;
					changeScore = true;
				}
				lives--;
				if(lives == 0){
					gameOverAlert();
				}
				else{
					deadScoreAlert();
				}

			}
		}
	}

	/**
	 * Saves the scores of each round
	 * @param lives Remaining lives of frog
	 * @param score The round score
	 * @param filepath The location of the file in which the round scores will be saved
	 */
	public static void saveRoundScore(int lives, int score, String filepath){
		try {
			FileWriter fw = new FileWriter(filepath, true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);

			pw.println((5-lives)+","+ score);
			pw.flush();
			pw.close();
		}
		catch (Exception E){
			JOptionPane.showMessageDialog(null, "Error! Score not saved :(");
		}
	}


	/**
	 * Clears the filepath i.e used to delete scores from filepath
	 * @param filepath path of score file in our case
	 */
	public void deleteScores(String filepath){
		try {
			PrintWriter pw = new PrintWriter(filepath);
			pw.close();
		}
		catch (Exception E){
			JOptionPane.showMessageDialog(null, "Error! Scores not deleted :(");
		}
	}

	/**
	 * Alerts when frog dies
	 */
	public void deadScoreAlert(){
		changeLife = true;
		if(pointTally<0){
			pointTally = 0;
		}

		text = text + ("\nRound "+ (5-lives) +" Score: " + pointTally);
		saveRoundScore(lives, pointTally,"src/main/resources/Misc/roundScore.csv");
		pointTally = 0;

		try{
			Stage roundScore = new Stage();
			roundScore.initStyle(StageStyle.UNDECORATED);
			Pane root = FXMLLoader.load(getClass().getResource("/View/RoundScore.fxml"));
			Scene roundScoreScene = new Scene(root);
			roundScore.setScene(roundScoreScene);
			roundScore.show();
		}catch(Exception e){
			e.printStackTrace();
		}

	}

	/**
	 * Alerts when game is over
	 */
	public void gameOverAlert() {
		Alert end = new Alert(Alert.AlertType.INFORMATION);
		end.initStyle(StageStyle.UTILITY);
		end.setTitle("You died!");
		end.setHeaderText("Game over :(");
		end.setContentText("Try again");
		end.show();
		deadScoreAlert();
		deleteScores("src/main/resources/Misc/roundScore.csv");

		Game.getTimer().stop();
	}

	/**
	 * Function used to check if it's time to stop the game
	 * @return Boolean value which checks if the integer value,end, is equal to 5
	 */
	public boolean getStop() {
		return end==5;
	}

	/**
	 * Setter for points
	 * @param points point value
	 */
	public void setPoints(int points) {
		this.points = points;
	}

	/**
	 * Gets the frogs points
	 * @return Points of frog
	 */
	public int getPoints() {
		return points;
	}

	/**
	 * Checks if score has changed
	 * @return A boolean value
	 */
	public boolean changeScore() {
		if (changeScore) {
			changeScore = false;
			return true;
		}
		return false;
	}

	/**
	 * Getter for lives
	 * @return lives
	 */
	public int getLives() {
		return lives;
	}


	/**
	 * Getter for userStop
	 * @return changeLife boolean value
	 */
	public static boolean isChangeLife() {
		return changeLife;
	}

	/**
	 * Setter for changeLife
	 * @param changeLife New boolean value to assign to changeLife
	 */
	public static void setChangeLife(boolean changeLife) {
		Frog.changeLife = changeLife;
	}

	/**
	 * Getter for pointTally
	 * @return pointTally int value
	 */
	public int getPointTally() {
		return pointTally;
	}

	/**
	 * Setter for pointTally
	 * @param pointTally int value to set pointTally as
	 */
	public void setPointTally(int pointTally) {
		this.pointTally = pointTally;
	}

	/**
	 * Getter for w
	 * @return w double value
	 */
	public double getW() {
		return w;
	}

	/**
	 * Setter for w
	 * @param w The value to set w as
	 */
	public void setW(double w) {
		this.w = w;
	}

	/**
	 * Getter for noMove
	 * @return noMove double value
	 */
	public boolean isNoMove() {
		return noMove;
	}

	/**
	 * Getter for movement
	 * @return movement value
	 */
	public double getMovement() {
		return movement;
	}

	/**
	 * Setter for changeScore value
	 * @param changeScore Boolean value of changeScore required
	 */
	public void setChangeScore(boolean changeScore) {
		this.changeScore = changeScore;
	}

}
