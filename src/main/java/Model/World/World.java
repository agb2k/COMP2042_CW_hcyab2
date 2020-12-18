package Model.World;

import Model.Actor.Actor;
import javafx.animation.AnimationTimer;
import javafx.scene.Node;
import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.List;

/**
 * The world class used to set up the world of the game where actors are added
 */
public abstract class World extends Pane {
    private AnimationTimer timer;

    /**
     * Initiates a new world
     */
    public World() {

        sceneProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                newValue.setOnKeyReleased(event -> {
                    if (getOnKeyReleased() != null)
                        getOnKeyReleased().handle(event);
                    List<Actor> myActors = getObjects(Actor.class);
                    for (Actor anActor : myActors) {
                        if (anActor.getOnKeyReleased() != null) {
                            anActor.getOnKeyReleased().handle(event);
                        }
                    }
                });

                newValue.setOnKeyPressed(event -> {
                    if (getOnKeyPressed() != null)
                        getOnKeyPressed().handle(event);
                    List<Actor> myActors = getObjects(Actor.class);
                    for (Actor anActor : myActors) {
                        if (anActor.getOnKeyPressed() != null) {
                            anActor.getOnKeyPressed().handle(event);
                        }
                    }
                });
            }

        });
    }

    /**
     * Creates a timer for the game
     */
    public void createTimer() {
        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                act(now);
                List<Actor> actors = getObjects(Actor.class);
                
                for (Actor anActor: actors) {
                	anActor.act(now);
                }
      
            }
        };
    }

    /**
     * Starts a timer
     */
    public void start() {
    	createTimer();
        timer.start();
    }

    /**
     * Stops the timer
     */
    public void stop() {
        timer.stop();
    }

    /**
     * Adds actor
     * @param actor The actor to be added
     */
    public void add(Actor actor) {
        getChildren().add(actor);
    }

    /**
     * Removes acotr
     * @param actor The actor to be removed
     */
    public void remove(Actor actor) {
        getChildren().remove(actor);
    }

    /**
     * Gets the objects of a class
     * @param cls The class in which the objects are obtained from
     * @param <A> An array list
     * @return An array list
     */
    public <A extends Actor> List<A> getObjects(Class<A> cls) {
        ArrayList<A> someArray = new ArrayList<>();
        for (Node n: getChildren()) {
            if (cls.isInstance(n)) {
                someArray.add((A)n);
            }
        }
        return someArray;
    }

    /**
     * Performs the actions required
     * @param now Current time
     */
    public abstract void act(long now);
}
