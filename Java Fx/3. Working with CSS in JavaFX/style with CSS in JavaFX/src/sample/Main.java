package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Scene scene= new Scene(root);
        //dan duong link css vao
        String css = this.getClass().getResource("Sytle.css").toExternalForm();
        //add file css vao
        scene.getStylesheets().add(css);
        primaryStage.setTitle("Hello World");
      primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
