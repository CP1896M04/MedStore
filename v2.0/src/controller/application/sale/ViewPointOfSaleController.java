package controller.application.sale;

import controller.application.product.ViewCategoryController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import lib.LibraryAssistant;
import lib.control.ComboBoxAutoComplete;
import pattern.dao.*;
import pattern.model.*;


import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import static java.lang.Integer.parseInt;

public class ViewPointOfSaleController implements Initializable {

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
    private ComboBox<Product> cbProductName;

    @FXML
    private TextField txtDay;

    @FXML
    private TextField txtQty;

    @FXML
    private TextField txtUSP;

    @FXML
    private TextField txtAvailable;

    @FXML
    private TextField txtProductName;

    @FXML
    private Button btnInsert;

    @FXML
    private TextField txtHtu;

    @FXML
    private Label lbProductID;

    @FXML
    private TextField txtDiscount;

    @FXML
    private Button btnNew;

    @FXML
    private Button btnSave;

    @FXML
    private Button btnPrint;

    private ODetailDAO oDetailDAO = new ODetailDAO();
    ObservableList<ODetail> oDetails = FXCollections.observableArrayList();

    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadData();
        intColumn();
    }
    public void loadData() {
        ProductDAO productDAO = new ProductDAO();
        List<Product> persons = productDAO.getList();
        cbProductName.setTooltip(new Tooltip());
        cbProductName.getItems().addAll(persons);
        new ComboBoxAutoComplete<Product>(cbProductName);
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
    public void addToCart() {
        ODetail oDetail = new ODetail();
        Integer productID = Integer.valueOf(lbProductID.getText());
        Boolean exist = false;
        if(lbProductID.getText()!=""){
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
            oDetailDAO.add(oDetail);
            addLeger(oDetail,dateTagDAO.procInsert(dateTag));
        }
        clear();
    }
    public void addLeger(ODetail oDetail,int datTagID){
        InventoryLedgerDAO inventoryLedgerDAO = new InventoryLedgerDAO();
        InventoryLedger inventoryLedger = new InventoryLedger();
        inventoryLedger.setLegerCode(oDetail.getProductID()+"-"+datTagID);
        inventoryLedger.setInventoryPurchaseCost(oDetail.getTotal());
        inventoryLedger.setProductID(oDetail.getProductID());
        inventoryLedger.setQuantityTransacted(oDetail.getQty());
        inventoryLedger.setDateTag(datTagID);
        inventoryLedger.setTransactionType("O");

        inventoryLedgerDAO.add(inventoryLedger);
    }
    @FXML
    void btnNewClick(ActionEvent event) {
        clear();
    }

    public void clear(){
        viewOrderdetail.getItems().clear();
        txtAvailable.clear();
        txtHtu.clear();
        txtProductName.clear();
        txtQty.clear();
        txtUSP.clear();

    }
}
