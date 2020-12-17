package Model;

/**
 * The type AddObjects which adds all the objects to the game
 */

public class AddObjects {

    /**
     * Used to calculate the speed of the obstacles in the game
     */
    private static double speedFactor;

    /**
     * Default constructor
     */
    public AddObjects() {
    }

    /**
     * Adds the objects to the game
     * @param background Type MyStage
     * @param level Integer input which represents the level of the game
     */
    public static void AddGameObjects(MyStage background, int level){
        ActorFactory af = new ActorFactory();

        /**
         * Configuring speed factor based on level
         */
        if (level <= 3 && level>=1) {
            speedFactor = 0.2 + (level*0.2);
        }
        else if (level>=4 && level<=7){
            speedFactor = (double)level/5;
        }
        else if (level>=8 && level<=10){
            speedFactor = ((((double) level)-1)/5)+(0.2*(level-7));
        }

        addBackgroundImg(background);
        addLogs(background);
        addTurtles(background);
        addEnds(background);
        addVehicles(background, level);


        /**
         * Adds the initial score to the game
         */
//        background.add(new Digit(0, 30, 100, 50));
        background.add(af.getInstance("Digit", background, 100, 50, 0));

        /**
         * Adds a mute button to the game
         */
//        background.add(new Mute(background,45,450,40));
        background.add(af.getInstance("Mute", background, 450, 40, 0));

        /**
         * Adds a play/pause button to the game
         */
//        background.add(new Pause(35, 500, 45));
        background.add(af.getInstance("Pause", background, 500, 45, 0));

        /**
         * Adds stop button to game
         */
//        background.add(new Stop(32, 550, 47));
        background.add(af.getInstance("Stop", background, 550, 47, 0));

        /**
         * Adds life display
         */
//        background.add(new Lives(200, 50));
        background.add(af.getInstance("Lives", background, 200, 50, 0));

        /**
         * Configures map based on level choice
         */
        if(level >= 4){
            addMinotaurs(background);
//            background.add(new PowerUp( 40,0.75*speedFactor));
            background.add(af.getInstance("PowerUp", background, 0,0,0.75*speedFactor));
        }

        if(level >= 6){
            addDragons(background);
        }

        if(level >= 9){
            addSkeletons(background);
        }

        System.out.println(speedFactor);
    }

    /**
     * Adds skeletons
     * @param background Game background
     */
    private static void addSkeletons(MyStage background){
        ActorFactory af = new ActorFactory();
        background.add(af.getInstance("Skeleton", background, 100, 590, -1*speedFactor));
        background.add(af.getInstance("Skeleton", background, 250, 590, -1*speedFactor));
        background.add(af.getInstance("Skeleton", background, 400, 590, -1*speedFactor));
        background.add(af.getInstance("Skeleton", background, 550, 590, -1*speedFactor));
//        background.add(new Skeleton(100, 590, -1*speedFactor, 70, 70));
//        background.add(new Skeleton(250, 590, -1*speedFactor, 70, 70));
//        background.add(new Skeleton(400, 590, -1*speedFactor, 70, 70));
//        background.add(new Skeleton(550, 590, -1*speedFactor, 70, 70));
    }

    /**
     * Adds dragons
     * @param background Game background
     */
    private static void addDragons(MyStage background){
        ActorFactory af = new ActorFactory();
        background.add(af.getInstance("Dragon", background, 100, 425, 1*speedFactor));
        background.add(af.getInstance("Dragon", background, 550, 425, 1*speedFactor));
//        background.add(new Dragon( 100, 425, 1*speedFactor, 70, 70));
//        background.add(new Dragon( 550, 425, 1*speedFactor, 70, 70));
    }
    /**
     * Adds Minotaurs
     * @param background Game background
     */
    private static void addMinotaurs(MyStage background){
        ActorFactory af = new ActorFactory();
        background.add(af.getInstance("Minotaur", background, 100, 480, -2*speedFactor));
        background.add(af.getInstance("Minotaur", background, 300, 480, -2*speedFactor));
        background.add(af.getInstance("Minotaur", background, 500, 480, -2*speedFactor));

//        background.add(new Minotaur(100, 480, -2*speedFactor, 70, 70));
//        background.add(new Minotaur(300, 480, -2*speedFactor, 70, 70));
//        background.add(new Minotaur(500, 480, -2*speedFactor, 70, 70));
    }

    /**
     * Adds the background image for the game
     * @param background Background to add the image
     */
    private static void addBackgroundImg(MyStage background) {
//        BackgroundImage froggerback = new BackgroundImage("file:src/main/resources/Images/GameBackground.png");
//        background.add(froggerback);
        ActorFactory af = new ActorFactory();
        background.add(af.getInstance("BgImg", null, 0, 0, 0));
    }

    /**
     * Adds vehicles to background
     * @param background Game background
     * @param level Level chosen by user
     */
    private static void addVehicles(MyStage background, int level){
        ActorFactory af = new ActorFactory();
        background.add(af.getInstance("Truck1Right", background, 300, 649, 1*speedFactor));
        background.add(af.getInstance("Truck1Right", background, 0, 649, 1*speedFactor));
        background.add(af.getInstance("Truck1Right", background, 600, 649, 1*speedFactor));

        background.add(af.getInstance("Truck2Right", background, 0, 540, 1*speedFactor));
        background.add(af.getInstance("Truck2Right", background, 500, 540, 1*speedFactor));

//        background.add(new Vehicles("file:src/main/resources/Images/truck1"+"Right.png", 300, 649, 1*speedFactor, 120, 120));
//        background.add(new Vehicles("file:src/main/resources/Images/truck1"+"Right.png", 0, 649, 1*speedFactor, 120, 120));
//        background.add(new Vehicles("file:src/main/resources/Images/truck1"+"Right.png", 600, 649, 1*speedFactor, 120, 120));
//        background.add(new Vehicles("file:src/main/resources/Images/truck2Right.png", 0, 540, 1*speedFactor, 200, 200));
//        background.add(new Vehicles("file:src/main/resources/Images/truck2Right.png", 500, 540, 1*speedFactor, 200, 200));
        if(level <= 8){
            background.add(af.getInstance("Car1Left", background, 100, 597, -1*speedFactor));
            background.add(af.getInstance("Car1Left", background, 400, 597, -1*speedFactor));
//            background.add(new Vehicles("file:src/main/resources/Images/car1Left.png", 100, 597, -1*speedFactor, 50, 50));
//            background.add(new Vehicles("file:src/main/resources/Images/car1Left.png", 400, 597, -1*speedFactor, 50, 50));
            if(level <= 3){
                background.add(af.getInstance("Car1Left", background, 500, 490, -5*speedFactor));
//                background.add(new Vehicles("file:src/main/resources/Images/car1Left.png", 500, 490, -5*speedFactor, 50, 50));
            }
            else if(level <= 8 && level >= 3){
                background.add(af.getInstance("Car1Left", background, 250, 597, -1*speedFactor));
                background.add(af.getInstance("Car1Left", background, 550, 597, -1*speedFactor));
//                background.add(new Vehicles("file:src/main/resources/Images/car1Left.png", 250, 597, -1*speedFactor, 50, 50));
//                background.add(new Vehicles("file:src/main/resources/Images/car1Left.png", 550, 597, -1*speedFactor, 50, 50));
            }
        }
    }

    /**
     * Adds the end check point to the game
     * @param background Background to add end points
     */
    private static void addEnds(MyStage background) {
        ActorFactory af = new ActorFactory();
        background.add(af.getInstance("End", background, 13,96, 0));
        background.add(af.getInstance("End", background, 141,96, 0));
        background.add(af.getInstance("End", background, 141+141-13,96, 0));
        background.add(af.getInstance("End", background, 141+141-13+141-13+1,96, 0));
        background.add(af.getInstance("End", background, 141+141-13+141-13+141-13+3,96, 0));

//        background.add(new End(13,96));
//        background.add(new End(141,96));
//        background.add(new End(141 + 141-13,96));
//        background.add(new End(141 + 141-13+141-13+1,96));
//        background.add(new End(141 + 141-13+141-13+141-13+3,96));
    }

    /**
     * Adds the turtles to the game
     * @param background Background to add turtles and wet turtles
     */
    private static void addTurtles(MyStage background) {
        ActorFactory af = new ActorFactory();
        background.add(af.getInstance("Turtle", background, 500, 376, -1*speedFactor));
        background.add(af.getInstance("Turtle", background, 300, 376, -1*speedFactor));
        background.add(af.getInstance("WetTurtle", background, 700, 376, -1*speedFactor));
        background.add(af.getInstance("WetTurtle", background, 600, 217, -1*speedFactor));
        background.add(af.getInstance("WetTurtle", background, 400, 217, -1*speedFactor));
        background.add(af.getInstance("WetTurtle", background, 200, 217, -1*speedFactor));

//        background.add(new Turtle(500, 376, -1*speedFactor, 130, 130));
//        background.add(new Turtle(300, 376, -1*speedFactor, 130, 130));
//        background.add(new WetTurtle(700, 376, -1*speedFactor, 130, 130));
//        background.add(new WetTurtle(600, 217, -1*speedFactor, 130, 130));
//        background.add(new WetTurtle(400, 217, -1*speedFactor, 130, 130));
//        background.add(new WetTurtle(200, 217, -1*speedFactor, 130, 130));
    }

    /**
     * Adds the logs to the game
     * @param background Background to add logs
     */
    private static void addLogs(MyStage background) {
        ActorFactory af = new ActorFactory();
        background.add(af.getInstance("Log3", background, 0, 166, 0.75*speedFactor));
        background.add(af.getInstance("Log3", background, 220, 166, 0.75*speedFactor));
        background.add(af.getInstance("Log3", background, 440, 166, 0.75*speedFactor));
        background.add(af.getInstance("Logs", background, 0, 276, -2*speedFactor));
        background.add(af.getInstance("Logs", background, 400, 276, -2*speedFactor));
        background.add(af.getInstance("Log3", background, 50, 329, 0.75*speedFactor));
        background.add(af.getInstance("Log3", background, 270, 329, 0.75*speedFactor));
        background.add(af.getInstance("Log3", background, 490, 329, 0.75*speedFactor));

//        background.add(new Log("file:src/main/resources/Images/log3.png", 150, 0, 166, 0.75*speedFactor));
//        background.add(new Log("file:src/main/resources/Images/log3.png", 150, 220, 166, 0.75*speedFactor));
//        background.add(new Log("file:src/main/resources/Images/log3.png", 150, 440, 166, 0.75*speedFactor));
//        background.add(new Log("file:src/main/resources/Images/logs.png", 300, 0, 276, -2*speedFactor));
//        background.add(new Log("file:src/main/resources/Images/logs.png", 300, 400, 276, -2*speedFactor));
//        background.add(new Log("file:src/main/resources/Images/log3.png", 150, 50, 329, 0.75*speedFactor));
//        background.add(new Log("file:src/main/resources/Images/log3.png", 150, 270, 329, 0.75*speedFactor));
//        background.add(new Log("file:src/main/resources/Images/log3.png", 150, 490, 329, 0.75*speedFactor));
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
