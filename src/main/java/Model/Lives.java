package Model;

import javafx.scene.image.Image;

import java.util.Optional;

public class Lives extends Actor{
    private final Image life;
    @Override
    public void act(long now) {

    }

    /**
     * Adds the stop button to the game
     * @param dim Size of stop button image
     * @param x x coordinate of placement of stop button
     * @param y y coordinate of placement of stop button
     */
    public Lives(int dim, int x, int y){

        life = new Image("file:src/main/resources/Images/icon-frogger-pixel-512x512.png", dim, dim, true, true);
        setImage(life);
        setX(x);
        setY(y);

    }
}
