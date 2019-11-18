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

    static FXMLLoader fXMLLoader = new FXMLLoader();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Create a ToggleGroup
        ToggleGroup toggleGroup = new ToggleGroup();
        // Add all ToggleButtons to the ToggleGroup
        toggleGroup.getToggles().addAll(btnProduct,btnSupplier,btnCategory,btnUnit);
        toggleGroup.selectToggle(btnProduct);
        try {
            loadCurrentProduct();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    void btnCategoryClick(ActionEvent event) throws IOException {
        lblHeader.setText("Category");
        ViewCategoryController viewCategoryController = new ViewCategoryController();
        FXMLLoader fXMLLoader = new FXMLLoader();
        fXMLLoader.load(getClass().getResource("/view/application/product/ViewCategory.fxml").openStream());
        ViewCategoryController viewCategoryControllers = fXMLLoader.getController();
        AnchorPane acPane = fXMLLoader.getRoot();
        spMainContent.getChildren().clear();
        spMainContent.getChildren().add(acPane);
    }

    @FXML
    void loadCurrentProduct() throws IOException {
        lblHeader.setText("Current Product");
        ViewCurrentProductController viewCurrentProductController = new ViewCurrentProductController();
        FXMLLoader fXMLLoader = new FXMLLoader();
        fXMLLoader.load(getClass().getResource("/view/application/product/ViewCurrentProduct.fxml").openStream());
        ViewCurrentProductController viewCurrentProductController1 = fXMLLoader.getController();
        AnchorPane acPane = fXMLLoader.getRoot();
        spMainContent.getChildren().clear();
        spMainContent.getChildren().add(acPane);
    }

    @FXML
    void btnSupplierClick(ActionEvent event) throws IOException {
        lblHeader.setText("Supplier");
        ViewSupplierCotroller vsc = new ViewSupplierCotroller();
        FXMLLoader fXMLLoader = new FXMLLoader();
        fXMLLoader.load(getClass().getResource("/view/application/product/ViewSupplier.fxml").openStream());
        ViewSupplierCotroller viewSupplyerController = fXMLLoader.getController();
        AnchorPane acPane = fXMLLoader.getRoot();
        spMainContent.getChildren().clear();
        spMainContent.getChildren().add(acPane);
    }

    @FXML
    void btnUnitClick(ActionEvent event) throws IOException {
        lblHeader.setText("Unit");
        ViewUnitController vsc = new ViewUnitController();
        FXMLLoader fXMLLoader = new FXMLLoader();
        fXMLLoader.load(getClass().getResource("/view/application/product/ViewUnit.fxml").openStream());
        ViewUnitController viewUnitController = fXMLLoader.getController();
        AnchorPane acPane = fXMLLoader.getRoot();
        spMainContent.getChildren().clear();
        spMainContent.getChildren().add(acPane);
    }

    @FXML
    void btnProductClick(ActionEvent event) throws IOException {
        loadCurrentProduct();
    }
}
