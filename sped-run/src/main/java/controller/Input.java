package controller;

import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A billentyuzet kezeleseert felelos osztaly.
 */
public class Input {
    /**
     * A naplozasert felelos logger peldanyositasa.
     */
    private static Logger logger = LoggerFactory.getLogger(GameEngine.class);
    /**
     * A karakterunk peldanyositasa.
     */
    Character sped;

    /**
     * Az osztaly konstruktora.
     * @param sped karakter neve
     */
    public Input(Character sped){this.sped = sped;}

    /**
     * Ugras eseten a karakter poziciojanak megvaltoztatasa.
     */
    public void applyJump(){
        sped.setYPoz(-52.5);
    }

    /**
     * Eses eseten a karakter poziciojanak megvaltoztatasa.
     */
    public void applyFall(){
        sped.setYPoz(52.5);
    }

    /**
     * Billentyulenyomas kezelese.
     */
    final EventHandler<KeyEvent> keyEventHandler =
            keyEvent -> {
            if(keyEvent.getCode() == KeyCode.W){
                if(sped.getYpoz() > 250){
                applyJump();
                sped.setJump(true);
                logger.info("Ugras megtortent");
                }
            }
            if(keyEvent.getCode() == KeyCode.S){
                if(sped.getYpoz() + sped.getImg().getHeight() < 400) {
                    applyFall();
                    sped.setJump(false);
                    logger.info("Eses megtortent");
                }
            }
            };

}
