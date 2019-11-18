package lib.window;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class addNewProduct extends Stage {
    private static addNewProduct instance;
    private addNewProduct() throws Exception {}
    public static synchronized addNewProduct getInstance() throws Exception {
        if(instance == null){
            instance = new addNewProduct();
        }
        instance.setTitle("Add New Product");
        return instance;
    }
}
