package Model;

import javafx.scene.image.Image;

public class Pause extends Actor{
    final Image pause;
    final Image play;
    boolean second = false;
    @Override
    public void act(long now) {

    }

    public Pause(MyStage stage, int dim, int x, int y){
        pause = new Image("file:src/main/resources/Images/pause.png", dim, dim, true, true);
        play = new Image("file:src/main/resources/Images/play.png", dim, dim, true, true);
        setImage(pause);
        setX(x);
        setY(y);

        setOnMouseClicked(
                event ->{
                    if(second){
                        stage.playMusic();
                        setImage(play);
                        second = false;
                    }else{
                        stage.stopMusic();
                        setImage(pause);
                        second = true;
                    }
                }
        );
    }
}
