package view;

import controller.Character;
import controller.GameEngine;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A megjelenitessel foglalkozo osztaly.
 */
public class Window {
    /**
     * A naplozasert felelos logger peldanyositasa.
     */
    private static Logger logger = LoggerFactory.getLogger(GameEngine.class);
    /**
     * A Stage.
     */
    private Stage window;
    /**
     * A Pane.
     */
    private Pane bg;
    /**
     * A Scene.
     */
    private Scene scene;
    /**
     * Az ImageView.
     */
    final ImageView selectedImage;
    /**
     * Image osztaly peldanyositasa.
     */
    Image image;

    /**
     * Az osztaly konstruktora.
     * @param game jatekmotor
     */
    public Window(GameEngine game){
        logger.info("Logger konstruktora meghivva");
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

    /**
     * A Scene-t adja vissza.
     * @return scene
     */
    public Scene getScene(){return scene;}

    /**
     * A hatteret adja vissza.
     * @return bg
     */
    public Pane getBg(){return bg;}

    /**
     * A kepet adja vissza.
     * @param image kep
     */
    public void setView(Image image){selectedImage.setImage(image);}

    /**
     * A kepernyo frissitése.
     * @param sped a karakter
     */
    public void update(Character sped){
        window.setScene(scene);
    }
}
