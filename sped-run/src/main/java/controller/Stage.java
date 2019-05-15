package controller;

import javafx.scene.image.Image;

public class Stage {
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
