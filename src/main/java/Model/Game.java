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

    static AnimationTimer timer;
    final MyStage background;
    final Frog frog;
    static boolean pauseGame = false;


    /**
     * Creates the stage, scene and adds items to it
     * @param userName Name of the user which is entered right before the game
     * @param level Game level
     */
    public Game(String userName, int level){
        deleteScores("src/main/resources/Misc/roundScore.csv");
        Stage game = new Stage();
        background = new MyStage();
        Scene scene2  = new Scene(background,600,800);
        background.autosize();

        AddObjects.game1(background, level);
        /**
         * Adds the frog to the game
         */
        frog = new Frog("file:src/main/resources/Images/froggerUp.png");
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
     */
    public void createTimer(String userName, Stage stage, int level) {
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
                    saveScore(userName, level , frog.getPoints(), "src/main/resources/Misc/Highscore.csv");
                    deleteScores("src/main/resources/Misc/roundScore.csv");

                    finalStop(stage);
                }
            }
        };
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
     * @param userName name of Player
     */
    public void start(String userName, Stage stage, int level) {
		background.playMusic();
        createTimer(userName, stage, level);
        timer.start();
    }

    /**
     * Stops the timer function for the end of the game
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
}