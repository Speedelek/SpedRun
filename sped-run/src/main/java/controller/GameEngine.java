package controller;

import database.DataBase;
import javafx.animation.AnimationTimer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import view.Window;

/**
 * A jatek MainLoopjat tartalmazo osztaly.
 */
public class GameEngine {
    /**
     * Az adatbaziskezelo peldanyositasa.
     */
    private static final DataBase DB = DataBase.getDbPeldany();
    /**
     * A naplozasert felelos logger peldanyositasa.
     */
    private static Logger logger = LoggerFactory.getLogger(GameEngine.class);
    /**
     * A jatek inditasanak ideje.
     */
    long startNanoTime;
    /**
     * Az aktualis pontszamunk.
     */
    int scoreCounter;
    /**
     * A palya letrehozasa.
     */
    Stage stage;
    /**
     * Az input osztaly letrehozasa, ami a billentyuzet kezeleseert felel.
     */
    Input input;
    /**
     * Az ablak letrehozasa.
     */
    Window window;
    /**
     * A karakterunk letrehozasa.
     */
    public Character sped;

    /**
     * Az osztaly konstruktora.
     * Osztalyok peldanyositasa.
     */
    public GameEngine(){
        scoreCounter = 0;
        stage = new Stage();
        sped = new Character();
        window = new Window(this);
        startNanoTime = System.nanoTime();
        input = new Input(sped);
        window.getScene().setOnKeyPressed(input.keyEventHandler);
    }

    /**
     * A jatek folyamatos futasaert felelos loop.
     */
    public void MainLoop(){
        new AnimationTimer(){
            public void handle(long currentNanoTime){
                float t = (float) ((currentNanoTime - startNanoTime) / 1000000.0);
                if(sped.isAlive() == true){
                    sped.update();
                    window.update(sped);
                    window.getScene().setOnKeyPressed(input.keyEventHandler);
                    window.getScene().setOnKeyReleased(input.keyEventHandler);

                    window.setView(stage.getImage());
                    if(stage.getObstacle().getPozition() < -5 - stage.getObstacle().getImage().getWidth()){
                        stage.initObstacle();
                        scoreCounter++;
                    }
                    window.getBg().getChildren().remove(stage.getObstacle().getView());
                    window.getBg().getChildren().add(stage.getObstacle().getView());

                    stage.update(sped);
                }else{
                    logger.info("A jatek vege");
                    window.getBg().setOpacity(0.1);

                    try {

                        DB.connectDB();
                        DB.createScore(scoreCounter,t);
                        DB.disconnectDB();
                        logger.info("Az eredmeny az adatbazisba bekerult");

                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    this.stop();
                    logger.info("Vege a MainLoopnak");
                }


            }
        }.start();
    }

}
