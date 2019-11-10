package application.inventory.status;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.cell.PropertyValueFactory;
import pattern.dao.CatDAO;
import pattern.dao.InventoryDetailsDAO;
import pattern.dao.ProductDAO;
import pattern.model.Category;
import pattern.model.InventoryDetails;
import pattern.model.Product;

import java.net.URL;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class InventoryStatusPresenter implements Initializable {
    @FXML
    private TreeView<String> productTree;

    @FXML
    private TableView<InventoryDetails> tableview;

    @FXML
    private TableColumn<InventoryDetails, Integer> columnDetailsID;

    @FXML
    private TableColumn<InventoryDetails, String> columnDetailsCode;

    @FXML
    private TableColumn<Product, Integer> columnProductID;
    @FXML
    private TableColumn<Product,String> columnPname;

    @FXML
    private TableColumn<InventoryDetails, Float> columnPurchasePrice;

    @FXML
    private TableColumn<InventoryDetails, Float> columnTentativeSalesPrice;

    @FXML
    private TableColumn<InventoryDetails, Integer> columnQuantityBought;

    @FXML
    private TableColumn<InventoryDetails, Integer> columnQuantityAvailable;

    @FXML
    private TableColumn<InventoryDetails, String> columnBatchid;

    @FXML
    private TableColumn<InventoryDetails, Date> columnManufacturedDate;

    @FXML
    private TableColumn<InventoryDetails, Date> columnExpiryDate;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadData();

    }
    public void loadData(){
        TreeItem<String> root = new TreeItem<>("Product");
        productTree.setRoot(root);
        productTree.setShowRoot(false);
        CatDAO catDAO = new CatDAO();
        ObservableList<Category> categories = catDAO.getList();
        for(Category category : categories){
            TreeItem<String> cat = new TreeItem<>(category.getCatName());
            ProductDAO productDAO = new ProductDAO();
            ObservableList<Product> products = productDAO.getProductInCat(category.getCatID());
            for (Product product: products){
                TreeItem<String> prod = new TreeItem<>(product.getPName());
                cat.getChildren().addAll(prod);
            }
            root.getChildren().addAll(cat);
        }
    }

}
