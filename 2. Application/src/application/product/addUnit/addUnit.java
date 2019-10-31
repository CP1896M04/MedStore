package application.product.addUnit;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
public class addUnit {




        @FXML
        private Label lbUnitID;

        @FXML
        private Label lbUname;

        @FXML
        private Label lbUInStock;

        @FXML
        private Label lbUInOrder;

        @FXML
        private Label lbUInOrderName;

        @FXML
        private Label lbDesc;

        @FXML
        private TextField txtUnitID;

        @FXML
        private TextField txtUname;

        @FXML
        private TextField txtUInStock;

        @FXML
        private TextField txtUInOrder;

        @FXML
        private TextField txtUInOrderName;

        @FXML
        private TextField txtDesc;

        @FXML
        private Button btnAdd;

        @FXML
        private Button btnUpdate;

        @FXML
        private Button btnRemove;

        @FXML
        private TableView<?> tableview;

        @FXML
        private TableColumn<?, ?> columnUnitID;

        @FXML
        private TableColumn<?, ?> columnUname;

        @FXML
        private TableColumn<?, ?> columnUInStock;

        @FXML
        private TableColumn<?, ?> columnUInStockName;

        @FXML
        private TableColumn<?, ?> columnUInOrder;

        @FXML
        private TableColumn<?, ?> columnUInOrderName;

        @FXML
        private TableColumn<?, ?> columnDesc;

        @FXML
        void btnAdd(ActionEvent event) {

        }

        @FXML
        void btnRemove(ActionEvent event) {

        }

        @FXML
        void btnUpdate(ActionEvent event) {

        }

    }


