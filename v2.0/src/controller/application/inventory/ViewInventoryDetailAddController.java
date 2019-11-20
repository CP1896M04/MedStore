package controller.application.inventory;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.util.StringConverter;
import pattern.bus.InventoryDetailsBUS;
import pattern.dao.InventoryDetailsDAO;
import pattern.dao.ProductDAO;
import pattern.model.InventoryDetails;
import pattern.model.Product;
import pattern.model.ViewProduct;

import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;

import static java.lang.Integer.parseInt;

public class ViewInventoryDetailAddController implements Initializable {
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadData();
    }
    @FXML
    private Label lbDetailsID;

    @FXML
    private Label lbDetailsCode;

    @FXML
    private Label lbProductID;

    @FXML
    private Label lbPName;

    @FXML
    private Label lbPurchasePrice;

    @FXML
    private Label lbTentativeSalesPrice;

    @FXML
    private Label lbQuantityBought;

    @FXML
    private Label ldQuantityAvailable;

    @FXML
    private Label lbBatchid;

    @FXML
    private Label lbManufacturedDate;

    @FXML
    private Label lbExpiryDate;

    @FXML
    private ComboBox<Product> comboboxProductID;

    @FXML
    private TextField txtDetailsCode;

    @FXML
    private TextField txtDetailID;

    @FXML
    private TextField txtPName;

    @FXML
    private TextField txtPurchaseprice;

    @FXML
    private TextField txtTentativeSalesPrice;

    @FXML
    private TextField txtQuantityBought;

    @FXML
    private TextField txtQuantityAvailable;

    @FXML
    private TextField txtBatchid;

    @FXML
    private DatePicker dataPickerManufacturedDate;

    @FXML
    private DatePicker dataPickerExpiryDate;

    private Connection connection;

    InventoryDetailsDAO inventorydetailsDAO = new InventoryDetailsDAO();
    InventoryDetailsBUS inventoryDetailsBUS = new InventoryDetailsBUS();
    ProductDAO productDAO = new ProductDAO();

   @FXML
    void bntAdd(ActionEvent event) {
        try {
            InventoryDetails inventoryDetails = new InventoryDetails();
           // inventoryDetails.setDetailsID(0);
            inventoryDetails.setDetailsCode(txtDetailID.getText());
            inventoryDetails.setProductID(comboboxProductID.getSelectionModel().getSelectedItem().getProductID());
            inventoryDetails.setPurchasePrice(Float.valueOf(txtPurchaseprice.getText()));
            inventoryDetails.setTentativeSalesPrice(Float.valueOf(txtTentativeSalesPrice.getText()));
            inventoryDetails.setQuantityBought(Integer.valueOf(txtQuantityBought.getText()));
            inventoryDetails.setQuantityAvailable(Integer.valueOf(txtQuantityBought.getText()));
            inventoryDetails.setBatchid(String.valueOf(txtBatchid.getText()));
            inventoryDetails.setManufacturedDate(Date.valueOf(dataPickerManufacturedDate.getValue()));
            inventoryDetails.setExpiryDate(Date.valueOf(dataPickerExpiryDate.getValue()));
            inventorydetailsDAO.add(inventoryDetails);
            System.out.println("da them " + txtDetailsCode.getText());
             //     loaddataTableview();
        } catch (Exception e) {
            System.out.println("Can't update");
        }


    }

//
//    @Override
//    public void initialize(URL url, ResourceBundle resourceBundle) {
//        loadData();
//        loaddataTableview();
//        initColumn();
//        tableview.setOnMousePressed(new EventHandler<MouseEvent>() {
//            @Override
//            public void handle(MouseEvent mouseEvent) {
//                ViewProduct viewProduct = tableview.getSelectionModel().getSelectedItem();
//                txtDetailID.setText(viewProduct.getDetailsID().toString());
//                txtDetailsCode.setText(viewProduct.getDetailsCode());
//                comboboxProductID.getValue();
//                txtPurchaseprice.setText(viewProduct.getPurchasePrice().toString());
//                txtTentativeSalesPrice.setText(viewProduct.getTentativeSalesPrice().toString());
//                txtQuantityBought.setText(String.valueOf(viewProduct.getQuantityBought()));
//                txtQuantityAvailable.setText(String.valueOf(viewProduct.getQuantityAvailable()));
//                txtBatchid.setText(String.valueOf(txtBatchid.getText()));
//                dataPickerExpiryDate.setValue(LocalDate.parse(viewProduct.getExpiryDate().toString()));
//                dataPickerManufacturedDate.setValue(LocalDate.parse(viewProduct.getManufacturedDate().toString()));
//            }
//        });
//    }
//
//    public void initColumn() {
//        columnDetailsID.setCellValueFactory(new PropertyValueFactory<>("DetailsID"));
//        columnDetailsCode.setCellValueFactory(new PropertyValueFactory<>("DetailsCode"));
//        columnProductID.setCellValueFactory(new PropertyValueFactory<>("ProductID"));
//        columnProductName.setCellValueFactory(new PropertyValueFactory<>("PName"));
//        columnPurchasePrice.setCellValueFactory(new PropertyValueFactory<>("PurchasePrice"));
//        columnTentativeSalesPrice.setCellValueFactory(new PropertyValueFactory<>("TentativeSalesPrice"));
//        columnQuantityBought.setCellValueFactory(new PropertyValueFactory<>("QuantityBought"));
//        columnQuantityAvailable.setCellValueFactory(new PropertyValueFactory<>("QuantityAvailable"));
//        columnBatchid.setCellValueFactory(new PropertyValueFactory<>("Batchid"));
//        columnManufacturedDate.setCellValueFactory(new PropertyValueFactory<>("ManufacturedDate"));
//        columnExpiryDate.setCellValueFactory(new PropertyValueFactory<>("ExpiryDate"));
//
//    }
//
//    public void loaddataTableview() {
//        ObservableList<ViewProduct> viewProducts = FXCollections.observableArrayList();
//        viewProducts = inventorydetailsDAO.getTableView();
//        tableview.getItems().clear();
//        tableview.getItems().addAll(viewProducts);
//    }
//
    public void loadData() {
        try {
            ProductDAO productDAO = new ProductDAO();
            ObservableList<Product> products = productDAO.getList();
            System.out.println("Size: " + products.size());
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
        } catch (Exception e) {

        }
    }
}
