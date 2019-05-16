package main;


import controller.GameEngine;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * A jatek elinditasaert felelos osztaly.
 */
public class MyApplication extends Application {
    /**
     * A jatekmotor peldanyositasa.
     */
    GameEngine MyEngine;

    @Override
    public void start(Stage primaryStage) throws Exception {
        MyEngine = new GameEngine();
        MyEngine.MainLoop();
    }
}
