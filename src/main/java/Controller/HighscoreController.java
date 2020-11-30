package Controller;

import Model.Highscore;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

/**
 * This class is the High Score Menu Controller
 */

public class HighscoreController implements Initializable {

    public TableView<Highscore> table;
    public TableColumn<Highscore, String> nameColumn;
    public TableColumn<Highscore, Integer> scoreColumn;
    public Button backToMainMenu;

    String fileName = "src/main/resources/Misc/Highscore.csv";
    File file = new File(fileName);

    ObservableList<Highscore> list = FXCollections.observableArrayList();

    public void initList(){
        try {
            Scanner inputStream = new Scanner(file);
            while ((inputStream.hasNext())){
                String data = inputStream.next();
                String[] values_line = data.split(",");
                list.add(new Highscore(values_line[0],Integer.valueOf(values_line[1])));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initList();
        nameColumn.setCellValueFactory(new PropertyValueFactory<Highscore, String>("nameColumn"));
        scoreColumn.setCellValueFactory(new PropertyValueFactory<Highscore, Integer>("scoreColumn"));
        table.setItems(list);
        table.getSortOrder().add(scoreColumn);
    }

    public void BackClicked(ActionEvent event) throws IOException {
        Parent mainParent = FXMLLoader.load(getClass().getResource("/View/Menu.fxml"));
        Scene mainScene = new Scene(mainParent);

        Stage mainWindow = (Stage) ((Node) event.getSource()).getScene().getWindow();

        mainWindow.setScene(mainScene);
        mainWindow.show();
    }
}
