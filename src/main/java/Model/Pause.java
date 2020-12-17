package Model;

import javafx.scene.image.Image;

/**
 * Pause class for the pause button in the game
 */
public class Pause extends Actor{
    private final Image pause;
    private final Image play;
    private boolean second = false;
    private static double temp;
    @Override
    public void act(long now) {

    }

    /**
     * Adds the pause button to the game
     * @param dim Size of pause button image
     * @param x x coordinate of placement of pause button
     * @param y y coordinate of placement of pause button
     */
    public Pause(int dim, int x, int y){

        pause = new Image("file:src/main/resources/Images/pause.png", dim, dim, true, true);
        play = new Image("file:src/main/resources/Images/play.png", dim, dim, true, true);
        setImage(pause);
        setX(x);
        setY(y);

        setOnMouseClicked(
                event ->{
                    if(second){
                        AddObjects.setSpeedFactor(temp);
                        setImage(pause);
                        second = false;
                        Game.setPauseGame(false);
                    }else{
                        temp = AddObjects.getSpeedFactor();
                        AddObjects.setSpeedFactor(0);
                        setImage(play);
                        second = true;
                        Game.setPauseGame(true);
                    }
                }
        );
    }
}
