package application.inventory.status;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import pattern.dao.CatDAO;
import pattern.dao.ProductDAO;
import pattern.model.Category;
import pattern.model.Product;

import java.net.URL;
import java.util.ResourceBundle;

public class InventoryStatusPresenter implements Initializable {
    @FXML
    private TreeView<String> productTree;

    @FXML
    private TableView<?> tableview;

    @FXML
    private TableColumn<?, ?> columnDetailsID;

    @FXML
    private TableColumn<?, ?> columnDetailsCode;

    @FXML
    private TableColumn<?, ?> columnProductID;

    @FXML
    private TableColumn<?, ?> columnPurchasePrice;

    @FXML
    private TableColumn<?, ?> columnTentativeSalesPrice;

    @FXML
    private TableColumn<?, ?> columnQuantityBought;

    @FXML
    private TableColumn<?, ?> columnQuantityAvailable;

    @FXML
    private TableColumn<?, ?> columnBatchid;

    @FXML
    private TableColumn<?, ?> columnManufacturedDate;

    @FXML
    private TableColumn<?, ?> columnExpiryDate;

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
