package controller;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import static java.lang.Math.abs;

public class Obstacle {
    /**
     * Ebbe frissitem a giffeket.
     */
    Image image;
    /**
     * A giffek megjelenitoje
     */
    ImageView obstacle;
    /**
     * Az utközest figyeli
     */
    boolean collision;

    /**
     * Az akadály mozgási sebessége
     */
    float obstacleSpeed;

    /**
     * Az Obstacle osztaly konstruktora
     * kezdeti ertekek beallitasa
     */
    public Obstacle(){
       obstacleSpeed = -8;
       //obstaclePozition = 1100;
       obstacle = new ImageView();
       image = null;
       image = new Image(getClass().getClassLoader().getResource("obstacles/cactus105.png").toString());
       obstacle.setImage(image);
       obstacle.setX(1100);
       obstacle.setY(320);
       collision = false;
    }

    public ImageView getView() {return obstacle;}

    public Image getImage() {return image;}

    public double getPozition() {return obstacle.getX();}

    /**
     * Az akadaly sebessege
     * @return Az akadaly sebesseget adja meg
     */
    public double getSpeed() {return obstacleSpeed;}

    /*
    ide talan jon egy olyan fgv hogy
    az ÜTKÖZÉS következményét megvalósítja
     */

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
                System.out.println("FAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
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
