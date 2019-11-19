package controller.application.product;

import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import pattern.bus.UnitBUS;
import pattern.connection.ConnectionFactory;
import pattern.dao.UnitDAO;
import pattern.model.Unit;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import static java.lang.Integer.parseInt;

public class ViewUnitController implements Initializable {

    @FXML
    private Label lbUnitID;

    @FXML
    private Label lbUname;

    @FXML
    private Label lbUInStock;

    @FXML
    private Label lbUInStockName;

    @FXML
    private Label lbUInOrder;

    @FXML
    private Label lbUInOrderName;

    @FXML
    private Label lbDesc;

    @FXML
    private TextField txtUnitID;

    @FXML
    private TextField txtUname;

    @FXML
    private TextField txtUInStock;

    @FXML
    private TextField txtUInStockName;

    @FXML
    private TextField txtUInOrder;

    @FXML
    private TextField txtUInOrderName;

    @FXML
    private TextField txtDesc;

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnUpdate;

    @FXML
    private Button btnRemove;

    @FXML
    private TableView<Unit> tableview;

    @FXML
    private TableColumn<Unit, Integer> columnUnitID;

    @FXML
    private TableColumn<Unit, String> columnUname;

    @FXML
    private TableColumn<Unit, Integer> columnUInStock;

    @FXML
    private TableColumn<Unit, String> columnUInStockName;

    @FXML
    private TableColumn<Unit, Integer> columnUInOrder;

    @FXML
    private TableColumn<Unit, String> columnUInOrderName;

    @FXML
    private TableColumn<Unit,String> columnDesc;
    UnitDAO unitDAO= new UnitDAO();
    UnitBUS unitBUS= new UnitBUS();
    private Connection connection;

    public ViewUnitController() {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connection =connectionFactory.getConnection();
    }

    @FXML
    void btnAdd(ActionEvent event) {
        Unit unit= new Unit(0,txtUname.getText(),parseInt(txtUInStock.getText()),txtUInStockName.getText(),parseInt(txtUInOrder.getText()),txtUInOrderName.getText(),txtDesc.getText());
        unitBUS.add(unit);
        System.out.println("Da them"+txtUname.getText());
        loadTableview();
    }

    @FXML
    void btnRemove(ActionEvent event) throws SQLException {
        unitDAO.remove(txtUnitID.getText());
        System.out.println("đã xóa"+txtUnitID.getText());
        loadTableview();
    }

    @FXML
    void btnUpdate(ActionEvent event) {
        Unit unit= new Unit(parseInt(txtUnitID.getText()),txtUname.getText(),parseInt(txtUInStock.getText()),txtUInStockName.getText(),parseInt(txtUInOrder.getText()),txtUInOrderName.getText(),txtDesc.getText());
        unitDAO.update(unit);
        System.out.println("đã update"+txtUname.getText());
        loadTableview();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initColumn();

        tableview.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                Unit unit= tableview.getSelectionModel().getSelectedItem();
                txtUnitID.setText(unit.getUnitID().toString());
                txtUname.setText(unit.getUname());
                txtUInOrder.setText(unit.getUInOrder().toString());
                txtUInOrderName.setText(unit.getUInOrderName());
                txtUInStock.setText(unit.getUInStock().toString());
                txtUInStockName.setText(unit.getUInStockName());
                txtDesc.setText(unit.getDesc());
            }
        });

        loadTableview();
    }
    public void loadTableview(){
        List<Unit> units = new ArrayList<>();
        units=unitDAO.getList();
        tableview.getItems().setAll(units);
    }
    public void initColumn(){
        columnUnitID.setCellValueFactory(new PropertyValueFactory<>("UnitID"));
        columnUname.setCellValueFactory(new PropertyValueFactory<>("Uname"));
        columnUInStock.setCellValueFactory(new PropertyValueFactory<>("UInStock"));
        columnUInStockName.setCellValueFactory(new PropertyValueFactory<>("UInStockName"));
        columnUInOrder.setCellValueFactory(new PropertyValueFactory<>("UInOrder"));
        columnUInOrderName.setCellValueFactory(new PropertyValueFactory<>("UInOrderName"));
        columnDesc.setCellValueFactory(new PropertyValueFactory<>("Desc"));
    }
}
