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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Create a ToggleGroup
        ToggleGroup toggleGroup = new ToggleGroup();
        // Add all ToggleButtons to the ToggleGroup
        toggleGroup.getToggles().addAll(btnPointOSale, btnSaleHis);
        toggleGroup.selectToggle(btnPointOSale);
    }

    @FXML
    void btnPointOSaleClick(ActionEvent event) throws IOException {
        lblHeader.setText("Point of Sale");
        ViewPointOfSaleController viewPointOfSaleController = new ViewPointOfSaleController();
        FXMLLoader fXMLLoader = new FXMLLoader();
        fXMLLoader.load(getClass().getResource("/view/application/sale/ViewPointOfSale.fxml").openStream());
        ViewPointOfSaleController viewPointOfSaleController1 = fXMLLoader.getController();
        viewPointOfSaleController.setStaff(staff);
        AnchorPane acPane = fXMLLoader.getRoot();
        spMainContent.getChildren().clear();
        spMainContent.getChildren().add(acPane);
    }

    @FXML
    void btnSaleHisClick(ActionEvent event) throws IOException {
        lblHeader.setText("Sale history");
        FXMLLoader fXMLLoader = new FXMLLoader();
        fXMLLoader.load(getClass().getResource("/view/application/sale/ViewSaleHistory.fxml").openStream());
        ViewSaleHistoryController viewSaleHistoryController = new ViewSaleHistoryController();
        AnchorPane acPane = fXMLLoader.getRoot();
        spMainContent.getChildren().clear();
        spMainContent.getChildren().add(acPane);

    }
    public void setStaff(Staff staff){
        this.staff =staff;
    }

}
