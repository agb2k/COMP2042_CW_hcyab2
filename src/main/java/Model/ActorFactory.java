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
        if (str.equals("Digit")){
            return new Digit(0, 30, x, y);
        }
        else if (str.equals("Mute")){
            return new Mute(background, 45, x, y);
        }
        else if(str.equals("Pause")){
            return new Pause(35, x, y);
        }
        else if(str.equals("Stop")){
            return new Stop(32, x, y);
        }
        else if(str.equals("Lives")){
            return new Lives(x, y);
        }
        else if(str.equals("PowerUp")){
            return new PowerUp(40, s);
        }
        else if (str.equals("Skeleton")){
            return new Skeleton(x, y, s, 70, 70);
        }
        else if (str.equals("Dragon")){
            return new Dragon(x, y, s, 70, 70);
        }
        else if (str.equals("Minotaur")){
            return new Minotaur(x, y, s, 70, 70);
        }
        else if (str.equals("BgImg")){
            return new BackgroundImage("file:src/main/resources/Images/GameBackground.png");
        }
        else if (str.equals("Truck1Right")){
            return new Vehicles("file:src/main/resources/Images/truck1"+"Right.png", x, y, s, 120, 120);
        }
        else if (str.equals("Truck2Right")){
            return new Vehicles("file:src/main/resources/Images/truck2Right.png", x, y, s, 200, 200);
        }
        else if (str.equals("Car1Left")){
            return new Vehicles("file:src/main/resources/Images/car1Left.png", x, y, s, 50, 50);
        }
        else if (str.equals("End")){
            return new End(x, y);
        }
        else if (str.equals("Turtle")){
            return new Turtle(x, y, s, 130, 130);
        }
        else if (str.equals("WetTurtle")){
            return new WetTurtle(x, y, s, 130, 130);
        }
        else if (str.equals("Log3")){
            return new Log("file:src/main/resources/Images/log3.png", 150, x, y, s);
        }
        else if (str.equals("Logs")){
            return new Log("file:src/main/resources/Images/logs.png", 300, x, y, s);
        }else {
            return null;
        }
    }
}
