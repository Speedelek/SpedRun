package controller;

import javafx.scene.image.Image;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A palyank osztalya amin a karakter es akadaly van.
 */
public class Stage {
    /**
     * A naplozasert felelos logger peldanyositasa.
     */
    private static Logger logger = LoggerFactory.getLogger(GameEngine.class);
    /**
     * Hatterkep.
     */
    Image image;
    /**
     * Az akadaly letrehozasa.
     */
    Obstacle obstacle;

    /**
     * Az osztaly konstruktora.
     */
    public Stage(){
        logger.info("Stage konstruktora meghivva");
        obstacle = new Obstacle();
        image = new Image(getClass().getClassLoader().getResource("bg1.png").toString());
    }

    /**
     * Az akadaly kinyerese.
     * @return akadaly objektum
     */
    public Obstacle getObstacle(){
        return obstacle;
    }

    /**
     * Hatterkep kinyerese.
     * @return hatterkep
     */
    public Image getImage(){
        return image;
    }

    /**
     * Az akadaly inicializalasa.
     * Meghivodik az akadaly konstruktora.
     */
    public void initObstacle(){
        obstacle = new Obstacle();
    }

    /**
     * A palya frissitese.
     * @param sped karakter
     */
    public void update(Character sped){
        obstacle.update(sped);
    }
}
