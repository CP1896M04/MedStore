package controller.application.product;

import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import pattern.dao.SupplierDao;
import pattern.model.Supplier;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.util.StringConverter;
import pattern.dao.CatDAO;
import pattern.dao.ProductDAO;
import pattern.dao.SupplierDao;
import pattern.dao.UnitDAO;
import pattern.model.Category;
import pattern.model.Product;
import pattern.model.Supplier;
import pattern.model.Unit;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import static java.lang.Integer.parseInt;



public class ViewAddNewProductController implements Initializable {

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnUpdate;

    @FXML
    private Button btnRemove;

    @FXML
    private Label lbProducId;

    @FXML
    private Label lbUnitId;

    @FXML
    private Label lbPName;

    @FXML
    private Label lbCatId;

    @FXML
    private TextField txtProductId;

    @FXML
    private TextField txtPName;

    @FXML
    private Label lbPComposition;

    @FXML
    private Label lbUprice;

    @FXML
    private Label lbUSP;

    @FXML
    private Label lbHTU;

    @FXML
    private Label lbSupplierId;

    @FXML
    private Label lbPDescr;

    @FXML
    private Label lbPManufacturer;

    @FXML
    private Label lbReOrLevel;

    @FXML
    private Label lbDefaultInDose;

    @FXML
    private TextField txtPComposition;

    @FXML
    private TextField txtUprice;

    @FXML
    private TextField txtUSP;

    @FXML
    private TextField txtHTU;

    @FXML
    private TextField txtPDescr;

    @FXML
    private TextField txtPManufacturer;

    @FXML
    private TextField txtReOrLevel;

    @FXML
    private TextField txtDefaultInDose;

    @FXML
    private ComboBox<Category> comboboxCatID;

    @FXML
    private ComboBox<Supplier> comboboxSupplierID;

    @FXML
    private ComboBox<Unit> comboboxUnitID;

    @FXML
    private TableView<Product> tableview;
    @FXML
    private TableColumn<Product, Integer> columnProductID;

    @FXML
    private TableColumn<Product, Integer> columnCatID;

    @FXML
    private TableColumn<Product, Integer> columnUnitID;

    @FXML
    private TableColumn<Product, Integer> columnSupplierID;

    @FXML
    private TableColumn<Product, String> columnPName;

    @FXML
    private TableColumn<Product, String> columnPDescr;

    @FXML
    private TableColumn<Product, String> columnPComposition;

    @FXML
    private TableColumn<Product, String> columnPManufacturer;

    @FXML
    private TableColumn<Product, Float> columnUprice;

    @FXML
    private TableColumn<Product, Float> columnUSP;

    @FXML
    private TableColumn<Product, Integer> columnReOrLevel;

    @FXML
    private TableColumn<Product, String> columnHTU;

    @FXML
    private TableColumn<Product, Integer> columnDefaultInDose;
    ProductDAO productDAO = new ProductDAO();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadData();
//        initColumn();
//        loaddataTableview();

    }
    /**
     * @param
     * @return none
     */
    //Load data
    public void loadData() {
        //Load data to Combobox Supplier
        SupplierDao supplierDao = new SupplierDao();
        ObservableList<Supplier> suppliers = supplierDao.getList();
        comboboxSupplierID.setItems(suppliers);
        comboboxSupplierID.getSelectionModel().select(1);
        comboboxSupplierID.setConverter(new StringConverter<Supplier>() {
            @Override
            public String toString(Supplier supplier) {
                return supplier.getComName();
            }

            @Override
            public Supplier fromString(String string) {
                return comboboxSupplierID.getItems().stream().filter(ap ->
                        ap.getComName().equals(string)).findFirst().orElse(null);
            }
        });
       /* comboboxSupplierID.valueProperty().addListener((obs, oldval, newval) -> {
            if(newval != null)
                System.out.println("Selected supplier: " + newval.getComName()
                        + ". ID: " + newval.getSupplierID());
        });*/
        //Load data to Combobox CategoryID
        CatDAO catDAO = new CatDAO();
        ObservableList<Category> categories = catDAO.getList();
        comboboxCatID.setItems(categories);
        comboboxCatID.getSelectionModel().select(1);
        comboboxCatID.setConverter(new StringConverter<Category>() {
            @Override
            public String toString(Category category) {
                return category.getCatName();
            }

            @Override
            public Category fromString(String string) {
                return comboboxCatID.getItems().stream().filter(ap ->
                        ap.getCatName().equals(string)).findFirst().orElse(null);
            }
        });
        //Load data to Combobox UnitID
        UnitDAO unitDAO = new UnitDAO();
        ObservableList<Unit> units = unitDAO.getList();
        comboboxUnitID.setItems(units);
        comboboxUnitID.getSelectionModel().select(1);
        comboboxUnitID.setConverter(new StringConverter<Unit>() {
            @Override
            public String toString(Unit unit) {
                return unit.getUname();
            }

            @Override
            public Unit fromString(String string) {
                return comboboxUnitID.getItems().stream().filter(ap ->
                        ap.getUname().equals(string)).findFirst().orElse(null);
            }
        });
    }
    @FXML
    void btnAddClick(ActionEvent event) throws IOException {
        try {
            Product product = new Product();
            product.setProductID(0);
            product.setPName(txtPName.getText());
            product.setCatID(comboboxCatID.getSelectionModel().getSelectedItem().getCatID());
            product.setSupplierID(comboboxSupplierID.getSelectionModel().getSelectedItem().getSupplierID());
            product.setUnitID(comboboxUnitID.getSelectionModel().getSelectedItem().getUnitID());
            product.setPComposition(txtPComposition.getText());
            product.setUprice(Float.valueOf(txtUprice.getText()));
            product.setUSP(Float.valueOf(txtUSP.getText()));
            product.setReOrLevel(Integer.valueOf(txtReOrLevel.getText()));
            product.setDefaultInDose(Integer.valueOf(txtDefaultInDose.getText()));
            product.setPManufacturer(txtPManufacturer.getText());
            product.setPDescr(txtPDescr.getText());
            product.setHTU(txtHTU.getText());
            productDAO.add(product);
            System.out.println("Da add" + txtPName.getText());
        } catch (Exception e) {
            System.out.println("Can't update");
        }
    }
    @FXML
    void btnRemove(ActionEvent event) throws SQLException {
        Product product = new Product();
        productDAO.remove(txtProductId.getText());
        System.out.println("Da xoa" + txtPName.getText());
    }

    @FXML
    void btnUpdate(ActionEvent event) {
        try {
            Product product = new Product();
            product.setProductID(parseInt(txtProductId.getText()));
            product.setPName(txtPName.getText());
            product.setCatID(comboboxCatID.getSelectionModel().getSelectedItem().getCatID());
            product.setSupplierID(comboboxSupplierID.getSelectionModel().getSelectedItem().getSupplierID());
            product.setUnitID(comboboxUnitID.getSelectionModel().getSelectedItem().getUnitID());
            product.setPComposition(txtPComposition.getText());
            product.setUprice(Float.valueOf(txtUprice.getText()));
            product.setUSP(Float.valueOf(txtUSP.getText()));
            product.setReOrLevel(Integer.valueOf(txtReOrLevel.getText()));
            product.setDefaultInDose(Integer.valueOf(txtDefaultInDose.getText()));
            product.setPManufacturer(txtPManufacturer.getText());
            product.setPDescr(txtPDescr.getText());
            product.setHTU(txtHTU.getText());
            productDAO.update(product);
            System.out.println("Da updade" + txtPName.getText());
        }catch (Exception e){
            System.out.println("Can't update");
        }
    }
    void SetData(Product product){
        txtDefaultInDose.setText(product.getDefaultInDose().toString());
        txtHTU.setText(product.getHTU());
        txtPComposition.setText(product.getPComposition());
        txtPDescr.setText(product.getPDescr());
        txtPManufacturer.setText(product.getPManufacturer());
        txtPName.setText(product.getPName());
        txtProductId.setText(product.getProductID().toString());
        txtReOrLevel.setText(product.getReOrLevel().toString());
        txtUprice.setText(product.getUprice().toString());
        txtUSP.setText(product.getUSP().toString());
    }
}
