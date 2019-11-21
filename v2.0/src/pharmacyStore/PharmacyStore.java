package pharmacyStore;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PharmacyStore extends Application {
    public PharmacyStore() {
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        try {
            //Star program here
           // Parent root = FXMLLoader.load(getClass().getResource("/view/Application.fxml"));
            Parent root = FXMLLoader.load(getClass().getResource("/view/Login.fxml"));
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Login");
            primaryStage.setResizable(false);
            primaryStage.show();
        } catch (Exception e) {
            Logger.getLogger(PharmacyStore.class.getName()).log(Level.SEVERE, null, e);
        }
    }

}
