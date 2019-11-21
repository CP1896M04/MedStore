package controller;

import controller.application.InventoryController;
import controller.application.ProductController;
import controller.application.ReportController;
import controller.application.SaleController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ApplicationController implements Initializable {
    @FXML
    private StackPane acContent;

    @FXML
    private AnchorPane acDashBord;

    @FXML
    private BorderPane appContent;

    @FXML
    private AnchorPane acHead;

    @FXML
    private Button btnInventory;

    @FXML
    private Button btnSale;

    @FXML
    private Button btnReport;

    @FXML
    private Button btnProduct;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    @FXML
    public void btnSaleClick() throws IOException {
        FXMLLoader fXMLLoader = new FXMLLoader();
        fXMLLoader.load(getClass().getResource("/view/application/Sale.fxml").openStream());
        SaleController saleController = fXMLLoader.getController();
        //SaleController.bpContent.getStylesheets().add("/style/MainStyle.css");
        AnchorPane acPane = fXMLLoader.getRoot();
        acContent.getChildren().clear();
        acContent.getChildren().add(acPane);
    }
    @FXML
    void btnInventoryClick(ActionEvent event) throws IOException {
        FXMLLoader fXMLLoader = new FXMLLoader();
        InventoryController inventoryController = new InventoryController();
        inventoryController = fXMLLoader.getController();
        fXMLLoader.load(getClass().getResource("/view/application/Inventory.fxml").openStream());

        AnchorPane acPane = fXMLLoader.getRoot();
        acContent.getChildren().clear();
        acContent.getChildren().add(acPane);
    }

    @FXML
    void btnProductClick(ActionEvent event) throws IOException {
        FXMLLoader fXMLLoader = new FXMLLoader();
        fXMLLoader.load(getClass().getResource("/view/application/Product.fxml").openStream());
        ProductController productController = fXMLLoader.getController();
        AnchorPane acPane = fXMLLoader.getRoot();
        acContent.getChildren().clear();
        acContent.getChildren().add(acPane);
    }

    @FXML
    void btnReportClick(ActionEvent event) throws IOException {
        FXMLLoader fXMLLoader = new FXMLLoader();
        fXMLLoader.load(getClass().getResource("/view/application/Report.fxml").openStream());
        ReportController reportController = fXMLLoader.getController();
        AnchorPane acPane = fXMLLoader.getRoot();
        acContent.getChildren().clear();
        acContent.getChildren().add(acPane);
    }

}
