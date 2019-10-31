package application.product.addsupplier;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;



import pattern.connection.ConnectionFactory;
import pattern.dao.SupplierDao;
import pattern.model.Supplier;


import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;


import static java.lang.Integer.parseInt;

public class SupplierManagerPresenter implements Initializable {

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnUpdate;

    @FXML
    private Button btnRemove;

    @FXML
    private TableView<Supplier> tableview;

    @FXML
    private TableColumn<Supplier, Integer> columnSupplierId;

    @FXML
    private TableColumn<Supplier, String> columnComCode;

    @FXML
    private TableColumn<Supplier, String> columnComName;

    @FXML
    private TableColumn<Supplier, String> columnAddress;

    @FXML
    private TableColumn<Supplier, String > columnPhone;

    @FXML
    private TableColumn<Supplier, String > columnEmail;

    @FXML
    private TableColumn<Supplier, String> columnTax;
    private ObservableList<Supplier> data;

    @FXML
    private Label lbSupplierId;

    @FXML
    private Label lbComCode;

    @FXML
    private Label lbComName;

    @FXML
    private Label lbAddress;

    @FXML
    private Label lbPhone;

    @FXML
    private Label lbEmail;

    @FXML
    private Label lbTax;

    @FXML
    private TextField txtSupplierId;

    @FXML
    private TextField txtComCode;

    @FXML
    private TextField txtComName;

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtPhone;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtTax;
SupplierDao supplierDao= new SupplierDao();
    private Connection connection;
    public SupplierManagerPresenter() {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connection =connectionFactory.getConnection();
    }

    @FXML
    void btnAdd(ActionEvent event) {

        Supplier supplier= new Supplier(0,txtComCode.getText(),txtComName.getText(),txtAddress.getText(),txtPhone.getText(),txtEmail.getText(),txtTax.getText());
        supplierDao.add(supplier);
        System.out.println(supplier.toString());
        System.out.println("Da them"+ supplier.getComName());
        loadTableview();

    }

    @FXML
    void btnRemove(ActionEvent event) throws  SQLException {
    supplierDao.remove(txtSupplierId.getText());
        System.out.println("Da xoa"+txtSupplierId.getText());
        loadTableview();

    }

    @FXML
    void btnUpdate(ActionEvent event) {
Supplier supplier= new Supplier(parseInt(txtSupplierId.getText()),txtComCode.getText(),txtComName.getText(),txtAddress.getText(),txtPhone.getText(),txtEmail.getText(),txtTax.getText());
    supplierDao.update(supplier);
    loadTableview();
        System.out.println("Da up date"+txtSupplierId.getText());


}
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initColumn();
        loadTableview();
        tableview.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
              Supplier supplier= (Supplier) tableview.getSelectionModel().getSelectedItem();
              txtSupplierId.setText(supplier.getSupplierID().toString());
              txtComCode.setText(supplier.getComCode());
              txtComName.setText(supplier.getComName());
              txtAddress.setText(supplier.getAddress());
              txtPhone.setText(supplier.getPhone());
              txtTax.setText(supplier.getTax());
            }
        });


    }
    public void loadTableview(){
        List<Supplier> suppliers = new ArrayList<>();
        suppliers=supplierDao.getList();
        tableview.getItems().setAll(suppliers);
    }
    public void initColumn(){
    columnSupplierId.setCellValueFactory(new PropertyValueFactory<>("SupplierID"));
    columnComCode.setCellValueFactory(new PropertyValueFactory<>("ComCode"));
    columnComName.setCellValueFactory(new PropertyValueFactory<>("ComName"));
    columnAddress.setCellValueFactory(new PropertyValueFactory<>("Address"));
    columnEmail.setCellValueFactory(new PropertyValueFactory<>("Email"));
    columnPhone.setCellValueFactory(new PropertyValueFactory<>("Phone"));
    columnTax.setCellValueFactory(new PropertyValueFactory<>("Tax"));
    }
//
//    private PreparedStatement pst = null;
//    private ResultSet rs = null;
//    private void loadDataFromDatabase() {
//
//        try {
//           pst = connection.prepareStatement("select * from Supplier");
//            rs = pst.executeQuery();
//            while (rs.next()) {
//                data.add(new Supplier(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7)));
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(SupplierManagerPresenter.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        tableview.setItems(data);
//    }

}