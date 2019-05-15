package main;


import controller.GameEngine;
import javafx.application.Application;
import javafx.stage.Stage;

public class MyApplication extends Application {

    GameEngine MyEngine;

    @Override
    public void start(Stage primaryStage) throws Exception {
        MyEngine = new GameEngine();
        MyEngine.MainLoop();
    }
}
