package Sliderproperty;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override

        public void start(Stage primaryStage) throws Exception{
            try {
                primaryStage.setTitle("Hello World");
                Parent root = FXMLLoader.load(getClass().getResource("property.fxml"));
                Scene scene= new Scene(root);
               // scene.getStylesheets().add(getClass().getResource("sytle.css").toExternalForm());
                primaryStage.setScene(scene);
                primaryStage.show();
            }catch(Exception e){
                e.printStackTrace();
            }
    }
}
