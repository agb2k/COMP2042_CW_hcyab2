package Model;

import javafx.scene.image.Image;

public class Mute extends Actor{
    final Image mute;
    final Image unmute;
    boolean second = false;
    @Override
    public void act(long now) {

    }

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
