package application;

import application.app.MainView;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import lib.LibraryAssistant;
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
    public void start(Stage primaryStage)  throws IOException {
        logger.info("Load main form");
        Parent parent = FXMLLoader.load(getClass().getResource("/application/app/main.fxml"));
        Scene scene = new Scene(parent);
        primaryStage.setTitle("App");
        //final String uri = getClass().getResource("app.css").toExternalForm();
        // scene.getStylesheets().add(uri);
        primaryStage.setScene(scene);
        primaryStage.setResizable(true);
        primaryStage.show();

    }
}
