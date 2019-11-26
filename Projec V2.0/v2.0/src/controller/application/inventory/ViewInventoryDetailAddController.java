package controller.application.inventory;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.StageStyle;
import javafx.util.StringConverter;
import javafx.util.converter.LocalDateStringConverter;
import lib.LibraryAssistant;
import pattern.bus.InventoryDetailsBUS;
import pattern.dao.DateTagDAO;
import pattern.dao.InventoryDetailsDAO;
import pattern.dao.InventoryLedgerDAO;
import pattern.dao.ProductDAO;
import pattern.model.*;

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

    @FXML
    private Button btnInventoryInsert;

    //Product Selected by user
    Product selectedProduct = new Product();
    private Connection connection;
    InventoryDetailsBUS inventoryDetailsBUS = new InventoryDetailsBUS();
    ProductDAO productDAO = new ProductDAO();

    @FXML
    void btnInventoryInsertClick(ActionEvent event) {
        if(txtQuantityBought.getText().trim().isEmpty()||txtBatchid.getText().trim().isEmpty()||!LibraryAssistant.ktSo(txtQuantityBought.getText())){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Error Unit");
            alert.setHeaderText("Error");
            alert.setContentText("input is not valid");
            alert.initStyle(StageStyle.UNDECORATED);
            alert.showAndWait();
        }else{
            try {
                InventoryDetails inventoryDetails = new InventoryDetails();
                // inventoryDetails.setDetailsID(0);
                inventoryDetails.setDetailsCode(txtDetailsCode.getText());
                inventoryDetails.setProductID(comboboxProductID.getSelectionModel().getSelectedItem().getProductID());
                inventoryDetails.setPName(txtPName.getText());
                inventoryDetails.setPurchasePrice(Float.valueOf(txtPurchaseprice.getText()));
                inventoryDetails.setTentativeSalesPrice(Float.valueOf(txtTentativeSalesPrice.getText()));
                inventoryDetails.setQuantityBought(Integer.valueOf(txtQuantityBought.getText()));
                inventoryDetails.setQuantityAvailable(Integer.valueOf(txtQuantityBought.getText()));
                inventoryDetails.setBatchid(String.valueOf(txtBatchid.getText()));
                inventoryDetails.setManufacturedDate(Date.valueOf(dataPickerManufacturedDate.getValue()));
                inventoryDetails.setExpiryDate(Date.valueOf(dataPickerExpiryDate.getValue()));
                inventoryDetails.setStatus("Working");
                inventoryDetailsBUS.add(inventoryDetails);
                DateTagDAO dateTagDAO = new DateTagDAO();
                DateTag dateTag = new DateTag();
                LibraryAssistant.formatDate(dateTag);
                addLeger(inventoryDetails,dateTagDAO.procInsert(dateTag));
                //System.out.println("da them " + txtDetailsCode.getText());
                //     loaddataTableview();
            } catch (Exception e) {
                e.printStackTrace();

            }
        }

    }

    public void loadData() {
        try {
            //Initialize combobox
            ProductDAO productDAO = new ProductDAO();
            ObservableList<Product> products = productDAO.getList();
            System.out.println("Size: " + products.size());
            comboboxProductID.setItems(products);
            comboboxProductID.getSelectionModel().select(0);
            // Add ChangeListeners to the selectedItem and selectedIndex
            // properties of the selection model
            comboboxProductID.getSelectionModel().selectedItemProperty()
                    .addListener(this::productChanged);
            comboboxProductID.getSelectionModel().selectedIndexProperty()
                    .addListener(this::indexChanged);
            // Update the message Label when the value changes
            comboboxProductID.setOnAction(e -> valueChanged(comboboxProductID));
//            comboboxProductID.setConverter(new StringConverter<Product>() {
//                @Override
//                public String toString(Product product) {
//                    return product.getPName();
//                }
//
//                @Override
//                public Product fromString(String string) {
//                    return comboboxProductID.getItems().stream().filter(ap ->
//                            ap.getPName().equals(string)).findFirst().orElse(null);
//                }
//            });
            //Date Time Picker Get the current value
            dataPickerExpiryDate.setValue(LocalDate.now());
            dataPickerManufacturedDate.setValue(LocalDate.now());
            //Text change
            // Add a ChangeListener to the text property
            txtBatchid.textProperty().addListener(this::changed);
            // Set ActionEvent handlers for both fields
            txtBatchid.setOnAction(e -> txtChanged(txtBatchid));

        } catch (Exception e) {

        }
    }
    public void valueChanged(ComboBox<Product> list) {
        Product p = list.getValue();
        selectedProduct =p;
        txtPName.setText(p.getPName());
        txtPurchaseprice.setText(p.getUSP().toString());
        txtTentativeSalesPrice.setText(p.getUSP().toString());
        txtDetailsCode.setText(p.getPName());
    }
    // A change listener to track the change in item selection
    public void productChanged(ObservableValue<? extends Product> observable,
                               Product oldValue,
                               Product newValue) {
        System.out.println("Itemchanged: old = " + oldValue +
                ", new = " + newValue);
    }
    // A change listener to track the change in index selection
    public void indexChanged(ObservableValue<? extends Number> observable,
                             Number oldValue,
                             Number newValue) {
        System.out.println("Indexchanged: old = " + oldValue + ", new = " + newValue);
    }
    public void txtChanged(TextField textField) {

    }
    public void changed(ObservableValue<? extends String> prop,
                        String oldValue,
                        String newValue) {
        txtDetailsCode.setText(txtPName.getText().concat("-"+ newValue));
    }
    public void setProduct(InventoryDetails i){
        txtDetailsCode.setText(i.getDetailsCode());

    }
    public void addLeger(InventoryDetails inventoryDetails, int datTagID){
        InventoryLedgerDAO inventoryLedgerDAO = new InventoryLedgerDAO();
        InventoryLedger inventoryLedger = new InventoryLedger();
        inventoryLedger.setLegerCode(inventoryDetails.getProductID()+"-"+datTagID);
        Float cost = inventoryDetails.getPurchasePrice()*inventoryDetails.getQuantityBought();
        inventoryLedger.setInventoryPurchaseCost(cost);
        inventoryLedger.setProductID(inventoryDetails.getProductID());
        inventoryLedger.setQuantityTransacted(inventoryDetails.getQuantityBought());
        inventoryLedger.setDateTag(datTagID);
        inventoryLedger.setTransactionType("I");
        inventoryLedgerDAO.add(inventoryLedger);
    }
}
