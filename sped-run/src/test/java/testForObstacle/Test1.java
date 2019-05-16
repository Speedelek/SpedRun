package testForObstacle;

import controller.Obstacle;
import javafx.stage.Stage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import controller.Character;
import org.testfx.framework.junit5.ApplicationTest;


import static org.junit.jupiter.api.Assertions.*;

public class Test1 extends ApplicationTest {
    Obstacle obstacle;
    Character sped;

    @BeforeEach
    public void init(){
        obstacle = new Obstacle();
        sped = new Character();
    }

    /**
     * Letezik e az akadaly kepe
     */
    @Test
    public void testObstacleImageValidate(){
        System.out.println("image Test");
        assertNotNull(obstacle.getImage());
    }

    /**
     * Utkozik e a jatekos es az akadaly.
     */
    @Test
    public void testCollision1(){
        System.out.println("Collision Test");
        boolean nCol = true;
        double pozitionTrexX = sped.getPoz();
        double pozitionObsX = 100;
        double pozitionTrexY = sped.getYpoz();
        double pozitionObsY = 320;
        if(pozitionTrexX == pozitionObsX && pozitionObsY == pozitionTrexY){
            nCol = false;
        }
        assertFalse(nCol);
    }

    /**
     * Horizontalisan nem utkoznek.
     */
    @Test
    public void testCollision2(){
        System.out.println("Collision Test");
        boolean nCol = true;
        double pozitionTrexX = sped.getPoz();
        double pozitionObsX = 1000;
        double pozitionTrexY = sped.getYpoz();
        double pozitionObsY = 320;
        if(pozitionTrexX == pozitionObsX && pozitionObsY == pozitionTrexY){
            nCol = false;
        }
        assertTrue(nCol);
    }

    /**
     * Fuggolegesen nem utkoznek.
     */
    @Test
    public void testCollision3(){
        System.out.println("Collision Test");
        boolean nCol = true;
        double pozitionTrexX = sped.getPoz();
        double pozitionObsX = 100;
        double pozitionTrexY = sped.getYpoz();
        double pozitionObsY = 160;
        if(pozitionTrexX == pozitionObsX && pozitionObsY == pozitionTrexY){
            nCol = false;
        }
        assertTrue(nCol);
    }

    /**
     * Nem utkoznek.
     */
    @Test
    public void testCollision4(){
        System.out.println("Collision Test");
        boolean nCol = true;
        double pozitionTrexX = sped.getPoz();
        double pozitionObsX = 1000;
        double pozitionTrexY = sped.getYpoz();
        double pozitionObsY = 160;
        if(pozitionTrexX == pozitionObsX && pozitionObsY == pozitionTrexY){
            nCol = false;
        }
        assertTrue(nCol);
    }
}
