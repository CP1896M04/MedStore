package controller.application.inventory;

import controller.application.product.ViewAddNewProductController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import pattern.dao.InventoryDetailsDAO;
import pattern.dao.InventoryLedgerDAO;
import pattern.dao.ProductDAO;
import pattern.model.InventoryDetails;
import pattern.model.Product;
import pattern.model.ViewProduct;

import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class InventoryDetailController implements Initializable {
    @FXML
    private Button btnAdd;
    @FXML
    private TableView<InventoryDetails> tableview;

    @FXML
    private TableColumn<InventoryDetails, Integer> columnDetailsID;

    @FXML
    private TableColumn<InventoryDetails, String> columnDetailsCode;

    @FXML
    private TableColumn<InventoryDetails,String > columnProductID;

    @FXML
    private TableColumn<InventoryDetails, String> columnPName;

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
    private Button bntCheckLog;

    InventoryDetails inventoryDetails = new InventoryDetails();
    InventoryDetailsDAO inventoryDetailsDAO = new InventoryDetailsDAO();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initColumn();
        loaddataTableview();

    }

    public void loaddataTableview() {
        //System.out.println("vô");
        List<InventoryDetails> inventoryDetails = new ArrayList<>();
        inventoryDetails = inventoryDetailsDAO.getList();
        tableview.getItems().clear();
        tableview.getItems().addAll(inventoryDetails);
    }

   public void initColumn() {
        columnDetailsID.setCellValueFactory(new PropertyValueFactory<>("DetailsID"));
        columnDetailsCode.setCellValueFactory(new PropertyValueFactory<>("DetailsCode"));
        columnProductID.setCellValueFactory(new PropertyValueFactory<>("ProductID"));
        columnPName.setCellValueFactory(new PropertyValueFactory<>("PName"));
        columnPurchasePrice.setCellValueFactory(new PropertyValueFactory<>("PurchasePrice"));
        columnTentativeSalesPrice.setCellValueFactory(new PropertyValueFactory<>("TentativeSalesPrice"));
        columnQuantityBought.setCellValueFactory(new PropertyValueFactory<>("QuantityBought"));
        columnQuantityAvailable.setCellValueFactory(new PropertyValueFactory<>("QuantityAvailable"));
        columnBatchid.setCellValueFactory(new PropertyValueFactory<>("Batchid"));
        columnManufacturedDate.setCellValueFactory(new PropertyValueFactory<>("ManufacturedDate"));
        columnExpiryDate.setCellValueFactory(new PropertyValueFactory<>("ExpiryDate"));

    }
    @FXML
    void btnAddClick(ActionEvent event) throws IOException {
        ViewInventoryDetailAddController viewAddNewProductController = new ViewInventoryDetailAddController();
        FXMLLoader fXMLLoader = new FXMLLoader();
        Parent parent= fXMLLoader.load(getClass().getResource("/view/application/inventory/ViewInventoryAddDetail.fxml").openStream());
        viewAddNewProductController = fXMLLoader.getController();
        Stage stage = new Stage();
        stage.setScene((new Scene(parent)));
        stage.show();
    }
}
