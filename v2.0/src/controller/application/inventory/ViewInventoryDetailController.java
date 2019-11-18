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

public class ViewInventoryDetailController implements Initializable {
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
    private TableView<ViewProduct> tableview;

    @FXML
    private TableColumn<ViewProduct, Integer> columnDetailsID;

    @FXML
    private TableColumn<ViewProduct, String> columnDetailsCode;

    @FXML
    private TableColumn<ViewProduct, Integer> columnProductID;

    @FXML
    private TableColumn<ViewProduct, String> columnProductName;

    @FXML
    private TableColumn<ViewProduct, Float> columnPurchasePrice;

    @FXML
    private TableColumn<ViewProduct, Float> columnTentativeSalesPrice;

    @FXML
    private TableColumn<ViewProduct, Integer> columnQuantityBought;

    @FXML
    private TableColumn<ViewProduct, Integer> columnQuantityAvailable;

    @FXML
    private TableColumn<ViewProduct, String> columnBatchid;

    @FXML
    private TableColumn<ViewProduct, Date> columnManufacturedDate;

    @FXML
    private TableColumn<ViewProduct, Date> columnExpiryDate;

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
    ProductDAO productDAO = new ProductDAO();

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
            inventoryDetails.setBatchid(String.valueOf(txtBatchid.getText()));
            inventoryDetails.setManufacturedDate(Date.valueOf(dataPickerManufacturedDate.getValue()));
            inventoryDetails.setExpiryDate(Date.valueOf(dataPickerExpiryDate.getValue()));
            inventorydetailsDAO.add(inventoryDetails);
            System.out.println("da them " + txtDetailsCode.getText());
            loaddataTableview();
        } catch (Exception e) {
            System.out.println("Can't update");
        }


    }

    @FXML
    void bntDelete(ActionEvent event) throws SQLException {
        InventoryDetailsDAO inventoryDetailsDAO = new InventoryDetailsDAO();
        inventoryDetailsDAO.remove(txtDetailID.getText());
        System.out.println("DA xoa" + txtDetailsCode.getText());
        loaddataTableview();
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
            inventoryDetails.setBatchid(String.valueOf(txtBatchid.getText()));
            inventoryDetails.setManufacturedDate(Date.valueOf(dataPickerManufacturedDate.getValue()));
            inventoryDetails.setExpiryDate(Date.valueOf(dataPickerExpiryDate.getValue()));
            inventorydetailsDAO.update(inventoryDetails);
            System.out.println("update thanh cong" + txtDetailsCode.getText());
            loaddataTableview();
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
                ViewProduct viewProduct = tableview.getSelectionModel().getSelectedItem();
                txtDetailID.setText(viewProduct.getDetailsID().toString());
                txtDetailsCode.setText(viewProduct.getDetailsCode());
                comboboxProductID.getValue();
                txtPurchaseprice.setText(viewProduct.getPurchasePrice().toString());
                txtTentativeSalesPrice.setText(viewProduct.getTentativeSalesPrice().toString());
                txtQuantityBought.setText(String.valueOf(viewProduct.getQuantityBought()));
                txtQuantityAvailable.setText(String.valueOf(viewProduct.getQuantityAvailable()));
                txtBatchid.setText(String.valueOf(txtBatchid.getText()));
                dataPickerExpiryDate.setValue(LocalDate.parse(viewProduct.getExpiryDate().toString()));
                dataPickerManufacturedDate.setValue(LocalDate.parse(viewProduct.getManufacturedDate().toString()));
            }
        });
    }

    public void initColumn() {
        columnDetailsID.setCellValueFactory(new PropertyValueFactory<>("DetailsID"));
        columnDetailsCode.setCellValueFactory(new PropertyValueFactory<>("DetailsCode"));
        columnProductID.setCellValueFactory(new PropertyValueFactory<>("ProductID"));
        columnProductName.setCellValueFactory(new PropertyValueFactory<>("PName"));
        columnPurchasePrice.setCellValueFactory(new PropertyValueFactory<>("PurchasePrice"));
        columnTentativeSalesPrice.setCellValueFactory(new PropertyValueFactory<>("TentativeSalesPrice"));
        columnQuantityBought.setCellValueFactory(new PropertyValueFactory<>("QuantityBought"));
        columnQuantityAvailable.setCellValueFactory(new PropertyValueFactory<>("QuantityAvailable"));
        columnBatchid.setCellValueFactory(new PropertyValueFactory<>("Batchid"));
        columnManufacturedDate.setCellValueFactory(new PropertyValueFactory<>("ManufacturedDate"));
        columnExpiryDate.setCellValueFactory(new PropertyValueFactory<>("ExpiryDate"));

    }

    public void loaddataTableview() {
        ObservableList<ViewProduct> viewProducts = FXCollections.observableArrayList();
        viewProducts = inventorydetailsDAO.getTableView();
        tableview.getItems().clear();
        tableview.getItems().addAll(viewProducts);

    }

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
