package sample;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import  javafx.stage.Stage;
import javafx.scene.Scene;
import  javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.Scene;
import java.awt.*;


public class Main extends Application {

    public static void main(String[] args)
    {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception{
        //tao title
        primaryStage.setTitle("Hello");
        //tao nut button
        Button btn= new Button("Click me");
        //tao su kien
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello work");
            }
        });
        //tao layout
        StackPane layout= new StackPane();
        layout.getChildren().add(btn);
        //cho chieu cao and chieu rong;
        Scene scene= new Scene(layout,300,500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
