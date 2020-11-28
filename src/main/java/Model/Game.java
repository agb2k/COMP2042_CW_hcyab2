package Model;

import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;

/**
 * This class contains the game itself
 */

public class Game{

    AnimationTimer timer;
    MyStage background;
    Animal animal;


    public Game(String userName){
        Stage game = new Stage();

        background = new MyStage();
        Scene scene2  = new Scene(background,600,700);

        //Changed the source of the image so the background image appears
        BackgroundImage froggerback = new BackgroundImage("file:src/main/resources/Images/iKogsKW.png");
//      Adds background image
        background.add(froggerback);
//      First layer of logs from top
        background.add(new Log("file:src/main/resources/Images/log3.png", 150, 0, 166, 0.75));
        background.add(new Log("file:src/main/resources/Images/log3.png", 150, 220, 166, 0.75));
        background.add(new Log("file:src/main/resources/Images/log3.png", 150, 440, 166, 0.75));
//        2nd Layer of logs from top
        background.add(new Log("file:src/main/resources/Images/logs.png", 300, 0, 276, -2));
        background.add(new Log("file:src/main/resources/Images/logs.png", 300, 400, 276, -2));
//        3rd layer of logs from top
        background.add(new Log("file:src/main/resources/Images/log3.png", 150, 50, 329, 0.75));
        background.add(new Log("file:src/main/resources/Images/log3.png", 150, 270, 329, 0.75));
        background.add(new Log("file:src/main/resources/Images/log3.png", 150, 490, 329, 0.75));

        background.add(new Turtle(500, 376, -1, 130, 130));
        background.add(new Turtle(300, 376, -1, 130, 130));
        background.add(new WetTurtle(700, 376, -1, 130, 130));
        background.add(new WetTurtle(600, 217, -1, 130, 130));
        background.add(new WetTurtle(400, 217, -1, 130, 130));
        background.add(new WetTurtle(200, 217, -1, 130, 130));

        background.add(new End(13,96));
        background.add(new End(141,96));
        background.add(new End(141 + 141-13,96));
        background.add(new End(141 + 141-13+141-13+1,96));
        background.add(new End(141 + 141-13+141-13+141-13+3,96));

        animal = new Animal("file:src/main/resources/Images/froggerUp.png");
        background.add(animal);

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
        background.add(new Digit(0, 30, 360, 25));
        background.start();
        game.setScene(scene2);
        game.show();
        start(userName);
    }

    public void createTimer(String userName) {
        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                if (animal.changeScore()) {
                    setNumber(animal.getPoints());
                }
                if (animal.getStop()) {
                    System.out.print("STOP:");
                    background.stopMusic();
                    stop();
                    background.stop();

                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("You Have Won The Game!");
                    alert.setHeaderText("Your Score: "+animal.getPoints()+"!");
                    alert.setContentText("Highest Possible Score: 800");
                    alert.show();

                    String filepath = "src/main/resources/Misc/Highscore.csv";
                    saveScore(userName, animal.getPoints(), filepath);

                }
            }
        };
    }

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

    public void start(String userName) {
		background.playMusic();
        createTimer(userName);
        timer.start();
    }

    public void stop() {
        timer.stop();
    }

    public void setNumber(int n) {
        int shift = 0;
        while (n > 0) {
            int d = n / 10;
            int k = n - d * 10;
            n = d;
            background.add(new Digit(k, 30, 360 - shift, 25));
            shift+=30;
        }
    }
}