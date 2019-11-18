package controller.application.inventory;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import pattern.dao.InventoryLedgerDAO;
import pattern.model.InventoryLedger;

import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

public class ViewInventoryLogController implements Initializable {
    @FXML
    private TableView<InventoryLedger> tableview;

    @FXML
    private TableColumn<InventoryLedger, Integer> columnLegerID;

    @FXML
    private TableColumn<InventoryLedger, String> columnLegerCode;

    @FXML
    private TableColumn<InventoryLedger, Integer> columnProductID;

    @FXML
    private TableColumn<InventoryLedger, String> columnTransactionType;

    @FXML
    private TableColumn<InventoryLedger, Integer> columnQuantityTransacted;

    @FXML
    private TableColumn<InventoryLedger, Float> columnInventoryPurchaseCost;

    @FXML
    private TableColumn<InventoryLedger, Date> columnDateTime;

    @FXML
    private TableColumn<InventoryLedger,Integer> columnDateKey;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initColumn();
        loadDatatableview();
    }
    public void loadDatatableview(){
        InventoryLedgerDAO inventoryLedgerDAO= new InventoryLedgerDAO();
        List<InventoryLedger> inventoryledgers = new ArrayList<>();
        inventoryledgers = inventoryLedgerDAO.getList();
        tableview.getItems().setAll(inventoryledgers);
    }
    public void initColumn() {
        columnLegerID.setCellValueFactory(new PropertyValueFactory<>("LegerID"));
        columnLegerCode.setCellValueFactory(new PropertyValueFactory<>("LegerCode"));
        columnProductID.setCellValueFactory(new PropertyValueFactory<>("ProductID"));
        columnTransactionType.setCellValueFactory(new PropertyValueFactory<>("TransactionType"));
        columnQuantityTransacted.setCellValueFactory(new PropertyValueFactory<>("QuantityTransacted"));
        columnInventoryPurchaseCost.setCellValueFactory(new PropertyValueFactory<>("InventoryPurchaseCost"));
        columnDateTime.setCellValueFactory(new PropertyValueFactory<>("DateTime"));
        columnDateKey.setCellValueFactory(new PropertyValueFactory<>("DateKey"));

    }
}
