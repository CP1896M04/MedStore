package controller.application.product;

import controller.application.sale.ViewPointOfSaleController;
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
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import pattern.dao.ProductDAO;
import pattern.model.Category;
import pattern.model.Product;
import pattern.model.Supplier;
import pattern.model.Unit;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ViewCurrentProductController implements Initializable {
    @FXML
    private Button btnUpdate;
    @FXML
    private Button btnAdd;
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
    private  TableColumn<Product,Float> columnUprice;

    @FXML
    private TableColumn<Product, Float> columnUSP;

    @FXML
    private TableColumn<Product, Integer> columnReOrLevel;

    @FXML
    private TableColumn<Product, String> columnHTU;
    @FXML
    private  TableColumn<Product,Integer> columnDefaultInDose;



    public ViewCurrentProductController() {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    initColumn();
    loadData();
    }
    public void loadData(){
        ProductDAO productDAO = new ProductDAO();
        ObservableList<Product> products = FXCollections.observableArrayList();
        products = productDAO.getList();
        tableview.getItems().clear();
        tableview.getItems().addAll(products);
    }
    public void initColumn() {
        columnProductID.setCellValueFactory(new PropertyValueFactory<>("ProductID"));
        columnCatID.setCellValueFactory(new PropertyValueFactory<>("CatID"));
        columnUnitID.setCellValueFactory(new PropertyValueFactory<>("UnitID"));
        columnSupplierID.setCellValueFactory(new PropertyValueFactory<>("SupplierID"));
        columnPName.setCellValueFactory(new PropertyValueFactory<>("PName"));
        columnPDescr.setCellValueFactory(new PropertyValueFactory<>("PDescr"));
        columnPComposition.setCellValueFactory(new PropertyValueFactory<>("PComposition"));
        columnPManufacturer.setCellValueFactory(new PropertyValueFactory<>("PManufacturer"));
        columnUprice.setCellValueFactory(new PropertyValueFactory<>("Uprice"));
        columnUSP.setCellValueFactory(new PropertyValueFactory<>("USP"));
        columnReOrLevel.setCellValueFactory(new PropertyValueFactory<>("ReOrLevel"));
        columnHTU.setCellValueFactory(new PropertyValueFactory<>("HTU"));
        columnDefaultInDose.setCellValueFactory(new PropertyValueFactory<>("DefaultInDose"));
    }
    @FXML
    void addNewProduct(ActionEvent event) throws IOException {
        ViewAddNewProductController viewAddNewProductController = new ViewAddNewProductController();
        FXMLLoader fXMLLoader = new FXMLLoader();
       Parent parent= fXMLLoader.load(getClass().getResource("/view/application/product/ViewAddNewProduct.fxml").openStream());
        viewAddNewProductController = fXMLLoader.getController();
        Stage stage = new Stage();
        stage.setScene((new Scene(parent)));
        stage.show();
    }
    @FXML
    void btnUpdateClick(ActionEvent event) throws IOException {
        ViewAddNewProductController viewAddNewProductController = new ViewAddNewProductController();
         Product product =tableview.getSelectionModel().getSelectedItem();
        FXMLLoader fXMLLoader = new FXMLLoader();
        Parent parent= fXMLLoader.load(getClass().getResource("/view/application/product/ViewAddNewProduct.fxml").openStream());
        viewAddNewProductController = fXMLLoader.getController();
        viewAddNewProductController.SetData(product);
        Stage stage = new Stage();
        stage.setScene((new Scene(parent)));
        stage.show();
    }

}
