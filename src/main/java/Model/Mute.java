package Model;

import javafx.scene.image.Image;

/**
 * Mute class used to create a mute button in the game
 */
public class Mute extends Actor{
    private final Image mute;
    private final Image unmute;
    private boolean second = false;
    @Override
    public void act(long now) {

    }

    /**
     * Sets up functioning mute button for Stage
     * @param stage Stage in which the mute button will be added
     * @param dim Dimension required (Will scale according to image in this case)
     * @param x x coordinate to be placed
     * @param y y coordinate to be placed
     */
    public Mute(MyStage stage, int dim, int x, int y){
        mute = new Image("file:src/main/resources/Images/mute.png", dim, dim, true, true);
        unmute = new Image("file:src/main/resources/Images/unmute.png", dim, dim, true, true);
        setImage(mute);
        setX(x);
        setY(y);

        setOnMouseClicked(
                event ->{
                    if(second){
                        stage.playMusic();
                        setImage(mute);
                        second = false;
                    }else{
                        stage.stopMusic();
                        setImage(unmute);
                        second = true;
                    }
                }
        );
    }
}
