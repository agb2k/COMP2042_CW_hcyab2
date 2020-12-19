package Controller;

import Model.Actor.Frog;
import Model.Game;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;

//Subject

/**
 * Controller for the frog class
 */
public class FrogController {
    private final Frog frog;
    private int imgSize = 40;
    private final Image imgW1;
    private final Image imgA1;
    private final Image imgS1;
    private final Image imgD1;
    private final Image imgW2;
    private final Image imgA2;
    private final Image imgS2;
    private final Image imgD2;
    private boolean second = false;
    private final double movementX = 10.666666 * 2;


    /**
     * Constructor for the frog class
     * @param frog The frog being used in the game
     */
    public FrogController(Frog frog) {
        this.frog = frog;
        imgW1 = new Image("file:src/main/resources/Images/froggerUp.png", imgSize, imgSize, true, true);
        imgA1 = new Image("file:src/main/resources/Images/froggerLeft.png", imgSize, imgSize, true, true);
        imgS1 = new Image("file:src/main/resources/Images/froggerDown.png", imgSize, imgSize, true, true);
        imgD1 = new Image("file:src/main/resources/Images/froggerRight.png", imgSize, imgSize, true, true);
        imgW2 = new Image("file:src/main/resources/Images/froggerUpJump.png", imgSize, imgSize, true, true);
        imgA2 = new Image("file:src/main/resources/Images/froggerLeftJump.png", imgSize, imgSize, true, true);
        imgS2 = new Image("file:src/main/resources/Images/froggerDownJump.png", imgSize, imgSize, true, true);
        imgD2 = new Image("file:src/main/resources/Images/froggerRightJump.png", imgSize, imgSize, true, true);
    }

    /**
     * Checks if a button has been clicked and performs the corresponding actions
     */
    @SuppressWarnings("StatementWithEmptyBody")
    public void buttonClickCheck() {
        frog.setOnKeyPressed(event -> {
            if (Game.getPauseGame() || frog.isNoMove()) {
                //Do Nothing
            } else {
                if (second) {
                    if (event.getCode() == KeyCode.W) {
                        frog.move(0, -frog.getMovement());
                        frog.setChangeScore(false);
                        frog.setImage(imgW1);
                        second = false;
                    } else if (event.getCode() == KeyCode.A) {
                        frog.move(-movementX, 0);
                        frog.setImage(imgA1);
                        second = false;
                    } else if (event.getCode() == KeyCode.S) {
                        frog.move(0, frog.getMovement());
                        frog.setImage(imgS1);
                        second = false;
                    } else if (event.getCode() == KeyCode.D) {
                        frog.move(movementX, 0);
                        frog.setImage(imgD1);
                        second = false;
                    }
                } else if (event.getCode() == KeyCode.W) {
                    frog.move(0, -frog.getMovement());
                    frog.setImage(imgW2);
                    second = true;
                } else if (event.getCode() == KeyCode.A) {
                    frog.move(-movementX, 0);
                    frog.setImage(imgA2);
                    second = true;
                } else if (event.getCode() == KeyCode.S) {
                    frog.move(0, frog.getMovement());
                    frog.setImage(imgS2);
                    second = true;
                } else if (event.getCode() == KeyCode.D) {
                    frog.move(movementX, 0);
                    frog.setImage(imgD2);
                    second = true;
                }
            }
        });
        frog.setOnKeyReleased(event -> {
            if (Game.getPauseGame() || frog.isNoMove()) {
                //Do nothing
            } else {
                if (event.getCode() == KeyCode.W) {
                    if (frog.getY() < frog.getW()) {
                        frog.setChangeScore(true);
                        frog.setW(frog.getY());
                        frog.setPoints(frog.getPoints() + 10);
                        frog.setPointTally(frog.getPointTally() + 10);
                    }
                    frog.move(0, -frog.getMovement());
                    frog.setImage(imgW1);
                    second = false;
                } else if (event.getCode() == KeyCode.A) {
                    frog.move(-movementX, 0);
                    frog.setImage(imgA1);
                    second = false;
                } else if (event.getCode() == KeyCode.S) {
                    frog.move(0, frog.getMovement());
                    frog.setImage(imgS1);
                    second = false;
                } else if (event.getCode() == KeyCode.D) {
                    frog.move(movementX, 0);
                    frog.setImage(imgD1);
                    second = false;
                }
            }
        });
    }
}