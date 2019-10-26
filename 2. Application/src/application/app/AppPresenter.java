package application.app;

import application.app.right.RightView;
import application.inventory.InventoryView;
import application.sale.SaleView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import org.apache.log4j.Logger;

import java.net.URL;
import java.util.ResourceBundle;

public class AppPresenter implements Initializable {
    final static Logger logger = Logger.getLogger( application.Main.class);
    @FXML
    private AnchorPane left;

    @FXML
    private AnchorPane right;

    @FXML
    private Button btn2;

    @FXML
    private Button btn3;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    @FXML
    void btn1Click(ActionEvent event) {
        right.getChildren().clear();
        SaleView saleView = new SaleView();
        right.getChildren().add(saleView.getView());
    }

    @FXML
    void btn2Click(ActionEvent event) {
        InventoryView inventoryView = new InventoryView();
        right.getChildren().clear();
        right.getChildren().add(inventoryView.getView());
    }

}
