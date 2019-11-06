
package application.inventory;


import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.util.StringConverter;
import pattern.dao.InventoryDetailsDAO;
import pattern.dao.ProductDAO;
import pattern.model.InventoryDetails;
import pattern.model.Product;

import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.util.ResourceBundle;

public class addInventoryDetails implements Initializable {
    @FXML
    private Label lbDetailsID;

    @FXML
    private TextField txtDetailID;

    @FXML
    private Label lbDetailsCode;

    @FXML
    private TextField txtDetailsCode;

    @FXML
    private Label lbProductID;

    @FXML
    private ComboBox<Product> comboboxProductID;

    @FXML
    private Label lbPurchasePrice;

    @FXML
    private TextField txtPurchaseprice;

    @FXML
    private Label lbTentativeSalesPrice;

    @FXML
    private TextField txtTentativeSalesPrice;

    @FXML
    private TableView<InventoryDetails> tableview;

    @FXML
    private TableColumn<InventoryDetails, Integer> columnDetailsID;

    @FXML
    private TableColumn<InventoryDetails, String> columnDetailsCode;

    @FXML
    private TableColumn<InventoryDetails, Integer> columnProductID;

    @FXML
    private TableColumn<InventoryDetails, Float> columnPurchasePrice;

    @FXML
    private TableColumn<InventoryDetails, Float> columnTentativeSalesPrice;

    @FXML
    private TableColumn<InventoryDetails, Integer> columnQuantityBought;

    @FXML
    private TableColumn<InventoryDetails, Integer> columnQuantityAvailable;

    @FXML
    private TableColumn<InventoryDetails, String> columnBatchid;

    @FXML
    private TableColumn<InventoryDetails, Date> columnManufacturedDate;

    @FXML
    private TableColumn<InventoryDetails, Date> columnExpiryDate;

    @FXML
    private Label lbQuantityBought;

    @FXML
    private TextField txtQuantityBought;

    @FXML
    private Label ldQuantityAvailable;

    @FXML
    private TextField txtQuantityAvailable;

    @FXML
    private Label lbBatchid;

    @FXML
    private TextField txtBatchid;

    @FXML
    private Label lbManufacturedDate;

    @FXML
    private TextField txtManufacturedDate;

    @FXML
    private Label lbExpiryDate;

    @FXML
    private TextField txtExpiryDate;

    @FXML
    private Button bntAdd;

    @FXML
    private Button bntUpdate;

    @FXML
    private Button bntDelete;

    private Connection connection;



    InventoryDetailsDAO inventorydetailsDAO = new InventoryDetailsDAO();

    @FXML
    void bntAdd(ActionEvent event) {
        try {
            InventoryDetails inventoryDetails = new InventoryDetails();
            inventoryDetails.setDetailsID(0);
            inventoryDetails.setDetailsCode(txtDetailID.getText());
            inventoryDetails.setProductID(comboboxProductID.getSelectionModel().getSelectedItem().getProductID());
            inventoryDetails.setPurchasePrice(Float.valueOf(txtPurchaseprice.getText()));
            inventoryDetails.setTentativeSalesPrice(Float.valueOf(txtTentativeSalesPrice.getText()));
            inventoryDetails.setQuantityBought(Integer.valueOf(txtQuantityBought.getText()));
            inventoryDetails.setQuantityAvailable(Integer.valueOf(txtQuantityAvailable.getText()));
            inventoryDetails.setBatchid(txtBatchid.getText());
            inventoryDetails.setManufacturedDate(Date.valueOf(txtManufacturedDate.getText()));
            inventoryDetails.setExpiryDate(Date.valueOf(txtExpiryDate.getText()));


        } catch (Exception e) {
            System.out.println("Can't update");
        }


    }

    @FXML
    void bntDelete(ActionEvent event) {

    }

    @FXML
    void bntUpdate(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadData();
    }

    public void loadData() {
        //Load data to Combobox Product

        ProductDAO productDAO = new ProductDAO();
        ObservableList<Product> products = productDAO.getList();
        comboboxProductID.setItems(products);
        comboboxProductID.getSelectionModel().select(1);
        comboboxProductID.setConverter(new StringConverter<Product>() {
            @Override
            public String toString(Product product) {
                return product.getPName();
            }

            @Override
            public Product fromString(String s) {
                return comboboxProductID.getItems().stream().filter(Product ->
                        Product.getPName().equals(s)).findFirst().orElse(null);
            }
        });


    }

}


