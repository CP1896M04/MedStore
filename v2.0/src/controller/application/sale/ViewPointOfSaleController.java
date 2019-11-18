package controller.application.sale;

import controller.application.product.ViewCategoryController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ViewPointOfSaleController implements Initializable {

    @FXML
    private TableView<?> viewOrderdetail;

    @FXML
    private TableColumn<?, ?> colProductID;

    @FXML
    private TableColumn<?, ?> colProductName;

    @FXML
    private TableColumn<?, ?> colHTU;

    @FXML
    private TableColumn<?, ?> colQty;

    @FXML
    private TableColumn<?, ?> colUPS;

    @FXML
    private TableColumn<?, ?> colDiscount;

    @FXML
    private TableColumn<?, ?> colTotal;

    @FXML
    private ComboBox<?> cbProductName;

    @FXML
    private TextField txtDay;

    @FXML
    private TextField txtQty;

    @FXML
    private TextField txtUSP;

    @FXML
    private TextField txtAvailable;

    @FXML
    private TextField txtProductName;

    @FXML
    private Button btnInsert;

    @FXML
    private TextField txtHtu;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
