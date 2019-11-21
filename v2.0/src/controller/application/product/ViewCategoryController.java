package controller.application.product;

import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import pattern.bus.CatBUS;
import pattern.dao.CatDAO;
import pattern.model.Category;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import static java.lang.Integer.parseInt;

public class ViewCategoryController implements Initializable {
    CatBUS catBUS= new CatBUS();
    CatDAO catDAO = new CatDAO();
    @FXML
    private Label lbCatID;

    @FXML
    private Label lbCatName;

    @FXML
    private Label lbDesc;

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnUpdate;
    @FXML
    private Button btnDelete;
    @FXML
    private TextField txtCatId;

    @FXML
    private TextField txtCatName;

    @FXML
    private TextField txtDesc;
    @FXML
    private TableView<Category> tableview;

    @FXML
    private TableColumn<Category, Integer> columnCatId;

    @FXML
    private TableColumn<Category, String> columnCatName;

    @FXML
    private TableColumn<Category, String> columnDesc;

    public ViewCategoryController() {
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initColumn();
        loadTableView();
        tableview.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Category category = tableview.getSelectionModel().getSelectedItem();
                txtCatId.setText(category.getCatID().toString());
                txtCatName.setText(category.getCatName());
                txtDesc.setText(category.getDesc());
            }
        });
    }

    public void initColumn() {
        columnCatId.setCellValueFactory(new PropertyValueFactory<>("CatID"));
        columnCatName.setCellValueFactory(new PropertyValueFactory<>("CatName"));
        columnDesc.setCellValueFactory(new PropertyValueFactory<>("Desc"));
    }

    @FXML
    public void btnAdd(ActionEvent e) {
        if (txtCatName.getText().trim().isEmpty() && txtDesc.getText().trim().isEmpty()) {
            System.out.println("error catname");
            System.out.println("error desc");
        } else if (txtCatName.getText().trim().isEmpty()) {
            System.out.println("error catname");
        } else if (txtDesc.getText().trim().isEmpty()) {
            System.out.println("error desc");
        } else {
            Category category = new Category(0, txtCatName.getText(), txtDesc.getText());
            catBUS.add(category);
            System.out.println("Da them" + category.getCatName());
            loadTableView();
        }

    }

    @FXML
    public void btnDelete(ActionEvent event) {
        Category category = new Category();
        category.setCatID(Integer.valueOf(txtCatId.getText()));
        catBUS.delete(txtCatId.getText());
        System.out.println("Da xoa" + txtCatId.getText());
        loadTableView();
    }

    @FXML
    public void btnUpdate(ActionEvent event) {
        Category category = new Category(parseInt(txtCatId.getText()), txtCatName.getText(), txtDesc.getText());
        catBUS.update(category);
        loadTableView();
    }
    public void loadTableView(){
        List<Category> categories = new ArrayList<>();
        categories = catDAO.getList();
        tableview.refresh();
        tableview.getItems().setAll(categories);
    }
}
