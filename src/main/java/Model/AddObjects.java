package Model;

/**
 * The type AddObjects which adds all the objects to the game
 */

public class AddObjects {

    /**
     * Used to calculate the speed of the obstacles in the game
     */
    private static double speedFactor;

    public AddObjects() {
    }

    public static void game1(MyStage background, int level){

        //1-3
        speedFactor = 0.2 + (level*0.2);
        //4-7
        if (3<level && level<8){
            speedFactor = level/4;
        }
        addBackgroundImg(background);
        addLogs(background);
        addTurtles(background);
        addEnds(background);
        addPowerUps(background);


        /**
         * Adds the initial score to the game
         */
        background.add(new Digit(0, 30, 100, 50));

        /**
         * Adds a mute button to the game
         */
        background.add(new Mute(background,45,450,40));

        /**
         * Adds a play/pause button to the game
         */
        background.add(new Pause(35, 500, 45));

        /**
         * Adds stop button to game
         */
        background.add(new Stop(32, 550, 47));

        /**
         * Adds life display
         */
//        addLives(background, frog);

        if(level == 1 || level == 2 || level == 3){
            addCarsEasy(background);
        }
        else if(level == 4 || level == 5){
            addCars(background);
            addMinotaurs(background);

        }

        System.out.println(speedFactor);
    }

    /**
     * Adds Minotaurs
     */
    private static void addMinotaurs(MyStage background){
        background.add(new Minotaur(100, 480, 2.5*speedFactor, 70, 70));
        background.add(new Minotaur(250, 480, 2.5*speedFactor, 70, 70));
        background.add(new Minotaur(400, 480, 2.5*speedFactor, 70, 70));
        background.add(new Minotaur(550, 480, 2.5*speedFactor, 70, 70));
    }

    /**
     * Add life count
     * @param background Background to add the lives
     */
    private static void addLives(MyStage background){
        Lives life1, life2, life3, life4, life5;
        background.add(life1 = new Lives(30, 200, 50));
        background.add(life2 = new Lives(30, 235, 50));
        background.add(life3 = new Lives(30, 270, 50));
        background.add(life4 = new Lives(30, 305, 50));
        background.add(life5 = new Lives(30, 340, 50));
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
    }

    /**
     * Adds the easier obstacles (vehicles) to the game
     * @param background Background to add vehicles/obstacles
     */
    private static void addCarsEasy(MyStage background) {
        background.add(new Obstacle("file:src/main/resources/Images/truck1"+"Right.png", 0, 649, 1*speedFactor, 120, 120));
        background.add(new Obstacle("file:src/main/resources/Images/truck1"+"Right.png", 300, 649, 1*speedFactor, 120, 120));
        background.add(new Obstacle("file:src/main/resources/Images/truck1"+"Right.png", 600, 649, 1*speedFactor, 120, 120));
        background.add(new Obstacle("file:src/main/resources/Images/car1Left.png", 100, 597, -1*speedFactor, 50, 50));
        background.add(new Obstacle("file:src/main/resources/Images/car1Left.png", 400, 597, -1*speedFactor, 50, 50));
        background.add(new Obstacle("file:src/main/resources/Images/truck2Right.png", 500, 540, 1*speedFactor, 200, 200));

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

    private static  void  addPowerUps(MyStage background){

        background.add(new PowerUp( 40, 0, 166, 0.75*speedFactor, 2000));
        background.add(new PowerUp( 40, 440, 166, 0.75*speedFactor,7000));
        background.add(new PowerUp( 40, 50, 329, 0.75*speedFactor,10000));
        background.add(new PowerUp(40, 490, 329, 0.75*speedFactor,10000));
    }

    /**
     * Getter for speedFactor
     * @return speedFactor
     */
    public static double getSpeedFactor() {
        return speedFactor;
    }

    /**
     * Setter for speedFactor
     * @param speedFactor Value to assign to speedFactor
     */
    public static void setSpeedFactor(double speedFactor) {
        AddObjects.speedFactor = speedFactor;
    }


}
