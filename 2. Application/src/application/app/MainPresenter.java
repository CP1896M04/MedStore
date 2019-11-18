package application.app;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import lib.LibraryAssistant;
import lib.control.ComboBoxAutoComplete;
import lib.window.*;
import pattern.dao.DateTagDAO;
import pattern.dao.ODetailDAO;
import pattern.dao.OderDAO;
import pattern.dao.ProductDAO;
import pattern.model.DateTag;
import pattern.model.ODetail;
import pattern.model.Order;
import pattern.model.Product;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import static java.lang.Integer.parseInt;

public class MainPresenter implements Initializable {
    @FXML
    private AnchorPane statusBar;

    @FXML
    private MenuBar menu;

    @FXML
    private javafx.scene.control.TreeView<String> treeView;

    @FXML
    private VBox container;


    @FXML
    private TextField txtHtu;


    @FXML
    private ComboBox<Product> cbProductName;

    @FXML
    private TextField txtUSP;

    @FXML
    private TextField txtQty;

    @FXML
    private TextField txtDay;

    @FXML
    private Label txtProductName;
    @FXML
    private Label lbProductID;

    @FXML
    private TableView<ODetail> viewOrderdetail;

    @FXML
    private TableColumn<ODetail, Integer> colProductID;

    @FXML
    private TableColumn<ODetail, String> colProductName;

    @FXML
    private TableColumn<ODetail, Float> colUPS;

    @FXML
    private TableColumn<ODetail, String> colHTU;

    @FXML
    private TableColumn<ODetail, Integer> colQty;

    @FXML
    private TableColumn<ODetail, Float> colDiscount;

    @FXML
    private TableColumn<ODetail, Double> colTotal;

    @FXML
    private TextField txtDiscount;

    private ODetailDAO oDetailDAO = new ODetailDAO();
    ObservableList<ODetail> oDetails = FXCollections.observableArrayList();
    public void initialize(URL location, ResourceBundle resources) {
        lib.LeftMenu instance = lib.LeftMenu.getInstance();
        instance.getLeftMenu(treeView);
        Button button = new Button("Add");
        statusBar.getChildren().addAll(button);
        loadData();
        intColumn();
    }

    public void loadData() {
        ProductDAO productDAO = new ProductDAO();
        List<Product> persons = productDAO.getList();
        cbProductName.setTooltip(new Tooltip());
        cbProductName.getItems().addAll(persons);
        new ComboBoxAutoComplete<Product>(cbProductName);
//        cbProductName.setConverter(new StringConverter<Product>() {
//            @Override
//            public String toString(Product product) {
//                return null;
//            }
//
//            @Override
//            public Product fromString(String string) {
//                return cbProductName.getItems().stream().filter(ap ->
//                        ap.getPNamed().equals(string)).findFirst().orElse(null);
//            }
//        });
        cbProductName.valueProperty().addListener((obs, oldval, newval) -> {
            if (newval != null) {
                try {
                    List<Product> products = productDAO.searchProductByID(newval.getProductID());
                    Product product = products.get(0);
                    txtHtu.setText(product.getHTU().toString());
                    int days = parseInt(txtDay.getText());
                    int numbers = product.getDefaultInDose() * days;
                    txtQty.setText(String.valueOf(numbers));
                    txtUSP.setText(product.getUSP().toString());
                    txtProductName.setText(product.getPName().toString());
                    lbProductID.setText(product.getProductID().toString());
                } catch (Exception e) {

                }
            }
        });


    }

    @FXML
    public void intColumn() {
        colProductID.setCellValueFactory(new PropertyValueFactory<>("ProductID"));
        colProductName.setCellValueFactory(new PropertyValueFactory<>("PName"));
        colUPS.setCellValueFactory(new PropertyValueFactory<>("UPS"));
        colHTU.setCellValueFactory(new PropertyValueFactory<>("HTU"));
        colQty.setCellValueFactory(new PropertyValueFactory<>("Qty"));
        colDiscount.setCellValueFactory(new PropertyValueFactory<>("Discount"));
        colTotal.setCellValueFactory(new PropertyValueFactory<>("Total"));
    }

    @FXML
    public void clickBtnInsert() {
        ODetail oDetail = new ODetail();
        Integer productID = Integer.valueOf(lbProductID.getText());
        Boolean exist = false;
        for(ODetail thisoDetail:oDetails){
            if(thisoDetail.getProductID()==productID){
                    exist =true;
                    thisoDetail.setQty(Integer.valueOf(txtQty.getText())+ thisoDetail.getQty());
                     Float preTotal = thisoDetail.getQty()*thisoDetail.getUPS();
                    thisoDetail.setTotal((float) (preTotal*(1-thisoDetail.getDiscount())));
            }
        }
        if(!exist){
            oDetail.setProductID(Integer.valueOf(lbProductID.getText()));
            oDetail.setPName(cbProductName.getSelectionModel().getSelectedItem().getPName());
            oDetail.setUPS(Float.valueOf(txtUSP.getText()));
            System.out.println(txtUSP.getText());
            oDetail.setHTU(txtHtu.getText());
            oDetail.setQty(Integer.valueOf(txtQty.getText()));
            oDetail.setDiscount((Double.valueOf(txtDiscount.getText()))/100);
            Float preTotal = oDetail.getQty()*oDetail.getUPS();
            oDetail.setTotal((float) (preTotal*(1-oDetail.getDiscount())));
            oDetails.add(oDetail);
        }
        viewOrderdetail.setItems(oDetails);
        viewOrderdetail.refresh();
    }

    @FXML
    private void saveOrder(){
        OderDAO oderDAO = new OderDAO();
        DateTagDAO dateTagDAO = new DateTagDAO();
        DateTag dateTag = new DateTag();
        LibraryAssistant.formatDate(dateTag);
        ODetailDAO oDetailDAO = new ODetailDAO();
        Order order = new Order();
        order.setDateKey(dateTagDAO.procInsert(dateTag));
        order.setStaffID(1);
        int oderID=oDetailDAO.insertProc();
      for (ODetail oDetail : oDetails){
          oDetail.setOrderID(oderID);
          oDetailDAO.add(oDetail); }
    }

    @FXML
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
                Stage stage1 = addCategory.getInstance();
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
                Stage RoleStage = addRole.getInstance();
                RoleStage.setScene((new Scene(RoleParent)));
                RoleStage.show();
                break;
            case "Add Staff":
                Parent StaffParent = FXMLLoader.load(getClass().getResource("/application/product/addStaff/addStaff.fxml"));
                Stage StaffStage = addStaff.getInstance();
                StaffStage.setScene((new Scene(StaffParent)));
                StaffStage.show();
                break;
            case "InventoryDetails":
                Parent InventoryDetailsParent = FXMLLoader.load(getClass().getResource("/application/inventory/addInventoryDetails.fxml"));
                Stage InventoryDetailsStage = InventoryDetails.getInstance();
                InventoryDetailsStage.setScene((new Scene(InventoryDetailsParent)));
                InventoryDetailsStage.show();
                break;
            case "InventoryStatus":
                Parent InventoryStatusParent = FXMLLoader.load(getClass().getResource("/application/inventory/status/inventoryStatus.fxml"));
                Stage InventoryStatusStage = InventoryStatus.getInstance();
                InventoryStatusStage.setScene((new Scene(InventoryStatusParent)));
                InventoryStatusStage.show();
                break;
        }
    }

    @FXML
    void loadWindow(String loc, String title) {
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
