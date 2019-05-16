package testForCharacter;

import controller.Character;

import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;
import static org.junit.jupiter.api.Assertions.*;

public class Test3 extends ApplicationTest{
    Character sped;

    public void init(){
        sped = new Character();
    }

    /**
     *Letezik e a jatekos kepe.
     */
    @Test
    public void testObstacleImageValidate(){
        System.out.println("image Test");
        assertNotNull(sped.getImg());
    }
}
