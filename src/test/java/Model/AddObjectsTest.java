package Model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddObjectsTest {
    /**
     * Used to test if the speedFactor getter and setter functions properly
     */
    @Test
    public void userStopSetterGetterTest(){
        AddObjects.setSpeedFactor(5);
        assertEquals(5, AddObjects.getSpeedFactor());
    }
}