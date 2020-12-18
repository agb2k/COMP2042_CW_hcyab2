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
import javafx.scene.control.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

/**
 * This class is the Menu Controller
 */


public class MenuController implements Initializable {

    @FXML
    private Button startButton;

    @FXML
    private ChoiceBox<String> levelSelector;

    private MediaPlayer mediaPlayer;

    final ObservableList list = FXCollections.observableArrayList();


    /**
     * Initializes the .fxml scene
     * @param location File path of. fxml file
     * @param resources Type of object
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        playMusic();
        loadData();
        System.out.println("View is now loaded!");
    }

    /**
     * Plays music
     */
    public void playMusic() {
        String musicFile = "src/main/resources/Music/Frogger Main Song Theme (loop).mp3";
        Media sound = new Media(new File(musicFile).toURI().toString());
        mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayer.play();
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
        String f = "Level 6";
        String g = "Level 7";
        String h = "Level 8";
        String i = "Level 9";
        String j = "Level 10";
        list.addAll(a,b,c,d,e,f,g,h,i,j);
        levelSelector.getItems().addAll(list);
        levelSelector.setValue(a);
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
        System.exit(0);
    }

    /**
     * Actions taking place when start button is clicked
     */
    public void startButtonClicked(){
        mediaPlayer.stop();
        String username = null;
        Game.setPauseGame(false);
        Game.setPowerUp(false);
        TextInputDialog dialog = new TextInputDialog();
        dialog.initStyle(StageStyle.UTILITY);
        dialog.setTitle(null);
        dialog.setHeaderText(null);
        dialog.setContentText("Please enter your name:");
        Optional<String> result = dialog.showAndWait();

        if (result.isPresent()){
            username=result.get();
        }
        if(username == null){
            //Do Nothing
        }else {
            String levelStr = levelSelector.getValue();
            int levelNum = Integer.parseInt(levelStr.replaceAll("[^0-9]", ""));
            new Game(username, levelNum);
        }

    }

    /**
     * Actions taking place when info button is clicked
     * @param event Info button is clicked
     * @throws IOException Checks for errors
     */
    public void infoButtonClicked(ActionEvent event) throws IOException {
        mediaPlayer.stop();
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
        mediaPlayer.stop();
        Parent highscoreParent = FXMLLoader.load(getClass().getResource("/View/Highscore.fxml"));
        Scene highscoreScene = new Scene(highscoreParent);

        Stage highscoreWindow = (Stage)((Node)event.getSource()).getScene().getWindow();

        highscoreWindow.setScene(highscoreScene);
        highscoreWindow.show();
    }
}