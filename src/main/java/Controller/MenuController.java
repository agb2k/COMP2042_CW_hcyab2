package Controller;

import Model.Game;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * This class is the Menu Controller
 */


public class MenuController implements Initializable {

    @FXML
    private Button startButton;

    @FXML
    private Button infoButton;

    @FXML
    private Button highScoreButton;

    @FXML
    private Button exitButton;

    @FXML
    private ChoiceBox<String> levelSelector;

    ObservableList list = FXCollections.observableArrayList();


    /**
     * Initializes the .fxml scene
     * @param location File path of. fxml file
     * @param resources Type of object
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadData();
        System.out.println("View is now loaded!");
    }

    /**
     * Loads data into list
     */
    public void loadData(){
        list.removeAll(list);
        String a = "Level 1";
        String b = "Level 2";
        String c = "Level 3";
        String d = "Level 4";
        String e = "Level 5";
        list.addAll(a,b,c,d,e);
        levelSelector.getItems().addAll(list);
    }


    /**
     * Actions taking place when exit button is clicked
     * @param event Exit button is clicked
     */
    @FXML
    void exitButtonClicked(ActionEvent event) {
        Node node = (Node) event.getSource();
        Stage thisStage = (Stage) node.getScene().getWindow();
        thisStage.close();
    }

    /**
     * Actions taking place when start button is clicked
     */
    public void startButtonClicked(){
        Game.setPauseGame(false);
        String username = JOptionPane.showInputDialog("Please enter your name:");
        if((levelSelector.getValue()) == "Level 1"){
            new Game(username, 1);
        }
        else if((levelSelector.getValue()) == "Level 2"){
            new Game(username, 2);
        }
        else if((levelSelector.getValue()) == "Level 3"){
            new Game(username, 3);
        }
        else if((levelSelector.getValue()) == "Level 4"){
            new Game(username, 4);
        }
        else if((levelSelector.getValue()) == "Level 5"){
            new Game(username, 5);
        }
        else {
            System.out.println("Choose another level");
        }

    }

    /**
     * Actions taking place when info button is clicked
     * @param event Info button is clicked
     * @throws IOException Checks for errors
     */
    public void infoButtonClicked(ActionEvent event) throws IOException {
        Parent infoParent = FXMLLoader.load(getClass().getResource("/View/Info.fxml"));
        Scene infoScene = new Scene(infoParent);

        Stage infoWindow = new Stage();

        infoWindow.initStyle(StageStyle.UNDECORATED);
        infoWindow = (Stage)((Node)event.getSource()).getScene().getWindow();
        infoWindow.setScene(infoScene);
        infoWindow.show();
    }

    /**
     * Actions taking place when high score button is clicked
     * @param event High score button is clicked
     * @throws IOException Checks for errors
     */
    public void highScoreButtonClicked(ActionEvent event) throws IOException {
        Parent highscoreParent = FXMLLoader.load(getClass().getResource("/View/Highscore.fxml"));
        Scene highscoreScene = new Scene(highscoreParent);

        Stage highscoreWindow = (Stage)((Node)event.getSource()).getScene().getWindow();

        highscoreWindow.setScene(highscoreScene);
        highscoreWindow.show();
    }
}