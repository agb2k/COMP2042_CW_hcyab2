package Model.Actor;

import javafx.scene.image.Image;

/**
 * The lives class used to show to lives of the frog
 */
public class Lives extends Actor{
    private final Image life1;
    private final Image life2;
    private final Image life3;
    private final Image life4;
    private int count = 4;

    /**
     * Performs the actions for the Lives class
     * @param now Current time
     */
    @Override
    public void act(long now) {
        if(Frog.isChangeLife() && count ==4){
            setImage(life4);
            Frog.setChangeLife(false);
            count--;
        }
        if(Frog.isChangeLife() && count ==3){
            setImage(life3);
            Frog.setChangeLife(false);
            count--;
        }
        if(Frog.isChangeLife() && count ==2){
            setImage(life2);
            Frog.setChangeLife(false);
            count--;
        }
        if(Frog.isChangeLife() && count ==1) {
            setImage(life1);
            Frog.setChangeLife(false);
            count--;
        }
    }

    /**
     * Adds the lives to the game
     * @param x x coordinate of placement of stop button
     * @param y y coordinate of placement of stop button
     */
    public Lives( int x, int y){

        life1 = new Image("file:src/main/resources/Images/lives.png", 0, 34, true, true);
        life2 = new Image("file:src/main/resources/Images/lives2.png", 0, 34, true, true);
        life3 = new Image("file:src/main/resources/Images/lives3.png", 0, 34, true, true);
        life4 = new Image("file:src/main/resources/Images/lives4.png", 0,34, true, true);
        Image life5 = new Image("file:src/main/resources/Images/lives5.png", 0, 34, true, true);

        setImage(life5);
        setX(x);
        setY(y);


    }
}
