package application.app;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TreeItem;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import lib.LeftMenu;

import javafx.scene.input.MouseEvent;
import lib.window.addNewProduct;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainPresenter implements Initializable {
    @FXML
    private javafx.scene.control.TreeView<String> treeView ;

    @FXML
    private VBox container;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
            LeftMenu instance = LeftMenu.getInstance();
            instance.getLeftMenu(treeView);
    }
    public void selectItems(MouseEvent event) throws Exception {
        TreeItem<String> item = treeView.getSelectionModel().getSelectedItem();
        String nodeName = item.getValue();
       switch (nodeName){
           case "Add Product":
               Parent parent = FXMLLoader.load(getClass().getResource("/application/product/addnewproduct/addnewproduct.fxml"));
               Stage stage = addNewProduct.getInstance();
               stage.setScene((new Scene(parent)));
               stage.show();
               break;
           case "Add Category":
               Parent parent1 = FXMLLoader.load(getClass().getResource("/application/product/addcategory/addcategory.fxml"));
               Stage stage1 = addNewProduct.getInstance();
               stage1.setScene((new Scene(parent1)));
               stage1.show();
               break;
       }
    }
    void loadWindow(String loc, String title){
        try {
            Parent parent = FXMLLoader.load(getClass().getResource(loc));
            Stage stage = new Stage(StageStyle.DECORATED);
            stage.setTitle(title);
            stage.setScene((new Scene(parent)));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
