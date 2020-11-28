package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * This class is the Info Menu Controller
 */

public class InfoController implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("Info is now loaded!");
    }

    public void BackToMainMenuClicked(ActionEvent event) throws IOException {
        Parent mainParent = FXMLLoader.load(getClass().getResource("/View/Menu.fxml"));
        Scene mainScene = new Scene(mainParent);

        Stage mainWindow = (Stage) ((Node) event.getSource()).getScene().getWindow();

        mainWindow.setScene(mainScene);
        mainWindow.show();
    }
}
