package testForCharacter;

import controller.Character;
import org.junit.Assert;
import org.junit.Test;

public class Test3 {
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
        Assert.assertNotNull(sped.getImg());
    }
}
