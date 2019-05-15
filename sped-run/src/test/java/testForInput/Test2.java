package testForInput;

import controller.Input;
import controller.Character;
import org.junit.Assert;
import org.junit.Test;

public class Test2 {
    Input input;
    Character sped;

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
        Double pozition1 = sped.getYpoz();
        input.applyFall();
        Double pozition2 = sped.getYpoz();
        Assert.assertNotEquals(pozition1, pozition2);
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
        Assert.assertNotEquals(pozition1, pozition2);
    }

}
