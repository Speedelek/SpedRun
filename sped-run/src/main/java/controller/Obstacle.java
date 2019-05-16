package controller;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

import static java.lang.Math.abs;

/**
 * Az akadaly osztalya.
 */
public class Obstacle {
    /**
     * A naplozasert felelos logger peldanyositasa.
     */
    private static Logger logger = LoggerFactory.getLogger(GameEngine.class);
    /**
     * Ebbe frissitem a giffeket.
     */
    Image image;
    /**
     * A giffek megjelenitoje.
     */
    ImageView obstacle;
    /**
     * Az utközest figyeli.
     */
    boolean collision;

    /**
     * Az akadály mozgási sebessége.
     */
    float obstacleSpeed;
    /**
     * hova keruljon az akadaly
     */
    int obsPoz;

    /**
     * Az Obstacle osztaly konstruktora.
     * Kezdeti ertekek beallitasa.
     */
    public Obstacle(){
        logger.info("Obstacle osztaly konstruktora meghivva");
        Random rand = new Random();
        obstacleSpeed = (rand.nextInt(12)+10)*-1;

        Random randPoz = new Random();
        obsPoz = randPoz.nextInt(2);

       obstacle = new ImageView();
       image = null;
        if(obsPoz == 0){
            image = new Image(getClass().getClassLoader().getResource("obstacles/bird105.png").toString());
        }else{
            image = new Image(getClass().getClassLoader().getResource("obstacles/cactus105.png").toString());
        }
       obstacle.setImage(image);
       obstacle.setX(1280);

       if(obsPoz == 0){
           obstacle.setY(215);
       }else{
           obstacle.setY(320);
        }
       collision = false;
    }

    /**
     * Az akadaly ImageView megkapasa.
     * @return akadaly
     */
    public ImageView getView() {return obstacle;}

    /**
     * Az image megkapasa.
     * @return image
     */
    public Image getImage() {return image;}

    /**
     * Az akadaly X tengelyen levo poziciojanak megkapasa.
     * @return x
     */
    public double getPozition() {return obstacle.getX();}

    /**
     * Az akadaly sebessege.
     * @return Az akadaly sebesseget adja meg
     */
    public double getSpeed() {return obstacleSpeed;}

    /**
     * Utkozes vizsgalata.
     * A karakter pozicioja es szelessege az akadallyal nem e utkozik.
     * A karakterunk szelessegenek fele tartomanyara vizsgaljuk.
     * @param sped karakterunk
     * @return logikai ertek, amely megadja, hogy tortent e utkozes
     */
    public boolean isCollision(Character sped){
        if(abs(sped.getPoz() + sped.getImg().getWidth() - obstacle.getX()) < 5 && abs(sped.getYpoz() + sped.getImg().getHeight() - obstacle.getY() - obstacle.getImage().getHeight()) <= 0){
            collision = true;
            sped.setAlive(false);
            return true;
        }
        if(abs(sped.getPoz() + sped.getImg().getWidth() / 2 - obstacle.getX()) < 5 && abs(sped.getYpoz() + sped.getImg().getHeight() - obstacle.getY() - obstacle.getImage().getHeight()) <= 0 ){
            collision = true;
            sped.setAlive(false);
            return true;
        }
        else{
            return false;
        }

        /*return (((abs(sped.getPoz() + sped.getImg().getWidth() - obstacle.getX()) < 5)
                && abs(sped.getYpoz() + sped.getImg().getHeight() - obstacle.getY()) < 5)
                || ((abs(sped.getPoz() + sped.getImg().getWidth() / 2 - obstacle.getX()) < 5)
                && abs(sped.getYpoz() + sped.getImg().getHeight() / 2 - obstacle.getY()) < 5 ));*/
    }

    /**
     * Az akadaly frissitese.
     * Az utkozes megvizsgalasa.
     * A collision valtozo esetleges atallitasa.
     * @param sped karakterunk
     */
    public void update(Character sped){
        if(!collision) {
            if (isCollision(sped)) {
                collision = true;
                sped.setRun(true);
                sped.setAlive(false);
                logger.info("Otkozes tortent a jatek vegeter");
            } else {
                obstacle.setX(obstacle.getX() + obstacleSpeed);
            }
        }else{
            sped.setRun(true);
            //System.out.println("FAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
            //JATZEK VEGE JAVTEK VEGE BEALLITASA
        }

    }

}
