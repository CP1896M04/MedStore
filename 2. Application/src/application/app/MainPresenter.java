package application.app;

import application.sale.poinofsale.PointOfSaleView;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TreeItem;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import lib.leftMenu;

import javafx.scene.input.MouseEvent;
import java.net.URL;
import java.util.ResourceBundle;

public class MainPresenter implements Initializable {
    @FXML
    private javafx.scene.control.TreeView<String> treeView ;

    @FXML
    private VBox container;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
            leftMenu instance = leftMenu.getInstance();
            instance.getLeftMenu(treeView);
    }
    public void selectItems(MouseEvent event){
        TreeItem<String> item = treeView.getSelectionModel().getSelectedItem();
        String nodeName = item.getValue();
       switch (nodeName){
           case "Point of Sale":
               container.getChildren().clear();
               PointOfSaleView pointOfSaleView = new PointOfSaleView();
               container.getChildren().add(pointOfSaleView.getView());
               break;
       }

    }
}
