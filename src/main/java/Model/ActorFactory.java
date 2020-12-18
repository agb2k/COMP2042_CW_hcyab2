package Model;

/**
 * Utilizes factory design pattern to create instances of actors to be used by the addObjects class
 */
public class ActorFactory {
    /**
     * Gets the instance of the actor required
     * @param str The string corresponding to the required actor
     * @param background MyStage type
     * @param x X coordinate
     * @param y Y coordinate
     * @param s Speed
     * @return Actor type required
     */
    public Actor getInstance(String str, MyStage background, int x, int y, double s){
        return switch (str) {
            case "Digit" -> new Digit(0, 30, x, y);
            case "Mute" -> new Mute(background, 45, x, y);
            case "Pause" -> new Pause(35, x, y);
            case "Stop" -> new Stop(32, x, y);
            case "Lives" -> new Lives(x, y);
            case "PowerUp" -> new PowerUp(40, s);
            case "Skeleton" -> new Skeleton(x, y, s, 70, 70);
            case "Dragon" -> new Dragon(x, y, s, 70, 70);
            case "Minotaur" -> new Minotaur(x, y, s, 70, 70);
            case "BgImg" -> new BackgroundImage("file:src/main/resources/Images/GameBackground.png");
            case "Truck1Right" -> new Vehicles("file:src/main/resources/Images/truck1" + "Right.png", x, y, s, 120, 120);
            case "Truck2Right" -> new Vehicles("file:src/main/resources/Images/truck2Right.png", x, y, s, 200, 200);
            case "Car1Left" -> new Vehicles("file:src/main/resources/Images/car1Left.png", x, y, s, 50, 50);
            case "End" -> new End(x, y);
            case "Turtle" -> new Turtle(x, y, s, 130, 130);
            case "WetTurtle" -> new WetTurtle(x, y, s, 130, 130);
            case "Log3" -> new Log("file:src/main/resources/Images/log3.png", 150, x, y, s);
            case "Logs" -> new Log("file:src/main/resources/Images/logs.png", 300, x, y, s);
            default -> null;
        };
    }
}
