package controller.application;

import controller.application.sale.ViewPointOfSaleController;
import controller.application.sale.ViewSaleHistoryController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import lib.window.application.Sale.ViewSaleHistoryWindow;
import lib.window.application.Sale.viewPointOfSaleWindow;
import pattern.model.Staff;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SaleController implements Initializable {
    private Staff staff;
    @FXML
    private StackPane spMainContent;
    @FXML
    private Text lblHeader;
    @FXML
    private ToggleButton btnPointOSale;

    @FXML
    private ToggleButton btnSaleHis;
    private AnchorPane PointOfSalePane;
    private AnchorPane SaleHistoryPane;
    FXMLLoader fXMLLoader2 = new FXMLLoader();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Create a ToggleGroup
        ToggleGroup toggleGroup = new ToggleGroup();
        // Add all ToggleButtons to the ToggleGroup
        toggleGroup.getToggles().addAll(btnPointOSale, btnSaleHis);
        toggleGroup.selectToggle(btnPointOSale);
        try {
            loadData();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void btnPointOSaleClick(ActionEvent event) throws Exception {
//        lblHeader.setText("Point of Sale");
//        ViewPointOfSaleController viewPointOfSaleController = viewPointOfSaleWindow.getInstance();
//        FXMLLoader fXMLLoader = new FXMLLoader();
//        fXMLLoader.load(getClass().getResource("/view/application/sale/ViewPointOfSale.fxml").openStream());
//        ViewPointOfSaleController viewPointOfSaleController1 = fXMLLoader.getController();
//        viewPointOfSaleController.setStaff(staff);
//        AnchorPane acPane = fXMLLoader.getRoot();
//        spMainContent.getChildren().clear();
//        spMainContent.getChildren().add(acPane);
//        lblHeader.setText("Point of Sale");
//        spMainContent.getChildren().clear();
//        spMainContent.getChildren().add(PointOfSalePane);
        active(PointOfSalePane,"Point of Sale");
    }

    @FXML
    void btnSaleHisClick(ActionEvent event) throws IOException {
//        lblHeader.setText("Sale history");
//        FXMLLoader fXMLLoader = new FXMLLoader();
//        fXMLLoader.load(getClass().getResource("/view/application/sale/ViewSaleHistory.fxml").openStream());
//        ViewSaleHistoryController viewSaleHistoryController = new ViewSaleHistoryController();
//        AnchorPane acPane = fXMLLoader.getRoot();
//        spMainContent.getChildren().clear();
//        spMainContent.getChildren().add(acPane);
//        lblHeader.setText("Sale history");
//        spMainContent.getChildren().clear();
//        spMainContent.getChildren().add(SaleHistoryPane);
         active(SaleHistoryPane,"Sale History");
    }
    public void setStaff(Staff staff){
        this.staff =staff;
        System.out.println(staff.getStaffCode());
    }
    public void loadData() throws Exception {
        //Loadpoitofsale
        FXMLLoader fXMLLoader1 = new FXMLLoader();
        ViewPointOfSaleController viewPointOfSaleController = viewPointOfSaleWindow.getInstance();
        fXMLLoader1.load(getClass().getResource("/view/application/sale/ViewPointOfSale.fxml").openStream());
        ViewPointOfSaleController viewPointOfSaleController1 = fXMLLoader1.getController();
        viewPointOfSaleController.setStaff(staff);
        PointOfSalePane = fXMLLoader1.getRoot();
       // spMainContent.getChildren().clear();
        //spMainContent.getChildren().add(acPane);
        //Load SaleHis
        lblHeader.setText("Sale history");
        FXMLLoader fXMLLoader = new FXMLLoader();
        ViewSaleHistoryController viewSaleHistoryController = ViewSaleHistoryWindow.getInstance();
        fXMLLoader.load(getClass().getResource("/view/application/sale/ViewSaleHistory.fxml").openStream());
        viewSaleHistoryController = fXMLLoader.getController();
        SaleHistoryPane = fXMLLoader.getRoot();
       // spMainContent.getChildren().clear();
      //  spMainContent.getChildren().add(acPane);

    }
    public void active(AnchorPane anchorPane,String tile){
        lblHeader.setText(tile);
        spMainContent.getChildren().clear();
        spMainContent.getChildren().add(anchorPane);
    }

}
