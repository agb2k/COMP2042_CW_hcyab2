package Model;

import javafx.scene.Scene;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BackgroundImageTest {

    Stage game = new Stage();
    MyStage backgroundTest = new MyStage();
    Scene sceneTest  = new Scene(backgroundTest,600,800);
    BackgroundImage bgTest = new BackgroundImage("file:src/main/resources/Images/GameBackground.png");
    @Test
    public void bgImgTest(){
        backgroundTest.add(bgTest);
        game.setScene(sceneTest);
        game.show();
        assertEquals(857, bgTest.getHeight());
    }

}