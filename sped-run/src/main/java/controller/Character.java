package controller;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class Character {
    /**
     * A jatekos kepet tartalmazza.
     */
    public ImageView player = new ImageView();
    /**
     * A jetekos kepe.
     */
    Image image;
    /**
     *
     */
    boolean run = false;

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

    public Character(){
        counter = 0;
        image = null;
        image = new Image(getClass().getClassLoader().getResource("Character/TrexRun250.gif").toString());
        player.setImage(image);
        player.setX(100);
        player.setY(320);
    }

    public boolean isRun() {
        return run;
    }

    public void setRun(boolean run) {
        this.run = run;
    }

    public boolean isJump() {
        return jump;
    }

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

    /*public boolean isPass() {
        return pass;
    }

    public void setPass(boolean pass) {
        this.pass = pass;
    }*/

    /**
     * Visszaadja, a logikai erteket, hogy el e a karakterunk
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
     * A karakter y koordinatajanak megkapasa
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
