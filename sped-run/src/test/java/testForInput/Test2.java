package testForInput;

import controller.Input;
import controller.Character;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;

import static org.junit.jupiter.api.Assertions.*;

public class Test2 extends ApplicationTest {
    Input input;
    Character sped;
    double pozition1, pozition2;

    @Before
    public void init(){
        sped = new Character();
        input = new Input(sped);
    }

    /**
     *Az felugras tesztje.
     */
    @Test
    public void testJump(){
        System.out.println("Test applyJump");
        //pozition1 = sped.getPlayer().getY();
        //System.out.println(pozition1+"2");
        input.applyFall();
        pozition2 = sped.getPlayer().getY();
        //.out.println(pozition2+ "asdasd");
        assertNotEquals(320, pozition2);
    }

    /**
     * A leugras tesztje.
     */
    @Test
    public void testFall(){
        System.out.println("Test applyFall");
        Double pozition1 = sped.getYpoz();
        input.applyJump();
        Double pozition2 = sped.getYpoz();
        assertNotEquals(pozition1, pozition2);
    }

}
