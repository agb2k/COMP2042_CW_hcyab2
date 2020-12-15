package Model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DigitTest {

    Digit digit = new Digit(1,30,0, 0);
    /**
     * Checks position of digit
     */
    @Test
    public void positionTest() {
        assertEquals(0, digit.getX(), 0.0);
        assertEquals(0, digit.getY(), 0.0);
    }

    /**
     * Checks dimensions of digit
     */
    @Test
    public void imageDimTest() {
        assertEquals(30, digit.getHeight(), 0.0);
    }

}