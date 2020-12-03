package Controller;

import Model.RoundScore;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;


public class RoundScoreController implements Initializable {

    @FXML
    private TableView<RoundScore> table;

    @FXML
    private TableColumn<RoundScore, String> roundColumn;

    @FXML
    private TableColumn<RoundScore, Integer> scoreColumn;

    @FXML
    private Button backButton;

    final String fileName = "src/main/resources/Misc/roundScore.csv";
    final File file = new File(fileName);

    final ObservableList<RoundScore> RoundScoreList = FXCollections.observableArrayList();

    public void initList(){
        try {
            Scanner inputStream = new Scanner(file);
            while ((inputStream.hasNext())){
                String data = inputStream.next();
                String[] scores = data.split(",");
                RoundScoreList.add(new RoundScore(scores[0],Integer.parseInt(scores[1])));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initList();
        roundColumn.setCellValueFactory(new PropertyValueFactory<>("roundColumn"));
        scoreColumn.setCellValueFactory(new PropertyValueFactory<>("scoreColumn"));
        table.setItems(RoundScoreList);
        table.getSortOrder().add(scoreColumn);
    }

    @FXML
    void backButtonClicked() {
        Stage stage = (Stage) backButton.getScene().getWindow();
        stage.close();
    }
}
