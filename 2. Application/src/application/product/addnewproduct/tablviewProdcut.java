package application.product.addnewproduct;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import pattern.dao.ProductDAO;
import pattern.model.Category;
import pattern.model.Product;
import pattern.model.Supplier;
import pattern.model.Unit;

import java.net.URL;
import java.util.ResourceBundle;

public class tablviewProdcut implements Initializable {
    @FXML
    private TableView<Product> tableview;
    @FXML
    private TableColumn<Product, Integer> columnProductID;

    @FXML
    private TableColumn<Category, Integer> columnCatID;

    @FXML
    private TableColumn<Unit, Integer> columnUnitID;

    @FXML
    private TableColumn<Supplier, Integer> columnSupplierID;

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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loaddataTableview();
        initColumn();

        tableview.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                Product product=tableview.getSelectionModel().getSelectedItem();
//               txtProductId.setText(product.getProductID().toString());
//                comboboxCatID.getSelectionModel().getSelectedItem().getCatID();
//                comboboxUnitID.getSelectionModel().getSelectedItem().getUnitID();
//                comboboxSupplierID.getSelectionModel().getSelectedItem().getSupplierID();
//                txtPName.setText(product.getPName());
//                txtPDescr.setText(product.getPDescr());
//                txtPComposition.setText(product.getPComposition());
//                txtPManufacturer.setText(product.getPManufacturer());
//                txtUprice.setText(product.getUPrice().toString());
//                txtUSP.setText(product.getUSP().toString());
//                txtReOrLevel.setText(product.getReOrLevel().toString());
//                txtHTU.setText(product.getHTU());
//                txtDefaultInDose.setText(product.getDefaultInDose().toString());
            }
        });
    }
    public void initColumn() {
        columnProductID.setCellValueFactory(new PropertyValueFactory<>("ProductID"));
        columnCatID.setCellValueFactory(new PropertyValueFactory<>("CatID"));
        columnUnitID.setCellValueFactory(new PropertyValueFactory<>("UnitID"));
        columnSupplierID.setCellValueFactory(new PropertyValueFactory<>("SupplierID"));
        columnPName.setCellValueFactory(new PropertyValueFactory<>("PName"));
        columnPDescr.setCellValueFactory(new PropertyValueFactory<>("PDescr"));
        columnPComposition.setCellValueFactory(new PropertyValueFactory<>("PComposition"));
        columnPManufacturer.setCellValueFactory(new PropertyValueFactory<>("PManufacturerd"));
        columnUprice.setCellValueFactory(new PropertyValueFactory<>("Uprice"));
        columnUSP.setCellValueFactory(new PropertyValueFactory<>("USP"));
        columnReOrLevel.setCellValueFactory(new PropertyValueFactory<>("ReOrLevel"));
        columnHTU.setCellValueFactory(new PropertyValueFactory<>("HTU"));
        columnDefaultInDose.setCellValueFactory(new PropertyValueFactory<>("DefaultInDose"));

    }
    public void loaddataTableview() {
        ProductDAO productDAO = new ProductDAO();
        ObservableList<Product> products = FXCollections.observableArrayList();
        products = productDAO.getList();
        tableview.getItems().clear();
        tableview.getItems().addAll(products);

    }
}
