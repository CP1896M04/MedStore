package application.app;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        MainView view = new MainView();
        Scene scene = new Scene(view.getView());
        primaryStage.setTitle("App");
        //final String uri = getClass().getResource("app.css").toExternalForm();
       // scene.getStylesheets().add(uri);
        primaryStage.setScene(scene);
        primaryStage.setMaximized(true);
        primaryStage.setFullScreen(true);
        primaryStage.setResizable(true);
        primaryStage.show();
    }
}
