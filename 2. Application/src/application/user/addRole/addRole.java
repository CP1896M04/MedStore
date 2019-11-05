package application.user.addRole;
    import javafx.event.ActionEvent;
    import javafx.event.EventHandler;
    import javafx.fxml.FXML;
    import javafx.fxml.Initializable;
    import javafx.scene.control.*;
    import javafx.scene.control.cell.PropertyValueFactory;
    import javafx.scene.input.MouseEvent;
    import pattern.dao.RoleDAO;
    import pattern.model.Role;

    import java.net.URL;
    import java.sql.SQLException;
    import java.util.ArrayList;
    import java.util.List;
    import java.util.ResourceBundle;

    import static java.lang.Integer.parseInt;

public class addRole implements Initializable {
    @FXML
    private Label lbRoleID;

    @FXML
    private Label lbRoleName;

    @FXML
    private TextField txtRoleID;

    @FXML
    private TextField txtRoleName;
    @FXML
    private TableView<Role> tableview;
    @FXML
    private TableColumn<Role, Integer> columnRoleID;

    @FXML
    private TableColumn<Role, String> columnRoleName;

    @FXML
    private TableColumn<Role, String> columnDescr;

    @FXML
    private Label lbDescr;

    @FXML
    private TextField txtDescr;

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnUpdate;

    @FXML
    private Button btnRemove;
    RoleDAO roleDAO= new RoleDAO();
    @FXML
    void btnAdd(ActionEvent event) {
        Role role= new Role(0,txtRoleName.getText(),txtDescr.getText());
        roleDAO.add(role);
        System.out.println("da add"+txtRoleName.getText());
        loadData();
    }

    @FXML
    void btnRemove(ActionEvent event) throws SQLException {
    roleDAO.remove(txtRoleID.getText());
        System.out.println( "da xoa"+txtRoleID.getText());
        loadData();
    }

    @FXML
    void btnUpdate(ActionEvent event) {
        Role role= new Role(parseInt(txtRoleID.getText()),txtRoleName.getText(),txtDescr.getText());
        roleDAO.update(role);
        System.out.println("da update"+ txtRoleName.getText());
        loadData();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
            initColumn();
        loadData();
        tableview.setOnMousePressed(new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent mouseEvent) {
            Role role= tableview.getSelectionModel().getSelectedItem();
            txtRoleID.setText(role.getRoleID().toString());
           txtRoleName.setText(role.getRoleName());
            txtDescr.setText(role.getDescr());
        }
    });


    }
    public void initColumn(){
        columnRoleID.setCellValueFactory(new PropertyValueFactory<>("RoleID"));
        columnRoleName.setCellValueFactory(new PropertyValueFactory<>("RoleName"));
        columnDescr.setCellValueFactory(new PropertyValueFactory<>("Descr"));

    }
    public  void loadData(){
        List<Role> roles = new ArrayList<>();
        roles =roleDAO.getList();
        tableview.getItems().setAll(roles);
    }
}


