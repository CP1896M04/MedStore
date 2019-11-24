package controller.application;

import controller.Controller;
import controller.application.inventory.InventoryDetailController;
import controller.application.inventory.ViewInventoryDetailAddController;
import controller.application.inventory.ViewInventoryLogController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import pattern.model.InventoryDetails;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class InventoryController extends Controller implements Initializable  {
    @FXML
    private Text lblHeader;
    @FXML
    private ToggleButton btnInventoryDetail;

    @FXML
    private ToggleButton btnInventoryLog;

    @FXML
    private StackPane spMainContent;

    public InventoryController() {
        super();
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    @FXML
    void btnInventoryDetailClick(ActionEvent event) throws IOException {
        lblHeader.setText("Inventory Details");
        FXMLLoader fXMLLoader = new FXMLLoader();
        InventoryDetailController inventoryDetailController = new InventoryDetailController();
        fXMLLoader.load(getClass().getResource("/view/application/inventory/ViewInventoryDetail.fxml").openStream());
        inventoryDetailController= fXMLLoader.getController();
        AnchorPane acPane = fXMLLoader.getRoot();
        spMainContent.getChildren().clear();
        spMainContent.getChildren().add(acPane);
    }
    @FXML
    void btnInventoryLogClick(ActionEvent event) throws IOException {
        lblHeader.setText("Inventory Log");
        FXMLLoader fXMLLoader = new FXMLLoader();
        ViewInventoryLogController viewInventoryDetailController = new ViewInventoryLogController();
        fXMLLoader.load(getClass().getResource("/view/application/inventory/ViewInventoryLog.fxml").openStream());
         viewInventoryDetailController = fXMLLoader.getController();
        AnchorPane acPane = fXMLLoader.getRoot();
        spMainContent.getChildren().clear();
        spMainContent.getChildren().add(acPane);
    }
}
