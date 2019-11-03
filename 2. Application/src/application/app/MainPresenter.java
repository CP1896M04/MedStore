package application.app;

import com.gluonhq.charm.glisten.control.AutoCompleteTextField;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


import javafx.scene.input.MouseEvent;
import lib.window.addNewProduct;
import lib.window.addUnit;
import lib.window.supplierManage;
import org.controlsfx.control.textfield.CustomTextField;
import pattern.dao.ProductDAO;
import pattern.model.Product;


import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class MainPresenter implements Initializable {
    @FXML
    private AnchorPane statusBar;

    @FXML
    private MenuBar menu;

    @FXML
    private javafx.scene.control.TreeView<String> treeView ;

    @FXML
    private VBox container;

    @FXML
    private CustomTextField txtProductName;

    public void initialize(URL location, ResourceBundle resources) {
        lib.LeftMenu instance = lib.LeftMenu.getInstance();
            instance.getLeftMenu(treeView);
        Button button = new Button("Add");
        statusBar.getChildren().addAll(button);
    }
    public void loadData(){
        ProductDAO productDAO = new ProductDAO();
        List<Product> strings = productDAO.getList();

    }
    public void selectItems(MouseEvent event) throws Exception {
        TreeItem<String> item = treeView.getSelectionModel().getSelectedItem();
        String nodeName = item.getValue();
       switch (nodeName) {
           case "Add Product":
               Parent parent = FXMLLoader.load(getClass().getResource("/application/product/addnewproduct/addnewproduct.fxml"));
               Stage stage = addNewProduct.getInstance();
               stage.setScene((new Scene(parent)));
               stage.show();
               break;
           case "Add Category":
               Parent parent1 = FXMLLoader.load(getClass().getResource("/application/product/addcategory/addcategory.fxml"));
               Stage stage1 = addNewProduct.getInstance();
               stage1.setScene((new Scene(parent1)));
               stage1.show();
               break;
           case "Supplier Manage":
               Parent supplierManageParent = FXMLLoader.load(getClass().getResource("/application/product/addsupplier/suppliermanager.fxml"));
               Stage supplierManageStage = supplierManage.getInstance();
               supplierManageStage.setScene((new Scene(supplierManageParent)));
               supplierManageStage.show();
               break;
           case "Add Unit":
               Parent unitParent = FXMLLoader.load(getClass().getResource("/application/product/addUnit/addUnit.fxml"));
               Stage unitStage = addUnit.getInstance();
               unitStage.setScene((new Scene(unitParent)));
               unitStage.show();
               break;
           case "Add Role":
               Parent RoleParent = FXMLLoader.load(getClass().getResource("/application/product/addRole/addRole.fxml"));
               Stage RoleStage = addUnit.getInstance();
              RoleStage.setScene((new Scene(RoleParent)));
              RoleStage.show();
               break;
       }
    }
    void loadWindow(String loc, String title){
        try {
            Parent parent = FXMLLoader.load(getClass().getResource(loc));
            Stage stage = new Stage(StageStyle.DECORATED);
            stage.setTitle(title);
            stage.setScene((new Scene(parent)));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
