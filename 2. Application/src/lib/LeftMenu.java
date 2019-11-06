package lib;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class LeftMenu {
    Image saleIcon  = new Image(getClass().getResourceAsStream("/vendor/icon/sale-icons.png"));
    Image productIcon  = new Image(getClass().getResourceAsStream("/vendor/icon/product-icon.png"));
    Image inventoryIcon  = new Image(getClass().getResourceAsStream("/vendor/icon/inventory-icon.png"));
    Image statisticIcon  = new Image(getClass().getResourceAsStream("/vendor/icon/statistic-icon.png"));
    private static LeftMenu instance = new LeftMenu();
    private LeftMenu(){}
    public static LeftMenu getInstance(){
        if (instance==null){
            instance = new LeftMenu();
        }
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
        TreeItem<String> nodeProduct = new TreeItem<>("Product", new ImageView(productIcon));
        TreeItem<String> nodeAddProduct = new TreeItem<>("Add Product");
        TreeItem<String> nodeAddCategory = new TreeItem<>("Add Category");
        TreeItem<String> nodeSupplier= new TreeItem<>("Supplier Manage");
        TreeItem<String> nodeUnit= new TreeItem<>("Add Unit");
        TreeItem<String> nodeRole= new TreeItem<>("Add Role");
        TreeItem<String> nodeStaff= new TreeItem<>("Add Staff");
        nodeProduct.getChildren().addAll(nodeAddProduct,nodeAddCategory,nodeSupplier,nodeUnit,nodeRole,nodeStaff);
        TreeItem<String> nodeInventory = new TreeItem<>("Inventory", new ImageView(inventoryIcon));
        TreeItem<String> nodeInventoryDetails= new TreeItem<>("InventoryDetails");
        nodeInventory.getChildren().addAll(nodeInventoryDetails);
        TreeItem<String> nodeStatistic= new TreeItem<>("Inventory", new ImageView(statisticIcon));
        root.getChildren().addAll(nodeSale,nodeProduct,nodeInventory,nodeStatistic);
        treeView.setRoot(root);
        treeView.setShowRoot(false);
    }
}
