package Model;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.stage.StageStyle;
import java.util.Optional;

public class Stop extends Actor{
    private final Image stop;
    @Override
    public void act(long now) {

    }

    /**
     * Adds the stop button to the game
     * @param dim Size of stop button image
     * @param x x coordinate of placement of stop button
     * @param y y coordinate of placement of stop button
     */
    public Stop(int dim, int x, int y){

        stop = new Image("file:src/main/resources/Images/stop.png", dim, dim, true, true);
        setImage(stop);
        setX(x);
        setY(y);

        setOnMouseClicked(
                event ->{
                    Alert conf = new Alert(Alert.AlertType.CONFIRMATION);
                    conf.initStyle(StageStyle.UTILITY);
                    conf.setHeaderText(null);
                    conf.setContentText("Are you sure?");
                    Optional <ButtonType> action = conf.showAndWait();
                    if(action.get() == ButtonType.OK){
                        Frog.setUserStop(true);
                    }
                }
        );
    }
}
