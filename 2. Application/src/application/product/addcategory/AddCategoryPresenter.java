package application.product.addcategory;

import javafx.fxml.Initializable;

import javafx.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import pattern.dao.CatDAO;
import pattern.model.Category;

public class AddCategoryPresenter implements Initializable {
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
        private TableView<?> tableview;

        @FXML
        private TableColumn<?, ?> columnCatId;

        @FXML
        private TableColumn<?, ?> columnCatName;

        @FXML
        private TableColumn<?, ?> columnDesc;

        public AddCategoryPresenter() {
        }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
@FXML
    public void  btnAdd(ActionEvent e){
    CatDAO catDAO= new CatDAO();
    Category category = new Category(0, txtCatName.getText(),txtDesc.getText());
    catDAO.add(category);
    System.out.println("Da them"+ category.getCatName());

}
}
