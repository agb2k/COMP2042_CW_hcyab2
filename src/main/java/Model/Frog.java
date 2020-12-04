package Model;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import javax.swing.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
//class was previously known as Actor
/**
 * This class inherits all the properties of the actor class
 * This class is involved in the processes the main character(frog) goes through i.e. movements, death etc.
 */


public class Frog extends Actor{
	/**
	 * Images of the frog when travelling to its respective direction
	 */
	final Image imgW1;
	final Image imgA1;
	final Image imgS1;
	final Image imgD1;
	final Image imgW2;
	final Image imgA2;
	final Image imgS2;
	final Image imgD2;
	/**
	 * The points of the frog
	 */
	int points = 0;
	/**
	 * Tally points to be used for each life
	 */
	int pointTally = 0;
	int end = 0;
	/**
	 * Boolean used to decide whether the frog has completed an even number of steps
	 */
	private boolean second = false;
	/**
	 * Boolean to see if the frog is moving
	 */
	static boolean noMove = false;
	final double movement = 13.3333333 * 2;
	final double movementX = 10.666666 * 2;
	final int imgSize = 40;
	boolean carDeath = false;
	boolean waterDeath = false;
	boolean changeScore = false;
	int carD = 0;
	double w = 800;
	static int lives = 5;
	ArrayList<End> inter = new ArrayList<>();
	String text = "";

	/**
	 * <pre>
	 * Initializes the frog character to move and switch to the respective image when particular buttons are clicked
	 * Also, increases the score whenever moved upwards
	 * </pre>
	 * @param imageLink The path of the frog image or any image to be used here
	 */
	public Frog(String imageLink) {
		setImage(new Image(imageLink, imgSize, imgSize, true, true));
		setX(300);
		setY(679.8 + movement);
		imgW1 = new Image("file:src/main/resources/Images/froggerUp.png", imgSize, imgSize, true, true);
		imgA1 = new Image("file:src/main/resources/Images/froggerLeft.png", imgSize, imgSize, true, true);
		imgS1 = new Image("file:src/main/resources/Images/froggerDown.png", imgSize, imgSize, true, true);
		imgD1 = new Image("file:src/main/resources/Images/froggerRight.png", imgSize, imgSize, true, true);
		imgW2 = new Image("file:src/main/resources/Images/froggerUpJump.png", imgSize, imgSize, true, true);
		imgA2 = new Image("file:src/main/resources/Images/froggerLeftJump.png", imgSize, imgSize, true, true);
		imgS2 = new Image("file:src/main/resources/Images/froggerDownJump.png", imgSize, imgSize, true, true);
		imgD2 = new Image("file:src/main/resources/Images/froggerRightJump.png", imgSize, imgSize, true, true);
		buttonClickCheck();
	}

	/**
	 * Checks if a button has been clicked and performs the corresponding actions
	 */
	private void buttonClickCheck() {
		setOnKeyPressed(event -> {
			if(Game.pauseGame){
				//Do Nothing
			}
			else{
				if (noMove) {

				} else {
					if (second) {
						if (event.getCode() == KeyCode.W) {
							move(0, -movement);
							changeScore = false;
							setImage(imgW1);
							second = false;
						} else if (event.getCode() == KeyCode.A) {
							move(-movementX, 0);
							setImage(imgA1);
							second = false;
						} else if (event.getCode() == KeyCode.S) {
							move(0, movement);
							setImage(imgS1);
							second = false;
						} else if (event.getCode() == KeyCode.D) {
							move(movementX, 0);
							setImage(imgD1);
							second = false;
						}
					} else if (event.getCode() == KeyCode.W) {
						move(0, -movement);
						setImage(imgW2);
						second = true;
					} else if (event.getCode() == KeyCode.A) {
						move(-movementX, 0);
						setImage(imgA2);
						second = true;
					} else if (event.getCode() == KeyCode.S) {
						move(0, movement);
						setImage(imgS2);
						second = true;
					} else if (event.getCode() == KeyCode.D) {
						move(movementX, 0);
						setImage(imgD2);
						second = true;
					}
				}
			}
		});
		setOnKeyReleased(event -> {
			if(Game.pauseGame){
				//Do nothing
			}
			else{
				if (noMove) {
				} else {
					if (event.getCode() == KeyCode.W) {
						if (getY() < w) {
							changeScore = true;
							w = getY();
							points += 10;
							pointTally += 10;
						}
						move(0, -movement);
						setImage(imgW1);
						second = false;
					} else if (event.getCode() == KeyCode.A) {
						move(-movementX, 0);
						setImage(imgA1);
						second = false;
					} else if (event.getCode() == KeyCode.S) {
						move(0, movement);
						setImage(imgS1);
						second = false;
					} else if (event.getCode() == KeyCode.D) {
						move(movementX, 0);
						setImage(imgD1);
						second = false;
					}
				}
			}
		});
	}

	/**
	 * Used to initialize the requirements for the frog and it's surrounding obstacles
	 * @param now Time of the current frame
	 */
	@Override
	public void act(long now) {
		outOfBounds();

		carDeath(now);
		waterDeath(now);

		collision();
	}

	/**
	 * Checks if the frog collides with any of the other objects and performs the corresponding tasks
	 */
	private void collision() {
		if (getIntersectingObjects(Obstacle.class).size() >= 1) {
			carDeath = true;
		}
		if (getIntersectingObjects(Log.class).size() >= 1 && !noMove) {
			if(getIntersectingObjects(Log.class).get(0).getLeft())
				move(-2*AddObjects.speedFactor,0);
			else{
				move (.75*AddObjects.speedFactor,0);
			}
		}
		else if (getIntersectingObjects(Turtle.class).size() >= 1 && !noMove) {
			move(-1*AddObjects.speedFactor,0);
		}
		else if (getIntersectingObjects(WetTurtle.class).size() >= 1) {
			if (getIntersectingObjects(WetTurtle.class).get(0).isSunk()) {
				waterDeath = true;
			} else {
				move(-1*AddObjects.speedFactor,0);
			}
		}
		else if (getIntersectingObjects(End.class).size() >= 1) {
			inter = (ArrayList<End>) getIntersectingObjects(End.class);
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
	 * The actions involved when the frog dies due to water
	 * @param now Time of the current frame
	 */
	private void waterDeath(long now) {
		if (waterDeath) {
			noMove = true;
			if (now % 11 ==0) {
				carD++;
			}
			if (carD==1) {
				setImage(new Image("file:src/main/resources/Images/waterdeath1.png", imgSize,imgSize , true, true));
			}
			if (carD==2) {
				setImage(new Image("file:src/main/resources/Images/waterdeath2.png", imgSize,imgSize , true, true));
			}
			if (carD==3) {
				setImage(new Image("file:src/main/resources/Images/waterdeath3.png", imgSize,imgSize , true, true));
			}
			if (carD == 4) {
				setImage(new Image("file:src/main/resources/Images/waterdeath4.png", imgSize,imgSize , true, true));
			}
			if (carD == 5) {
				setX(300);
				setY(679.8+movement);
				waterDeath = false;
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
	 * The actions involved when the frog dies due to vehicles
	 * @param now Time of the current frame
	 */
	private void carDeath(long now) {
		if (carDeath) {
			noMove = true;
			if (now % 11 ==0) {
				carD++;
			}
			if (carD==1) {
				setImage(new Image("file:src/main/resources/Images/cardeath1.png", imgSize, imgSize, true, true));
			}
			if (carD==2) {
				setImage(new Image("file:src/main/resources/Images/cardeath2.png", imgSize, imgSize, true, true));
			}
			if (carD==3) {
				setImage(new Image("file:src/main/resources/Images/cardeath3.png", imgSize, imgSize, true, true));
			}
			if (carD == 4) {
				setX(300);
				setY(679.8+movement);
				carDeath = false;
				carD = 0;
				setImage(new Image("file:src/main/resources/Images/froggerUp.png", imgSize, imgSize, true, true));
				noMove = false;
				if (points>50) {
					points-=50;
					pointTally-=50;
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
	void gameOverAlert() {
		Alert end = new Alert(Alert.AlertType.INFORMATION);
		end.initStyle(StageStyle.UTILITY);
		end.setTitle("You died!");
		end.setHeaderText("Game over :(");
		end.setContentText("Try again");
		end.show();
		deadScoreAlert();
		deleteScores("src/main/resources/Misc/roundScore.csv");

		Game.timer.stop();
	}

	/**
	 * Function used to check if it's time to stop the game
	 * @return Boolean value which checks if the integer value,end, is equal to 5
	 */
	public boolean getStop() {
		return end==5;
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


}
