package lib;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javax.swing.*;

public class leftMenu {
    Image saleIcon  = new Image(getClass().getResourceAsStream("/vendor/icon/sale-icons.png"));
    Image productIcon  = new Image(getClass().getResourceAsStream("/vendor/icon/product-icon.png"));
    Image inventoryIcon  = new Image(getClass().getResourceAsStream("/vendor/icon/inventory-icon.png"));
    Image statisticIcon  = new Image(getClass().getResourceAsStream("/vendor/icon/statistic-icon.png"));
    private static  leftMenu instance = new  leftMenu();
    private leftMenu(){}
    public static leftMenu getInstance(){
        return  instance;
    }
    public void getLeftMenu(TreeView treeView) {
        //Root node menu item
        TreeItem<String> root = new TreeItem<>("Menu");
        //Sale node
        TreeItem<String> nodeSale = new TreeItem<>("Sale", new ImageView(saleIcon));
        TreeItem<String> nodePointOfSale = new TreeItem<>("Point of Sale");
        TreeItem<String> nodeSaleReport = new TreeItem<>("Sale Report");
        nodeSale.getChildren().addAll(nodePointOfSale,nodeSaleReport);
        //Product Node
        TreeItem<String> nodeProduct = new TreeItem<>("Sale", new ImageView(productIcon));
        TreeItem<String> nodeInventory = new TreeItem<>("Inventory", new ImageView(inventoryIcon));
        TreeItem<String> nodeStatistic= new TreeItem<>("Inventory", new ImageView(statisticIcon));
        root.getChildren().addAll(nodeSale,nodeProduct,nodeInventory,nodeStatistic);
        treeView.setRoot(root);
        treeView.setShowRoot(false);
    }
}
