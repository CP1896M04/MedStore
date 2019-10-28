package application.product.addcategory;

import javafx.event.EventHandler;
import javafx.fxml.Initializable;

import javafx.event.ActionEvent;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import pattern.dao.CatDAO;
import pattern.model.Category;

public class AddCategoryPresenter implements Initializable {
    CatDAO catDAO= new CatDAO();
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

        public AddCategoryPresenter() {
        }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initColumn();
        List<Category> categories = new ArrayList<>();
        categories=catDAO.getList();
        tableview.getItems().setAll(categories);
        tableview.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
//                System.out.println("hello");
                Category category=tableview.getSelectionModel().getSelectedItem();
                txtCatId.setText(category.setCatID());
            }
        });
    }
    public void initColumn(){
        columnCatId.setCellValueFactory(new PropertyValueFactory<>("CatID"));
        columnCatName.setCellValueFactory(new PropertyValueFactory<>("CatName"));
        columnDesc.setCellValueFactory(new PropertyValueFactory<>("Desc"));
    }
    public void loadData(){

    }
@FXML
    public void  btnAdd(ActionEvent e){
    Category category = new Category(0, txtCatName.getText(),txtDesc.getText());
    catDAO.add(category);
    System.out.println("Da them"+ category.getCatName());

}
@FXML
    public void  btnDelete(ActionEvent event){
    catDAO.remove(txtCatId.getText());
    System.out.println("Da them"+txtCatId.getText() );

}
}
