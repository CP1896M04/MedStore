package controller.application.product;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
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
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ViewCurrentProductController implements Initializable {
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
    public void addNewProduct(){
        FXMLLoader fXMLLoader = new FXMLLoader();
        fXMLLoader.setLocation(getClass().getResource("/view/application/product"));
        try {
            fXMLLoader.load();
            Parent parent = fXMLLoader.getRoot();
            Scene scene = new Scene(parent);
            scene.setFill(new Color(0, 0, 0, 0));
            NewSellController newSellController = fXMLLoader.getController();
            media.setId(userId);
            newSellController.setNameMedia(nameMedia);
            newSellController.genarateSellID();
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(ViewCustomerController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
