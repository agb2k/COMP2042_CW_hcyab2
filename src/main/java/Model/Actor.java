package Model;

import javafx.scene.image.ImageView;
import java.util.ArrayList;

/**
 * This class is inherited by many other classes to provide functions
 */

public abstract class Actor extends ImageView{
    /**
     * Moves the actor a certain distance
     * @param dx The change in the x axis
     * @param dy The change in the y axis
     */
    public void move(double dx, double dy) {
        setX(getX() + dx);
        setY(getY() + dy);
    }

    /**
     * Gets the parent of the actor
     * @return World containing actor
     */
    public World getWorld() {
        return (World) getParent();
    }

    /**
     * Checks if the actor intersects with the items of a class
     * @param cls A class containing items
     * @param <A> An array list
     * @return An array
     */
    public <A extends Actor> java.util.List<A> getIntersectingObjects(Class<A> cls){
        ArrayList<A> someArray = new ArrayList<>();
        for (A actor: getWorld().getObjects(cls)) {
            if (actor != this && actor.intersects(this.getBoundsInLocal())) {
                someArray.add(actor);
            }
        }
        return someArray;
    }

    /**
     * Performs actions at certain times
     * @param now Current time
     */
    public abstract void act(long now);

}
