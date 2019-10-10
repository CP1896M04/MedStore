package sample;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import  javafx.stage.Stage;
import javafx.scene.Scene;
import  javafx.scene.control.Button;
import  javafx.scene.control.*;
import javafx.scene.layout.StackPane;
import javafx.scene.Scene;
import java.awt.*;
import  javafx.scene.layout.VBox;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        //tao title
        primaryStage.setTitle("Hello");
        //tao nut button
        Button btn= new Button("Click me");
        //tao nut button thu 2
        Button exit= new Button("Exit");
        exit.setOnAction(e ->{
            System.out.println("Application about to close");
            System.exit(0);
        });
        //tao su kien
        btn.setOnAction(e ->System.out.println("hello world"));
        //tao layout
        VBox layout= new VBox();
        layout.getChildren().addAll(btn,exit);
        //cho chieu cao and chieu rong;
        Scene scene= new Scene(layout,300,500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
