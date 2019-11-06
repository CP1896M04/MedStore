
package application.inventory;


import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.util.StringConverter;
import pattern.dao.InventoryDetailsDAO;
import pattern.dao.ProductDAO;
import pattern.model.InventoryDetails;
import pattern.model.Product;

import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import static java.lang.Integer.parseInt;

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
    private DatePicker dataPickerExpiryDate;

    @FXML
    private Label lbExpiryDate;

    @FXML
    private DatePicker dataPickerManufacturedDate;
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
            inventoryDetails.setManufacturedDate(Date.valueOf(dataPickerManufacturedDate.getValue()));
            inventoryDetails.setExpiryDate(Date.valueOf(dataPickerExpiryDate.getValue()));
            inventorydetailsDAO.add(inventoryDetails);
            System.out.println("da them "+txtDetailsCode.getText());

        } catch (Exception e) {
            System.out.println("Can't update");
        }


    }

    @FXML
    void bntDelete(ActionEvent event) throws SQLException {
        InventoryDetailsDAO inventoryDetailsDAO= new InventoryDetailsDAO();
        inventoryDetailsDAO.remove(txtDetailID.getText());
        System.out.println("DA xoa"+txtDetailsCode.getText());

    }

    @FXML
    void bntUpdate(ActionEvent event) {
        try {
            InventoryDetails inventoryDetails = new InventoryDetails();
            inventoryDetails.setDetailsID(parseInt(txtDetailID.getText()));
            inventoryDetails.setDetailsCode(txtDetailID.getText());
            inventoryDetails.setProductID(comboboxProductID.getSelectionModel().getSelectedItem().getProductID());
            inventoryDetails.setPurchasePrice(Float.valueOf(txtPurchaseprice.getText()));
            inventoryDetails.setTentativeSalesPrice(Float.valueOf(txtTentativeSalesPrice.getText()));
            inventoryDetails.setQuantityBought(Integer.valueOf(txtQuantityBought.getText()));
            inventoryDetails.setQuantityAvailable(Integer.valueOf(txtQuantityAvailable.getText()));
            inventoryDetails.setBatchid(txtBatchid.getText());
            inventoryDetails.setManufacturedDate(Date.valueOf(dataPickerManufacturedDate.getValue()));
            inventoryDetails.setExpiryDate(Date.valueOf(dataPickerExpiryDate.getValue()));
            inventorydetailsDAO.update(inventoryDetails);
            System.out.println("update thanh cong"+txtDetailsCode.getText());

        } catch (Exception e) {
            System.out.println("Can't update");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadData();
        loaddataTableview();
        initColumn();
        tableview.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override

            public void handle(MouseEvent mouseEvent) {
                InventoryDetails inventoryDetails= tableview.getSelectionModel().getSelectedItem();
                txtDetailID.setText(inventoryDetails.getDetailsID().toString());
                txtDetailsCode.setText(inventoryDetails.getDetailsCode());
                comboboxProductID.getValue();
                txtPurchaseprice.setText(inventoryDetails.getPurchasePrice().toString());
                txtTentativeSalesPrice.setText(inventoryDetails.getTentativeSalesPrice().toString());
                txtQuantityBought.setText(String.valueOf(inventoryDetails.getQuantityBought()));
                txtQuantityAvailable.setText(String.valueOf(inventoryDetails.getQuantityAvailable()));
                txtBatchid.setText(inventoryDetails.getBatchid());
                dataPickerExpiryDate.setValue(LocalDate.parse(inventoryDetails.getExpiryDate().toString()));
                dataPickerManufacturedDate.setValue(LocalDate.parse(inventoryDetails.getManufacturedDate().toString()));

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

    public void initColumn(){
       columnDetailsID.setCellValueFactory(new PropertyValueFactory<>("DetailsID"));
        columnDetailsCode.setCellValueFactory(new PropertyValueFactory<>("DetailsCode"));
        columnProductID.setCellValueFactory(new PropertyValueFactory<>("ProductID"));
        columnPurchasePrice.setCellValueFactory(new PropertyValueFactory<>("PurchasePrice"));
        columnTentativeSalesPrice.setCellValueFactory(new PropertyValueFactory<>("TentativeSalesPrice"));
        columnQuantityBought.setCellValueFactory(new PropertyValueFactory<>("QuantityBought"));
        columnQuantityAvailable.setCellValueFactory(new PropertyValueFactory<>("QuantityAvailable"));
        columnBatchid.setCellValueFactory(new PropertyValueFactory<>("columnBatchid"));
        columnManufacturedDate.setCellValueFactory(new PropertyValueFactory<>("ManufacturedDate"));
        columnExpiryDate.setCellValueFactory(new PropertyValueFactory<>("ExpiryDate"));
    }
    public void loaddataTableview(){
     List<InventoryDetails> inventoryDetails= new ArrayList<>();
     inventoryDetails=inventorydetailsDAO.getList();
     tableview.getItems().addAll(inventoryDetails);
    }

    public void loadData() {

        try {
            ProductDAO productDAO = new ProductDAO();
            ObservableList<Product> products = productDAO.getList();
            System.out.println("Size: "+ products.size());
            comboboxProductID.setItems(products);
            comboboxProductID.getSelectionModel().select(0);
            comboboxProductID.setConverter(new StringConverter<Product>() {

                @Override
                public String toString(Product product) {
                    return product.getPName();
                }
                @Override
                public Product fromString(String string) {
                    return comboboxProductID.getItems().stream().filter(ap ->
                            ap.getPName().equals(string)).findFirst().orElse(null);
                }
            });
        } catch ( Exception e ){

        }
    }

}


