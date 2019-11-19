package controller.application.sale;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import pattern.dao.InventoryLedgerDAO;
import pattern.dao.OderDAO;
import pattern.model.InventoryLedger;
import pattern.model.Order;

import javax.swing.text.TabableView;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

public class ViewSaleHistoryController implements Initializable {
    @FXML
    private TableView<Order> tableview;

    @FXML
    private TableColumn<Order, Integer> columnOrderID;

    @FXML
    private TableColumn<Order, Integer> columnDateKey;

    @FXML
    private TableColumn<Order, Integer> columnStaffID;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initColumn();
        loadData();
    }
    public void loadData(){
        OderDAO oderDAO= new OderDAO();
        List<Order> orders = new ArrayList<>();
        orders = oderDAO.getList();
        tableview.getItems().setAll(orders);
    }
    public void initColumn() {
       columnOrderID.setCellValueFactory(new PropertyValueFactory<>("OrderID"));
       columnDateKey.setCellValueFactory(new PropertyValueFactory<>("DateKey"));
        columnStaffID.setCellValueFactory(new PropertyValueFactory<>("StaffID"));


    }
}
