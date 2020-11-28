import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


/**
 * Main class to load up main menu
 * @author Abhinav George Basil (hcyab2) (20205163)
 */

public class Main extends Application {
	Scene scene1;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		Parent root = FXMLLoader.load(getClass().getResource("/View/Menu.fxml"));
		scene1 = new Scene(root);

		primaryStage.setScene(scene1);
		primaryStage.setTitle("Frogger");
		primaryStage.show();
	}

}