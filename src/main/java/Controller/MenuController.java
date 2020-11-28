package Controller;

import Model.Game;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * This class is the Menu Controller
 */


public class MenuController implements Initializable {

    public Button startButton;
    public Button infoButton;
    public Button highScoreButton;
    private String username;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("View is now loaded!");
    }

    public void startButtonClicked(ActionEvent event){
        username = JOptionPane.showInputDialog("Please enter your name:");
        System.out.println("Hi " + username);
        new Game(username);
    }



    public void infoButtonClicked(ActionEvent event) throws IOException {
        Parent infoParent = FXMLLoader.load(getClass().getResource("/View/Info.fxml"));
        Scene infoScene = new Scene(infoParent);

        Stage infoWindow = (Stage)((Node)event.getSource()).getScene().getWindow();

        infoWindow.setScene(infoScene);
        infoWindow.show();
    }

    public void highScoreButtonClicked(ActionEvent event) throws IOException {
        Parent highscoreParent = FXMLLoader.load(getClass().getResource("/View/Highscore.fxml"));
        Scene highscoreScene = new Scene(highscoreParent);

        Stage highscoreWindow = (Stage)((Node)event.getSource()).getScene().getWindow();

        highscoreWindow.setScene(highscoreScene);
        highscoreWindow.show();
    }

}