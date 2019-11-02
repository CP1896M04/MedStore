package application.product.addnewproduct;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;


import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import pattern.dao.ProductDAO;
import pattern.model.Category;
import pattern.model.Product;
import pattern.model.Supplier;
import pattern.model.Unit;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class AddNewProductPresenter implements Initializable {
    @FXML
    private Button btnAdd;

    @FXML
    private Button btnUpdate;

    @FXML
    private Button btnRemove;

    @FXML
    private Label lbProducId;

    @FXML
    private Label lbUnitId;

    @FXML
    private Label lbPName;

    @FXML
    private Label lbCatId;

    @FXML
    private TextField txtProductId;

    @FXML
    private TextField txtPName;

    @FXML
    private Label lbPComposition;

    @FXML
    private Label lbUprice;

    @FXML
    private Label lbUSP;

    @FXML
    private Label lbHTU;

    @FXML
    private Label lbSupplierId;

    @FXML
    private Label lbPDescr;

    @FXML
    private Label lbPManufacturer;

    @FXML
    private Label lbReOrLevel;

    @FXML
    private Label lbDefaultInDose;

    @FXML
    private TextField txtPComposition;

    @FXML
    private TextField txtUprice;

    @FXML
    private TextField txtUSP;

    @FXML
    private TextField txtHTU;

    @FXML
    private TextField txtPDescr;

    @FXML
    private TextField txtPManufacturer;

    @FXML
    private TextField txtReOrLevel;

    @FXML
    private TextField txtDefaultInDose;

    @FXML
    private ComboBox<Product> comboboxCatID;

    @FXML
    private ComboBox<Product> comboboxSupplierID;

    @FXML
    private ComboBox<Product> comboboxUnitID;
ProductDAO productDAO= new ProductDAO();
    @FXML
    void btnAdd(ActionEvent event) {

    }

    @FXML
    void btnRemove(ActionEvent event) {

    }



    @FXML
    void comboboxSupplierID(ActionEvent event) {
    
    }

    @FXML
    void comboboxUnitID(ActionEvent event) {

    }

    @FXML
    void tbnUpdate(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

}
