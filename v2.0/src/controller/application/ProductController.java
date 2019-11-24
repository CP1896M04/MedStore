package controller.application;

import controller.application.product.ViewCategoryController;
import controller.application.product.ViewCurrentProductController;
import controller.application.product.ViewSupplierCotroller;
import controller.application.product.ViewUnitController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import lib.window.application.product.ViewCategoryWindow;
import lib.window.application.product.ViewCurrentProductWindow;
import lib.window.application.product.ViewSupplierWindow;
import lib.window.application.product.ViewUnitWindow;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ProductController implements Initializable {
    @FXML
    private Text lblHeader;

    @FXML
    private StackPane spMainContent;

    @FXML
    private AnchorPane acHeadStore;

    @FXML
    private ToggleButton btnProduct;


    @FXML
    private ToggleButton btnSupplier;


    @FXML
    private ToggleButton btnCategory;

    @FXML
    private ToggleButton btnUnit;

    private  AnchorPane acCurrentProduct;

    private AnchorPane acSupplier;

    private  AnchorPane acUnit;

    private  AnchorPane acCategory;

    static FXMLLoader fXMLLoader = new FXMLLoader();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Create a ToggleGroup
        ToggleGroup toggleGroup = new ToggleGroup();
        // Add all ToggleButtons to the ToggleGroup
        toggleGroup.getToggles().addAll(btnProduct,btnSupplier,btnCategory,btnUnit);
        toggleGroup.selectToggle(btnProduct);
        try {

            loadData();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @FXML
    void btnCategoryClick(ActionEvent event) throws IOException {
//        lblHeader.setText("Category");
//        ViewCategoryController viewCategoryController = new ViewCategoryController();
//        FXMLLoader fXMLLoader = new FXMLLoader();
//        fXMLLoader.load(getClass().getResource("/view/application/product/ViewCategory.fxml").openStream());
//        viewCategoryController = fXMLLoader.getController();
//        AnchorPane acPane = fXMLLoader.getRoot();
//        spMainContent.getChildren().clear();
//        spMainContent.getChildren().add(acPane);
        active(acCategory,"Category");
    }

    @FXML
    void loadCurrentProduct() throws IOException {
//        lblHeader.setText("Current Product");
//        ViewCurrentProductController viewCurrentProductController = new ViewCurrentProductController();
//        FXMLLoader fXMLLoader = new FXMLLoader();
//        fXMLLoader.load(getClass().getResource("/view/application/product/ViewCurrentProduct.fxml").openStream());
//        ViewCurrentProductController viewCurrentProductController1 = fXMLLoader.getController();
//        AnchorPane acPane = fXMLLoader.getRoot();
//        spMainContent.getChildren().clear();
//        spMainContent.getChildren().add(acPane);
        active(acCurrentProduct,"Current Product");
    }

    @FXML
    void btnSupplierClick(ActionEvent event) throws IOException {
//        lblHeader.setText("Supplier");
//        ViewSupplierCotroller vsc = new ViewSupplierCotroller();
//        FXMLLoader fXMLLoader = new FXMLLoader();
//        fXMLLoader.load(getClass().getResource("/view/application/product/ViewSupplier.fxml").openStream());
//        ViewSupplierCotroller viewSupplyerController = fXMLLoader.getController();
//        AnchorPane acPane = fXMLLoader.getRoot();
//        spMainContent.getChildren().clear();
//        spMainContent.getChildren().add(acPane);
        active(acSupplier,"Supplier");
    }

    @FXML
    void btnUnitClick(ActionEvent event) throws IOException {
//        lblHeader.setText("Unit");
//        ViewUnitController vsc = new ViewUnitController();
//        FXMLLoader fXMLLoader = new FXMLLoader();
//        fXMLLoader.load(getClass().getResource("/view/application/product/ViewUnit.fxml").openStream());
//        ViewUnitController viewUnitController = fXMLLoader.getController();
//        AnchorPane acPane = fXMLLoader.getRoot();
//        spMainContent.getChildren().clear();
//        spMainContent.getChildren().add(acPane);
        active(acUnit,"Unit");
}

    @FXML
    void btnProductClick(ActionEvent event) throws IOException {
        loadCurrentProduct();
    }
    public void loadData() throws Exception {
        System.out.println("Chay");
        //viewCategory
        FXMLLoader fXMLLoader = new FXMLLoader();
        ViewCategoryController viewCategoryController = ViewCategoryWindow.getInstance();
        fXMLLoader.load(getClass().getResource("/view/application/product/ViewCategory.fxml").openStream());
        viewCategoryController = fXMLLoader.getController();
        acCategory = fXMLLoader.getRoot();
        //viewCurrentProduct
//        FXMLLoader fXMLLoader2 = new FXMLLoader();
//        ViewCurrentProductController viewCurrentProductController = ViewCurrentProductWindow.getInstance();
//        fXMLLoader2.load(getClass().getResource("/view/application/product/ViewCurrentProduct.fxml").openStream());
//        viewCurrentProductController= fXMLLoader2.getController();
//        acCurrentProduct= fXMLLoader2.getRoot();
//        FXMLLoader fXMLLoader2 = new FXMLLoader();
        FXMLLoader fXMLLoader1 = new FXMLLoader();
       ViewCurrentProductController viewCurrentProductController = ViewCurrentProductWindow.getInstance();
        fXMLLoader1.load(getClass().getResource("/view/application/product/ViewCurrentProduct.fxml").openStream());
        viewCurrentProductController = fXMLLoader1.getController();
        acCurrentProduct=fXMLLoader1.getRoot();
//        //viewSupplier
        FXMLLoader fXMLLoader3 = new FXMLLoader();
        ViewSupplierCotroller viewSupplierCotroller = ViewSupplierWindow.getInstance();
        fXMLLoader3.load(getClass().getResource("/view/application/product/ViewSupplier.fxml").openStream());
        viewSupplierCotroller = fXMLLoader3.getController();
        acSupplier= fXMLLoader3.getRoot();
        //viewUnit
        FXMLLoader fXMLLoader4 = new FXMLLoader();
       ViewUnitController viewUnitController = ViewUnitWindow.getInstance();
        fXMLLoader4.load(getClass().getResource("/view/application/product/ViewUnit.fxml").openStream());
       viewUnitController = fXMLLoader4.getController();
        acUnit= fXMLLoader4.getRoot();

    }
    public void active(AnchorPane anchorPane, String tile) {
        lblHeader.setText(tile);
        spMainContent.getChildren().clear();
        spMainContent.getChildren().add(anchorPane);
    }

}
