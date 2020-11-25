import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class MenuController implements Initializable {

    public Button startButton;
    public Button infoButton;
    public Button highScoreButton;



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("View is now loaded!");
    }
    public void startButtonClicked(ActionEvent event){
        new Game();
    }

    public void infoButtonClicked(ActionEvent event) throws IOException {
        Parent infoParent = FXMLLoader.load(getClass().getResource("/Info.fxml"));
        Scene infoScene = new Scene(infoParent);

        Stage infoWindow = (Stage)((Node)event.getSource()).getScene().getWindow();

        infoWindow.setScene(infoScene);
        infoWindow.show();
    }

    public void highScoreButtonClicked(){
//        highScoreButton.setOnAction(FXMLLoader.load(getClass().getResource("Menu.fxml")));
    }

}