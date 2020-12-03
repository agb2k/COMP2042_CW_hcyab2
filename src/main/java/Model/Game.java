package Model;

import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import javax.swing.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;

/**
 * This class contains the game itself
 */

public class Game{

    AnimationTimer timer;
    final MyStage background;
    final Frog frog;


    /**
     * Creates the stage, scene and adds items to it
     * @param userName Name of the user which is entered right before the game
     */
    public Game(String userName){
        deleteScores("src/main/resources/Misc/roundScore.csv");
        Stage game = new Stage();
        background = new MyStage();
        Scene scene2  = new Scene(background,600,800);
        background.autosize();

        /**
         * Adds the background image for the game
         */
        BackgroundImage froggerback = new BackgroundImage("file:src/main/resources/Images/GameBackground.png");
        background.add(froggerback);

        /**
         * Adds the logs to the game
         */
        background.add(new Log("file:src/main/resources/Images/log3.png", 150, 0, 166, 0.75));
        background.add(new Log("file:src/main/resources/Images/log3.png", 150, 220, 166, 0.75));
        background.add(new Log("file:src/main/resources/Images/log3.png", 150, 440, 166, 0.75));
        background.add(new Log("file:src/main/resources/Images/logs.png", 300, 0, 276, -2));
        background.add(new Log("file:src/main/resources/Images/logs.png", 300, 400, 276, -2));
        background.add(new Log("file:src/main/resources/Images/log3.png", 150, 50, 329, 0.75));
        background.add(new Log("file:src/main/resources/Images/log3.png", 150, 270, 329, 0.75));
        background.add(new Log("file:src/main/resources/Images/log3.png", 150, 490, 329, 0.75));

        /**
         * Adds the turtles to the game
         */
        background.add(new Turtle(500, 376, -1, 130, 130));
        background.add(new Turtle(300, 376, -1, 130, 130));
        background.add(new WetTurtle(700, 376, -1, 130, 130));
        background.add(new WetTurtle(600, 217, -1, 130, 130));
        background.add(new WetTurtle(400, 217, -1, 130, 130));
        background.add(new WetTurtle(200, 217, -1, 130, 130));

        /**
         * Adds the end check point to the game
         */
        background.add(new End(13,96));
        background.add(new End(141,96));
        background.add(new End(141 + 141-13,96));
        background.add(new End(141 + 141-13+141-13+1,96));
        background.add(new End(141 + 141-13+141-13+141-13+3,96));

        /**
         * Adds the frog to the game
         */
        frog = new Frog("file:src/main/resources/Images/froggerUp.png");
        background.add(frog);

        /**
         * Adds the obstacles (vehicles) to the game
         */
        background.add(new Obstacle("file:src/main/resources/Images/truck1"+"Right.png", 0, 649, 1, 120, 120));
        background.add(new Obstacle("file:src/main/resources/Images/truck1"+"Right.png", 300, 649, 1, 120, 120));
        background.add(new Obstacle("file:src/main/resources/Images/truck1"+"Right.png", 600, 649, 1, 120, 120));
        background.add(new Obstacle("file:src/main/resources/Images/car1Left.png", 100, 597, -1, 50, 50));
        background.add(new Obstacle("file:src/main/resources/Images/car1Left.png", 250, 597, -1, 50, 50));
        background.add(new Obstacle("file:src/main/resources/Images/car1Left.png", 400, 597, -1, 50, 50));
        background.add(new Obstacle("file:src/main/resources/Images/car1Left.png", 550, 597, -1, 50, 50));
        background.add(new Obstacle("file:src/main/resources/Images/truck2Right.png", 0, 540, 1, 200, 200));
        background.add(new Obstacle("file:src/main/resources/Images/truck2Right.png", 500, 540, 1, 200, 200));
        background.add(new Obstacle("file:src/main/resources/Images/car1Left.png", 500, 490, -5, 50, 50));
        /**
         * Adds the initial score to the game
         */
        background.add(new Digit(0, 30, 100, 50));

        /**
         * Adds a mute button to the game
         */
        background.add(new Mute(background,45,500,40));

        /**
         * Adds a play/pause button to the game
         */
        background.add(new Pause(background, 35, 550, 45));

        /**
         * Sets up the game
         */
        background.start();
        /**
         * Removes title header from game window
         */
        game.initStyle(StageStyle.UNDECORATED);
        /**
         * Sets the games scene to Scene2
         */
        game.setScene(scene2);
        /**
         * Displays the game
         */
        game.show();
        /**
         * Starts multiple functions involved in the starting of the game like the timer and music
         */
        start(userName,game);
    }

    /**
     * Deletes the round scores in the given filepath
     * @param filepath the location of the round score files
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
     * Changes the frogs points and stops the game at appropriate times
     * @param userName Name of player
     */
    public void createTimer(String userName, Stage stage) {
        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                if (Frog.lives<1){
                    background.stopMusic();
                    stop();
                    background.stop();
                    finalStop(stage);
                }
                if (frog.changeScore()) {
                    setNumber(frog.getPoints());
                }
                if (frog.getStop()) {
                    System.out.print("STOP:");
                    background.stopMusic();
                    stop();
                    background.stop();

                    winAlert();
                    saveScore(userName, frog.getPoints(), "src/main/resources/Misc/Highscore.csv");
                    deleteScores("src/main/resources/Misc/roundScore.csv");

                    finalStop(stage);
                }
            }
        };
    }

    private void winAlert() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.initStyle(StageStyle.UTILITY);
        alert.setTitle("You Have Won The Game!");
        alert.setHeaderText("Your Score: "+ frog.getPoints()+"!");
        alert.setContentText("Highest Possible Score: 800");
        alert.show();
    }

    /**
     * Saves the score of the player in a file
     * @param name Name of player
     * @param score Score of the player in the game
     * @param filepath The location of the file where the high scores are stored
     */
    public static void saveScore(String name, int score, String filepath){
        try {
            FileWriter fw = new FileWriter(filepath, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            pw.println(name+","+score);
            pw.flush();
            pw.close();
        }
        catch (Exception E){
            JOptionPane.showMessageDialog(null, "Error! Score not saved :(");
        }
    }

    /**
     * Starts up various functions for the beginning of the game
     * @param userName name of Player
     */
    public void start(String userName, Stage stage) {
		background.playMusic();
        createTimer(userName, stage);
        timer.start();
    }

    /**
     * Stops the timer function for the end of the game
     */
    public void finalStop(Stage stage) {
        timer.stop();
        stage.close();
    }


    /**
     * Provides the image of the number required for the score
     * @param n The digit required
     */
    public void setNumber(int n) {
        int shift = 0;
        while (n > 0) {
            int d = n / 10;
            int k = n - d * 10;
            n = d;
            background.add(new Digit(k, 30, 100 - shift, 50));
            shift+=30;
        }
    }
}