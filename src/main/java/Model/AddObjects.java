package Model;

/**
 * The type AddObjects which adds all the objects to the game
 */

public class AddObjects {

    /**
     * Used to calculate the speed of the obstacles in the game
     */
    static double speedFactor;


    public static void game1(MyStage background, int level){

        speedFactor = level*0.5;


        addBackgroundImg(background);

        addLogs(background);
        addTurtles(background);
        addEnds(background);
        addCars(background);
        /**
         * Adds the initial score to the game
         */
        background.add(new Digit(0, 30, 100, 50));

        /**
         * Adds a mute button to the game
         */
        background.add(new Mute(background,45,500,40));

        /**
         * Adds a play/pause button to the game
         */
        background.add(new Pause(35, 550, 45));
    }

    /**
     * Adds the background image for the game
     * @param background Background to add the image
     */
    private static void addBackgroundImg(MyStage background) {
        BackgroundImage froggerback = new BackgroundImage("file:src/main/resources/Images/GameBackground.png");
        background.add(froggerback);
    }

    /**
     * Adds the obstacles (vehicles) to the game
     * @param background Background to add vehicles/obstacles
     */
    private static void addCars(MyStage background) {
        background.add(new Obstacle("file:src/main/resources/Images/truck1"+"Right.png", 0, 649, 1*speedFactor, 120, 120));
        background.add(new Obstacle("file:src/main/resources/Images/truck1"+"Right.png", 300, 649, 1*speedFactor, 120, 120));
        background.add(new Obstacle("file:src/main/resources/Images/truck1"+"Right.png", 600, 649, 1*speedFactor, 120, 120));
        background.add(new Obstacle("file:src/main/resources/Images/car1Left.png", 100, 597, -1*speedFactor, 50, 50));
        background.add(new Obstacle("file:src/main/resources/Images/car1Left.png", 250, 597, -1*speedFactor, 50, 50));
        background.add(new Obstacle("file:src/main/resources/Images/car1Left.png", 400, 597, -1*speedFactor, 50, 50));
        background.add(new Obstacle("file:src/main/resources/Images/car1Left.png", 550, 597, -1*speedFactor, 50, 50));
        background.add(new Obstacle("file:src/main/resources/Images/truck2Right.png", 0, 540, 1*speedFactor, 200, 200));
        background.add(new Obstacle("file:src/main/resources/Images/truck2Right.png", 500, 540, 1*speedFactor, 200, 200));
        background.add(new Obstacle("file:src/main/resources/Images/car1Left.png", 500, 490, -5*speedFactor, 50, 50));
    }

    /**
     * Adds the end check point to the game
     * @param background Background to add end points
     */
    private static void addEnds(MyStage background) {
        background.add(new End(13,96));
        background.add(new End(141,96));
        background.add(new End(141 + 141-13,96));
        background.add(new End(141 + 141-13+141-13+1,96));
        background.add(new End(141 + 141-13+141-13+141-13+3,96));
    }

    /**
     * Adds the turtles to the game
     * @param background Background to add turtles and wet turtles
     */
    private static void addTurtles(MyStage background) {
        background.add(new Turtle(500, 376, -1*speedFactor, 130, 130));
        background.add(new Turtle(300, 376, -1*speedFactor, 130, 130));
        background.add(new WetTurtle(700, 376, -1*speedFactor, 130, 130));
        background.add(new WetTurtle(600, 217, -1*speedFactor, 130, 130));
        background.add(new WetTurtle(400, 217, -1*speedFactor, 130, 130));
        background.add(new WetTurtle(200, 217, -1*speedFactor, 130, 130));
    }

    /**
     * Adds the logs to the game
     * @param background Background to add logs
     */
    private static void addLogs(MyStage background) {
        background.add(new Log("file:src/main/resources/Images/log3.png", 150, 0, 166, 0.75*speedFactor));
        background.add(new Log("file:src/main/resources/Images/log3.png", 150, 220, 166, 0.75*speedFactor));
        background.add(new Log("file:src/main/resources/Images/log3.png", 150, 440, 166, 0.75*speedFactor));
        background.add(new Log("file:src/main/resources/Images/logs.png", 300, 0, 276, -2*speedFactor));
        background.add(new Log("file:src/main/resources/Images/logs.png", 300, 400, 276, -2*speedFactor));
        background.add(new Log("file:src/main/resources/Images/log3.png", 150, 50, 329, 0.75*speedFactor));
        background.add(new Log("file:src/main/resources/Images/log3.png", 150, 270, 329, 0.75*speedFactor));
        background.add(new Log("file:src/main/resources/Images/log3.png", 150, 490, 329, 0.75*speedFactor));
    }


}
