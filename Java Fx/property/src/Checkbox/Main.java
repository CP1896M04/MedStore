package Checkbox;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        try {
            primaryStage.setTitle("Hello World");
            Parent root = FXMLLoader.load(getClass().getResource("checkbox.fxml"));
            Scene scene= new Scene(root);
            // scene.getStylesheets().add(getClass().getResource("sytle.css").toExternalForm());
            primaryStage.setScene(scene);
            primaryStage.show();
        }catch(Exception e){
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        launch(args);
    }
}
