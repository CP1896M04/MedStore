package controller.application.inventory;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import pattern.dao.InventoryLedgerDAO;
import pattern.list.InventoryLedgerList;
import pattern.model.InventoryLedger;
import pattern.viewDAO.ViewInventoryLedgerDAO;

import java.net.URL;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ViewInventoryLogController implements Initializable {
    @FXML
    private TableView<InventoryLedgerList> tableview;

    @FXML
    private TableColumn<InventoryLedgerList, Integer> columnLegerID;

    @FXML
    private TableColumn<InventoryLedgerList, Integer> columnProductID;

    @FXML
    private TableColumn<InventoryLedgerList, String> columnPName;

    @FXML
    private TableColumn<InventoryLedgerList, Character> columnTransactionType;

    @FXML
    private TableColumn<InventoryLedgerList, Integer> columnQuantityTransacted;

    @FXML
    private TableColumn<InventoryLedgerList, Float> columnInventoryPurchaseCost;

    @FXML
    private TableColumn<InventoryLedgerList, Date> columnDateTime;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initColumn();
        loadDatatableview();
    }
    public void loadDatatableview(){
        ViewInventoryLedgerDAO viewInventoryLedgerDAO = new ViewInventoryLedgerDAO();
        List<InventoryLedgerList> inventoryLedgerLists = new ArrayList<>();
        inventoryLedgerLists = viewInventoryLedgerDAO.getList();
        tableview.getItems().setAll(inventoryLedgerLists);
    }
    public void initColumn() {
        columnLegerID.setCellValueFactory(new PropertyValueFactory<>("LegerID"));
        columnProductID.setCellValueFactory(new PropertyValueFactory<>("ProductID"));
        columnPName.setCellValueFactory(new PropertyValueFactory<>("PName"));
        columnTransactionType.setCellValueFactory(new PropertyValueFactory<>("TransactionType"));
        columnQuantityTransacted.setCellValueFactory(new PropertyValueFactory<>("QuantityTransacted"));
        columnInventoryPurchaseCost.setCellValueFactory(new PropertyValueFactory<>("InventoryPurchaseCost"));
        columnDateTime.setCellValueFactory(new PropertyValueFactory<>("DateTime"));
    }
}
