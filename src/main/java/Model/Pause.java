package Model;

import javafx.scene.image.Image;

public class Pause extends Actor{
    final Image pause;
    final Image play;
    boolean second = false;
    static double temp;
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
                        AddObjects.speedFactor = temp;
                        setImage(pause);
                        second = false;
                        System.out.println(AddObjects.speedFactor);
                        Game.pauseGame = false;
                    }else{
                        temp = AddObjects.speedFactor;
                        AddObjects.speedFactor = 0;
                        setImage(play);
                        second = true;
                        System.out.println(AddObjects.speedFactor);
                        Game.pauseGame = true;
                    }
                }
        );
    }
}
