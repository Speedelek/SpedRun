package controller;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A fo karakterunkhoz tartozo osztaly.
 */
public class Character {
    /**
     * A naplozasert felelos logger peldanyositasa.
     */
    private static Logger logger = LoggerFactory.getLogger(GameEngine.class);
    /**
     * A jatekos kepet tartalmazza.
     */
    public ImageView player = new ImageView();
    /**
     * A jetekos kepe.
     */
    Image image;
    /**
     * Fut e a jatekos.
     */
    boolean run = false;
    /**
     * Eletben van e a jatekos.
     */
    boolean alive = true;
    /**
     * Ugrig e a karakter.
     */
    boolean jump = false;

    //boolean pass = false;

    /**
     * A kikerult akadalyokat szamolja.
     */
    int counter;

    /**
     * A karakterunk konstruktora.
     * A karakter kezo kepe es poziciojanak beallitasa.
     */
    public Character(){
        logger.info("Karakter konstruktora meghivva");
        counter = 0;
        image = null;
        image = new Image(getClass().getClassLoader().getResource("Character/TrexRun250.gif").toString());
        player.setImage(image);
        player.setX(100);
        player.setY(320);
    }

    /**
     * Logikai ertek amely megmondja, hogy fut e a jatekos.
     * @return Fut e a jatekos
     */
    public boolean isRun() {
        return run;
    }

    /**
     * Atallithatjuk, hogy Fut e a jatekos.
     * @param run logikai valtozoja a futasnak
     */
    public void setRun(boolean run) {
        this.run = run;
    }

    /**
     * Logikai erteket ad vissza, amely megmondja, hogy ugrik e a jatekos.
     * @return ugras logikai erteke
     */
    public boolean isJump() {
        return jump;
    }

    /**
     * Atallithatjuk az ugras logikai erteket, ha ugrunk.
     * @param jump az ugras erteke
     */
    public void setJump(boolean jump) {
        this.jump = jump;
    }

    /**
     * Az kikerult akadalyok szamat adja vissza.
     * @return kikerult akadalyok szama
     */
    public int getCounter() {
        return counter;
    }

    /**
     * A kikerult akadalyok szamanak novelese.
     * @param counter szamlalo
     */
    public void incCounter(int counter) {
        counter++;
    }

    /**
     * Visszaadja, a logikai erteket, hogy el e a karakterunk.
     * @return el e a karakterunk
     */
    public boolean isAlive() {
        return alive;
    }

    /**
     * Beallithatjuk, hogy el e a karakterunk.
     * @param alive a karakter el e
     */
    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    /**
     * Visszaadja az objektum kepet.
     * @return objektum kepe
     */
    public ImageView getPlayer() {
        return player;
    }

    /**
     * A karakter x koordinatajanak megkapasa.
     * @return a karakter x koordinatajanak pozicioja
     */
    public double getPoz(){return player.getX();}

    /**
     * A gif ek frissitese.
     * @param img erre allitom az a gifet.
     */
    public void setImg(String img){
        image = new Image(getClass().getClassLoader().getResource(img).toString());
    }

    /**
     * Az aktualis gif megkapasa.
     * @return az aktualis gif.
     */
    public Image getImg(){return image;}

    /**
     * A karakter y koordinatajanak megkapasa.
     * @return y koordinatajanak pozicioja
     */
    public double getYpoz(){return player.getY();}

    /**
     * A karakter y koordinatajanak modositasa.
     * @param y hozzaadja a karakter poziciojahoz.
     */
    public void setYPoz(double y){
        player.setY(player.getY() + y);
    }

    /**
     * A Karakter frissitese.
     */
    public void update(){
        if(run) {
            if (!jump) {
                setImg("Character/TrexRun250.gif");
            }
            if (jump) {
                setImg("Character/TrexJump250.gif");
            }
        }else{
            setImg("Character/TrexDead250.png");
        }
    }
}
