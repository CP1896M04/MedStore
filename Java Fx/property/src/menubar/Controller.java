package menubar;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.Initializable;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable{



    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

    }
    public void menuClose(ActionEvent event){
        Platform.exit();
        System.exit(0);
    }
}
