package user.application.fxml;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class Multiscreen extends Application {
    private BorderPane rootLayout;
    private VBox toolbarLayout;
    private URL path;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        path = getClass().getResource("Home.fxml");
        try {
            loader.setLocation(path);
            rootLayout = (BorderPane) loader.load();
        } catch (IOException e){
            System.out.println("Not found: " + path);
            e.printStackTrace();
        }

        loader.setRoot(null);
        loader.setController(null);
        loader.setResources(null);
        loader.getNamespace().clear();
    }
}
