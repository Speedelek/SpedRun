package main;

import javafx.application.Application;

/**
 *
 * @author Kakoczky Akos Peter
 */
public class Main {
    /**
     * A main fuggveny.
     * @param args argumentum
     */
    public static void main(String[] args) {

        try{
            Application.launch(MyApplication.class, args);
        } catch (Exception e) {

            e.printStackTrace();
        }


    }

}
