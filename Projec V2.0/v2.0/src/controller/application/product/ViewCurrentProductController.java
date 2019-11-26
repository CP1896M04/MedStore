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
import pattern.list.ProductList;
import pattern.model.Category;
import pattern.model.Product;
import pattern.model.Supplier;
import pattern.model.Unit;
import pattern.viewDAO.ViewProductDAO;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ViewCurrentProductController implements Initializable {
    //    @FXML
//    private Button btnUpdate;
//    @FXML
//    private Button btnAdd;
    @FXML
    private TableView<ProductList> tableview;

    @FXML
    private TableColumn< ProductList, Integer> columnProductID;

    @FXML
    private TableColumn<ProductList, String> columnPName;

    @FXML
    private TableColumn<ProductList, String> columnCatName;

    @FXML
    private TableColumn<ProductList, String> columnPDescr;

    @FXML
    private TableColumn<ProductList, String> columnPComposition;

    @FXML
    private TableColumn<ProductList, String> columnPManufacturer;

    @FXML
    private TableColumn<ProductList, Float> columnUprice;

    @FXML
    private TableColumn<ProductList, Float> columnUSP;


    public ViewCurrentProductController() {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        initColumn();
        loadData();
    }
    public void loadData(){
        ViewProductDAO viewProductDAO = new ViewProductDAO();
        ObservableList<ProductList> productLists = FXCollections.observableArrayList();
        productLists = viewProductDAO.getViewProduct();
        tableview.getItems().clear();
        tableview.getItems().addAll(productLists);
    }
    public void initColumn() {
        columnProductID.setCellValueFactory(new PropertyValueFactory<>("ProductID"));
        columnPName.setCellValueFactory(new PropertyValueFactory<>("PName"));
        columnCatName.setCellValueFactory(new PropertyValueFactory<>("CatName"));
        columnPDescr.setCellValueFactory(new PropertyValueFactory<>("PDescr"));
        columnPComposition.setCellValueFactory(new PropertyValueFactory<>("PComposition"));
        columnPManufacturer.setCellValueFactory(new PropertyValueFactory<>("PManufacturer"));
        columnUprice.setCellValueFactory(new PropertyValueFactory<>("Uprice"));
        columnUSP.setCellValueFactory(new PropertyValueFactory<>("USP"));

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
        ProductList productList =tableview.getSelectionModel().getSelectedItem();
        FXMLLoader fXMLLoader = new FXMLLoader();
        Parent parent= fXMLLoader.load(getClass().getResource("/view/application/product/ViewAddNewProduct.fxml").openStream());
        viewAddNewProductController = fXMLLoader.getController();
        Product product = new Product();
        //  viewAddNewProductController.SetData(product);
        Stage stage = new Stage();
        stage.setScene((new Scene(parent)));
        stage.show();
    }
}

