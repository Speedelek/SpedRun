package controller;

import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class Input {

    Character sped;

    public Input(Character sped){this.sped = sped;}

    public void applyJump(){
        sped.setYPoz(-52);
    }

    public void applyFall(){
        sped.setYPoz(52);
    }

    final EventHandler<KeyEvent> keyEventHandler =
            keyEvent -> {
            if(keyEvent.getCode() == KeyCode.W){
                if(sped.getYpoz() > 0){
                applyJump();
                sped.setJump(true);
                }
            }
            if(keyEvent.getCode() == KeyCode.S){
                if(sped.getYpoz() + sped.getImg().getHeight() < 400) {
                    applyFall();
                    sped.setJump(false);
                }
            }
            if(keyEvent.getCode() == KeyCode.ENTER){
                if(sped.isRun()) {
                    applyFall();
                }
            }
            if (keyEvent.getEventType() == KeyEvent.KEY_RELEASED){
                //sped.setImg("Character/TrexRun250.gif");
            }
            };

}
