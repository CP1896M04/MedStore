
package application.inventory;


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
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
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
<<<<<<< HEAD
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
            }
        });
    }
=======

    private Connection connection;


    InventoryDetailsDAO inventorydetailsDAO = new InventoryDetailsDAO();
    ProductDAO productDAO = new ProductDAO();
>>>>>>> fd7101e52d30e629bdd7bd8f86a115fea32f328c

    @FXML
    void bntAdd(ActionEvent event) {

        InventoryDetailsDAO inventorydetailsDAO = new InventoryDetailsDAO();
        try {
            InventoryDetails inventoryDetails = new InventoryDetails();
            inventoryDetails.setDetailsID(0);
            inventoryDetails.setDetailsCode(txtDetailsCode.getText());
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
<<<<<<< HEAD
//        System.out.println("Chay");

        InventoryDetailsDAO inventorydetailsDAO = new InventoryDetailsDAO();
//            InventoryDetails inventoryDetails = new InventoryDetails(parseInt(txtDetailID.getText()),txtDetailsCode.getText(),comboboxProductID.getSelectionModel().getSelectedItem().getProductID(),Float.valueOf(txtPurchaseprice.getText()),Float.valueOf(txtTentativeSalesPrice.getText()),Integer.valueOf(txtQuantityBought.getText()),Integer.valueOf(txtQuantityAvailable.getText()),txtBatchid.getText(),Date.valueOf(dataPickerManufacturedDate.getValue()),Date.valueOf(dataPickerExpiryDate.getValue()));
            InventoryDetails inventoryDetails = new InventoryDetails();
            try{
                inventoryDetails.setDetailsID(parseInt(txtDetailID.getText()));
                inventoryDetails.setDetailsCode(txtDetailsCode.getText());
                inventoryDetails.setProductID(comboboxProductID.getSelectionModel().getSelectedItem().getProductID());
                inventoryDetails.setPurchasePrice(Float.valueOf(txtPurchaseprice.getText()));
                inventoryDetails.setTentativeSalesPrice(Float.valueOf(txtTentativeSalesPrice.getText()));
                inventoryDetails.setQuantityBought(Integer.valueOf(txtQuantityBought.getText()));
                inventoryDetails.setQuantityAvailable(Integer.valueOf(txtQuantityAvailable.getText()));
                inventoryDetails.setBatchid(txtBatchid.getText());
                inventoryDetails.setManufacturedDate(Date.valueOf(dataPickerManufacturedDate.getValue()));
                inventoryDetails.setExpiryDate(Date.valueOf(dataPickerExpiryDate.getValue()));
                inventorydetailsDAO.update(inventoryDetails);
                System.out.println("update thanh cong"+txtDetailID.getText());
                loaddataTableview();
            }catch ( Exception e ){
                e.printStackTrace();
=======
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
>>>>>>> fd7101e52d30e629bdd7bd8f86a115fea32f328c
            }
        loaddataTableview();


    }

<<<<<<< HEAD

    public void initColumn(){
       columnDetailsID.setCellValueFactory(new PropertyValueFactory<>("DetailsID"));
=======
    public void initColumn() {
        columnDetailsID.setCellValueFactory(new PropertyValueFactory<>("DetailsID"));
>>>>>>> fd7101e52d30e629bdd7bd8f86a115fea32f328c
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
<<<<<<< HEAD
    public void loaddataTableview(){

        InventoryDetailsDAO inventorydetailsDAO = new InventoryDetailsDAO();
     List<InventoryDetails> inventoryDetails= new ArrayList<>();
     inventoryDetails=inventorydetailsDAO.getList();
     tableview.getItems().clear();
     tableview.getItems().addAll(inventoryDetails);
=======

    public void loaddataTableview() {
        ObservableList<ViewProduct> viewProducts = FXCollections.observableArrayList();
        viewProducts = inventorydetailsDAO.getTableView();
        tableview.getItems().clear();
        tableview.getItems().addAll(viewProducts);
>>>>>>> fd7101e52d30e629bdd7bd8f86a115fea32f328c

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


