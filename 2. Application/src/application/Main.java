package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.apache.log4j.Logger;
import java.io.IOException;
public class Main extends Application {
    /*
    static{
        DOMConfigurator.configure("src/log4j.xml");
    }
    */
    final static Logger logger = Logger.getLogger( application.Main.class);
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        try {
            Parent root= FXMLLoader.load(getClass().getResource("fxml/Main.fxml"));
            logger.debug("This is debug : ");
            Scene scene= new Scene(root);
            //scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
            primaryStage.setScene(scene);
            primaryStage.show();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
