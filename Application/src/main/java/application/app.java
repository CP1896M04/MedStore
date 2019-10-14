package main.java.application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import main.java.dao.UserDAO;
import main.java.model.User;

public class
app extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)throws Exception {
        UserDAO userDAO = new UserDAO();
        User u = new User("hhh","1234");
        userDAO.add(u);
        Parent root = FXMLLoader.load(getClass().getResource("Design.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }
}
