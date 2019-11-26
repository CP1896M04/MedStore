package controller;

import controller.application.*;
import controller.application.sale.ViewPointOfSaleController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import lib.window.application.*;
import lib.window.application.Sale.viewPointOfSaleWindow;
import pattern.model.Staff;

import java.io.IOException;
import java.net.URL;
import java.sql.Statement;
import java.util.Properties;
import java.util.ResourceBundle;

public class ApplicationController extends Controller implements Initializable {
    private Staff staff ;
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

    @FXML
    private Button btnUser;

    @FXML
    private Label txtUsername;

    //Declare Anchor pane
    private AnchorPane HomePane;
    private AnchorPane ProductPane;
    private AnchorPane SalePane;
    private AnchorPane InventoryPane;
    private AnchorPane ReportPane;
    private AnchorPane StaffPane;

    public ApplicationController() {
        super();
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            loadData();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    @FXML
    public void btnSaleClick() throws IOException {
//        FXMLLoader fXMLLoader = new FXMLLoader();
//        SaleController saleController = new SaleController();
//        fXMLLoader.load(getClass().getResource("/view/application/Sale.fxml").openStream());
//        SaleController saleController1 = fXMLLoader.getController();
//        //SaleController.bpContent.getStylesheets().add("/style/MainStyle.css");
//        AnchorPane acPane = fXMLLoader.getRoot();
        active(SalePane);
    }
    @FXML
    void btnInventoryClick(ActionEvent event) throws IOException {
//        FXMLLoader fXMLLoader = new FXMLLoader();
////        InventoryController inventoryController = new InventoryController();
////        inventoryController = fXMLLoader.getController();
////        fXMLLoader.load(getClass().getResource("/view/application/Inventory.fxml").openStream());
////
////        AnchorPane acPane = fXMLLoader.getRoot();
////        acContent.getChildren().clear();
////        acContent.getChildren().add(acPane);
        active(InventoryPane);
    }

    @FXML
    void btnProductClick(ActionEvent event) throws IOException {
//        FXMLLoader fXMLLoader = new FXMLLoader();
//        fXMLLoader.load(getClass().getResource("/view/application/Product.fxml").openStream());
//        ProductController productController = fXMLLoader.getController();
//        AnchorPane acPane = fXMLLoader.getRoot();
//        acContent.getChildren().clear();
//        acContent.getChildren().add(acPane);
        active(ProductPane);
    }

    @FXML
    void btnReportClick(ActionEvent event) throws IOException {
//        FXMLLoader fXMLLoader = new FXMLLoader();
//        fXMLLoader.load(getClass().getResource("/view/application/Report.fxml").openStream());
//        ReportController reportController = fXMLLoader.getController();
//        AnchorPane acPane = fXMLLoader.getRoot();
//        acContent.getChildren().clear();
//        acContent.getChildren().add(acPane);
        active(ReportPane);
    }
    @FXML
    void btnUserClick(ActionEvent event) throws IOException {
//        FXMLLoader fXMLLoader = new FXMLLoader();
//        fXMLLoader.load(getClass().getResource("/view/application/Staff.fxml").openStream());
//        StaffController staffController = fXMLLoader.getController();
//        AnchorPane acPane = fXMLLoader.getRoot();
//        acContent.getChildren().clear();
//        acContent.getChildren().add(acPane);
        active(StaffPane);
    }
    public void setUsrNameMedia(Staff staff){
        this.staff = staff;
       txtUsername.setText("User:"+ staff.getFName()+ " "+ staff.getLName());
    }
    public void loadData() throws Exception {
        //Load Product
        FXMLLoader fXMLLoader = new FXMLLoader();
        ProductController productController = ProductWindow.getInstance();
        fXMLLoader.load(getClass().getResource("/view/application/Product.fxml").openStream());
        productController= fXMLLoader.getController();
        ProductPane = fXMLLoader.getRoot();
        //Load Salepane
        FXMLLoader fXMLLoader1 = new FXMLLoader();
        SaleController saleController = SaleWindow.getInstance();
        fXMLLoader1.load(getClass().getResource("/view/application/Sale.fxml").openStream());
        saleController= fXMLLoader1.getController();
        SalePane = fXMLLoader1.getRoot();
        //Load Inventory
        FXMLLoader fXMLLoader2 = new FXMLLoader();
        InventoryController inventoryController = InventoryWindow.getInstance();
        fXMLLoader2.load(getClass().getResource("/view/application/Inventory.fxml").openStream());
        inventoryController= fXMLLoader2.getController();
        InventoryPane = fXMLLoader2.getRoot();
        // Load Report
        FXMLLoader fXMLLoader3 = new FXMLLoader();
        ReportController reportController = ReportWindow.getInstance();
        fXMLLoader3.load(getClass().getResource("/view/application/Report.fxml").openStream());
        reportController= fXMLLoader3.getController();
        ReportPane = fXMLLoader3.getRoot();
        //Load Staff
        FXMLLoader fXMLLoader4 = new FXMLLoader();
        StaffController staffController = StaffWindow.getInstance();
        fXMLLoader4.load(getClass().getResource("/view/application/Staff.fxml").openStream());
        staffController= fXMLLoader4.getController();
        StaffPane = fXMLLoader4.getRoot();
    }
    public void active(AnchorPane anchorPane){
        acContent.getChildren().clear();
        acContent.getChildren().add(anchorPane);
    }
}
