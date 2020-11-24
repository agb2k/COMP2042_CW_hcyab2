package p4_group_8_repo;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;



public class Main extends Application {
	Scene scene1;
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		Parent root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
		scene1 = new Scene(root);

		primaryStage.setScene(scene1);
		primaryStage.setTitle("Frogger");
		primaryStage.show();
	}

}