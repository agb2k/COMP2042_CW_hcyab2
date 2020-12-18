package Model;

import Model.Actor.Digit;
import Model.Actor.Frog;
import Model.Util.AddObjects;
import Model.World.MyStage;
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

    private static AnimationTimer timer;
    private final MyStage background;
    private final Frog frog;
    private static boolean pauseGame = false;
    private static boolean powerUp = false;



    /**
     * Creates the stage, scene and adds items to it
     * @param userName Name of the user which is entered right before the game
     * @param level Game level
     */
    public Game(String userName, int level){
        System.out.println(userName);
        deleteScores("src/main/resources/Misc/roundScore.csv");
        Stage game = new Stage();
        background = new MyStage();
        Scene scene2  = new Scene(background,600,800);
        background.autosize();

        AddObjects.AddGameObjects(background, level);
        /**
         * Adds the frog to the game
         */
        frog = new Frog();
        background.add(frog);


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
        start(userName,game,level);
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
     * @param level Designated level to play on
     * @param stage Designated stage for game to take place
     */
    public void createTimer(String userName, Stage stage, int level) {
        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                if (frog.getLives()<1){
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
                    saveScore(userName, level , frog.getPoints(), "src/main/resources/Misc/Highscore.csv");
                    deleteScores("src/main/resources/Misc/roundScore.csv");

                    finalStop(stage);
                }
                if (Frog.isUserStop()){

                    System.out.print("USER STOPPED:");
                    background.stopMusic();
                    stop();
                    background.stop();

                    userStopAlert();
                    deleteScores("src/main/resources/Misc/roundScore.csv");

                    finalStop(stage);

                    Frog.setUserStop(false);

                }
            }
        };
    }

    /**
     * Alerts the player that he's stopped the game
     */
    private void userStopAlert() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.initStyle(StageStyle.UTILITY);
        alert.setTitle("You Have Won The Game!");
        alert.setHeaderText("Game Stopped!");
        alert.setContentText("Come again soon!");
        alert.show();
    }

    /**
     * Alerts the player that he's won the game
     */
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
     * @param level Game level
     * @param score Score of the player in the game
     * @param filepath The location of the file where the high scores are stored
     */
    public static void saveScore(String name, int level, int score, String filepath){
        try {
            FileWriter fw = new FileWriter(filepath, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            pw.println(name+","+level+","+score);
            pw.flush();
            pw.close();
        }
        catch (Exception E){
            JOptionPane.showMessageDialog(null, "Error! Score not saved :(");
        }
    }

    /**
     * Starts up various functions for the beginning of the game
     * @param userName Name of Player
     * @param level Level chosen by player
     * @param stage Chosen stage in which game stakes place
     */
    public void start(String userName, Stage stage, int level) {
		background.playMusic();
        createTimer(userName, stage, level);
        timer.start();
    }

    /**
     * Stops the timer function for the end of the game
     * @param stage Stage where game is taking place
     */
    public static void finalStop(Stage stage) {
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

    /**
     * Getter for timer
     * @return timer
     */
    public static AnimationTimer getTimer() {
        return timer;
    }

    /**
     * Getter for pauseGame boolean
     * @return pauseGame boolean
     */
    public static boolean getPauseGame() {
        return pauseGame;
    }

    /**
     * Setter for pauseGame boolean
     * @param pauseGame Either true or false should be assigned
     */
    public static void setPauseGame(boolean pauseGame) {
        Game.pauseGame = pauseGame;
    }

    /**
     * Getter for powerUp boolean
     * @return powerUp boolean
     */
    public static boolean isPowerUp() {
        return powerUp;
    }

    /**
     * Setter for powerUp boolean
     * @param powerUp Either true or false should be assigned
     */
    public static void setPowerUp(boolean powerUp) {
        Game.powerUp = powerUp;
    }
}