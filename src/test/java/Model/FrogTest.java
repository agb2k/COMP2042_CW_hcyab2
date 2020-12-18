package Model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

class FrogTest {
    /**
     * Used to test if the userStop getter and setter functions properly
     */
    @Test
    public void userStopSetterGetterTest(){
        Frog.setUserStop(true);
        assertTrue(Frog.isUserStop());
    }

    /**
     * Used to test if the userStop getter and setter functions properly
     */
    @Test
    public void changeLifeSetterGetterTest(){
        Frog.setChangeLife(true);
        assertTrue(Frog.isChangeLife());
    }

    /**
     * Used to test if the round score can be saved
     * @throws FileNotFoundException Error thrown when file not found
     */
    @Test
    public void saveRoundScoreTest() throws FileNotFoundException {
        Frog.saveRoundScore(2, 100, "src/main/resources/Misc/roundScore.csv");
        Scanner sc = new Scanner(new File("C:/Users/abhin/IdeaProjects/FroggerTrial/src/main/resources/Misc/roundScore.csv"));
        assertEquals("3,100", sc.next());
        sc.close();
        PrintWriter pw = new PrintWriter("src/main/resources/Misc/roundScore.csv");
        pw.close();
    }
}