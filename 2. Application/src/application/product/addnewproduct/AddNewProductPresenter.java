package application.product.addnewproduct;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;


import pattern.dao.ProductDAO;
import pattern.model.Product;

import java.net.URL;
import java.sql.SQLException;
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
    private TextField txtUnitID;

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
    private TextField txtSupplierID;

    @FXML
    private TextField txtPDescr;

    @FXML
    private TextField txtPManufacturer;

    @FXML
    private TextField txtReOrLevel;

    @FXML
    private TextField txtDefaultInDose;

    @FXML
    private TextField txtCatId;

    ProductDAO productDAO= new ProductDAO();
    @FXML
    void btnAdd(ActionEvent event) {
     Product product= new Product(0,0,0,txtPName.getText(),txtPDescr.getText(),txtPComposition.getText(),txtPManufacturer.getText(),0f,0f,0,txtHTU.getText(),0);
        productDAO.add(product);
        System.out.println("Da them"+ product.getPName());
    }

    @FXML
    void btnRemove(ActionEvent event) throws SQLException {
        productDAO.remove(txtProductId.getText());
        System.out.println("Da xoa"+txtCatId.getText() );
    }

    @FXML
    void tbnUpdate(ActionEvent event) {

    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
