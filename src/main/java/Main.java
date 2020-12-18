import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


/**
 * Main class to load up main menu
 * @author Abhinav George Basil (hcyab2) (20205163)
 */

public class Main extends Application {

    /**
	 * Main method
	 * @param args String array
	 */
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		Parent root = FXMLLoader.load(getClass().getResource("/View/Menu.fxml"));
        Scene scene1 = new Scene(root);

		primaryStage.initStyle(StageStyle.UNDECORATED);
		primaryStage.setScene(scene1);
		primaryStage.setTitle("Frogger");
		primaryStage.show();
	}
}