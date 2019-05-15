package view;

import controller.Character;
import controller.GameEngine;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Window {

    private Stage window;

    private Pane bg;

    private Scene scene;

    //private String stageId;

    final ImageView selectedImage;

    Image image;

    public Window(GameEngine game){
        selectedImage = new ImageView();
        image = null;
        image = new Image(getClass().getClassLoader().getResource("bg1.png").toString());
        selectedImage.setImage(image);
        window = new Stage();
        window.setTitle("SpedRun");
        bg = new Pane();
        bg.getChildren().addAll(selectedImage, game.sped.player);
        scene = new Scene(bg, 1280,610);
        window.show();
    }

    public Scene getScene(){return scene;}

    public Pane getBg(){return bg;}

    public void setView(Image image){selectedImage.setImage(image);}

    public void update(Character sped){
        window.setScene(scene);
    }
}
