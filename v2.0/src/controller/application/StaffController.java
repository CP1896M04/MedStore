package controller.application;

import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.StageStyle;
import javafx.util.StringConverter;
import lib.LibraryAssistant;
import pattern.dao.RoleDAO;
import pattern.dao.StaffDAO;
import pattern.model.Role;
import pattern.model.Staff;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import static java.lang.Integer.parseInt;

public class StaffController implements Initializable {

    @FXML
    private Label lbStaffID;

    @FXML
    private Label lbStaffCode;

    @FXML
    private Label lbRoleID;

    @FXML
    private Label lbFName;

    @FXML
    private Label lbLName;

    @FXML
    private Label lbDOB;

    @FXML
    private Label lbAddress;

    @FXML
    private Label lbSEX;

    @FXML
    private Label lbPhoneNo;

    @FXML
    private Label lbUsername;

    @FXML
    private Label lbPassword;

    @FXML
    private TextField txtStaffID;

    @FXML
    private TextField txtStaffCode;

    @FXML
    private TextField txtFName;

    @FXML
    private TextField txtLName;

    @FXML
    private DatePicker datePickerDOB;

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtSEX;

    @FXML
    private TextField txtPhoneNo;

    @FXML
    private TextField txtUsername;

    @FXML
    private TextField txtPassword;

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnUpdate;

    @FXML
    private Button btnRemove;
    @FXML
    private ComboBox<Role> comboboxRoleID;
    @FXML
    private TableView<Staff> tableview;
    @FXML
    private TableColumn<Staff, Integer> columnStaffID;

    @FXML
    private TableColumn<Staff, String> columnStaffCode;

    @FXML
    private TableColumn<Role, Integer> columnRoleID;

    @FXML
    private TableColumn<Staff, String> columnFName;

    @FXML
    private TableColumn<Staff, String> columnLName;

    @FXML
    private TableColumn<Staff, Date> columnDOB;

    @FXML
    private TableColumn<Staff, String> columnAddress;

    @FXML
    private TableColumn<Staff, String> columnSEX;

    @FXML
    private TableColumn<Staff, String> columnPhoneNo;

    @FXML
    private TableColumn<Staff, String> columnUsername;

    @FXML
    private TableColumn<Staff, String> columnPassword;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadData();
        initColumn();
        loadDataTableview();
        tableview.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                Staff staff=tableview.getSelectionModel().getSelectedItem();
                txtStaffID.setText(staff.getStaffID().toString());
                txtStaffCode.setText(staff.getStaffCode());
                comboboxRoleID.getSelectionModel().getSelectedItem().getRoleID();
                txtAddress.setText(staff.getAddress());
                txtSEX.setText(staff.getSEX());
                txtFName.setText(staff.getFName());
                txtLName.setText(staff.getLName());
                datePickerDOB.setValue(LocalDate.parse(staff.getDOB().toString()));
                txtPhoneNo.setText(staff.getPhoneNo());
                txtUsername.setText(staff.getUsername());
                txtPassword.setText(staff.getPassword());

            }
        });
    }

    public void loadData() {
        RoleDAO roleDAO = new RoleDAO();
        ObservableList<Role> roles = roleDAO.getList();
        comboboxRoleID.setItems(roles);
        comboboxRoleID.getSelectionModel().select(0);
        comboboxRoleID.setConverter(new StringConverter<Role>() {
            @Override
            public String toString(Role role) {
                return role.getRoleName();
            }
            @Override
            public Role fromString(String string) {
                return comboboxRoleID.getItems().stream().filter(ap ->
                        ap.getRoleName().equals(string)).findFirst().orElse(null);
            }
        });

    }

    StaffDAO staffDAO = new StaffDAO();

    @FXML
    void btnAdd(ActionEvent event) throws IOException {
        Staff staff = new Staff();
        if(txtStaffCode.getText().trim().isEmpty()||txtFName.getText().trim().isEmpty()||txtLName.getText().trim().isEmpty()||txtAddress.getText().trim().isEmpty()||txtSEX.getText().trim().isEmpty()||txtPhoneNo.getText().trim().isEmpty()||txtUsername.getText().trim().isEmpty()||txtPassword.getText().trim().isEmpty()||!LibraryAssistant.validatePhone(txtPhoneNo.getText())){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Error Supplier");
            alert.setHeaderText("Error");
            alert.setContentText("input is not valid");
            alert.initStyle(StageStyle.UNDECORATED);
            alert.showAndWait();
        }else {
            try {
                staff.setStaffID(0);
                staff.setStaffCode(txtStaffCode.getText());
                staff.setRoleID(comboboxRoleID.getSelectionModel().getSelectedItem().getRoleID());
                staff.setFName(txtFName.getText());
                staff.setLName(txtLName.getText());
//            staff.setDOB((Date.valueOf(txtDOB.getText())));
                staff.setDOB((Date.valueOf(datePickerDOB.getValue())));
                staff.setAddress(txtAddress.getText());
                staff.setSEX(txtSEX.getText());
                staff.setPhoneNo(txtPhoneNo.getText());
                staff.setUsername(txtUsername.getText());
                staff.setPassword(txtPassword.getText());
                staffDAO.add(staff);
                System.out.println("Da them" + txtStaffCode.getText());
            } catch ( Exception e ) {
                e.printStackTrace();
            }
        }

        loadDataTableview();
    }

    @FXML
    void btnRemove(ActionEvent event) throws SQLException {
        if(txtStaffID.getText().trim().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Error Supplier");
            alert.setHeaderText("Error");
            alert.setContentText("input is not valid");
            alert.initStyle(StageStyle.UNDECORATED);
            alert.showAndWait();
        }
        Staff staff = new Staff();
        staffDAO.remove(txtStaffID.getText());
        System.out.println("Da xoa" + txtStaffCode.getText());
        loadDataTableview();
    }

    @FXML
    void btnUpdate(ActionEvent event) {
        Staff staff = new Staff();
        if(txtStaffCode.getText().trim().isEmpty()||txtFName.getText().trim().isEmpty()||txtLName.getText().trim().isEmpty()||txtAddress.getText().trim().isEmpty()||txtSEX.getText().trim().isEmpty()||txtPhoneNo.getText().trim().isEmpty()||txtUsername.getText().trim().isEmpty()||txtPassword.getText().trim().isEmpty()||!LibraryAssistant.validatePhone(txtPhoneNo.getText())    ){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Error Supplier");
            alert.setHeaderText("Error");
            alert.setContentText("input is not valid");
            alert.initStyle(StageStyle.UNDECORATED);
            alert.showAndWait();
        }else{
            try {
                staff.setStaffID(parseInt(txtStaffID.getText()));
                staff.setStaffCode(txtStaffCode.getText());
                staff.setRoleID(comboboxRoleID.getSelectionModel().getSelectedItem().getRoleID());
                staff.setFName(txtFName.getText());
                staff.setLName(txtLName.getText());
//            staff.setDOB((Date.valueOf(txtDOB.getText())));
                staff.setDOB((Date.valueOf(datePickerDOB.getValue())));
                staff.setAddress(txtAddress.getText());
                staff.setSEX(txtSEX.getText());
                staff.setPhoneNo(txtPhoneNo.getText());
                staff.setUsername(txtUsername.getText());
                staff.setPassword(txtPassword.getText());
                staffDAO.update(staff);
                System.out.println("Da Update" + txtStaffCode.getText());
            } catch ( Exception e ) {
                e.printStackTrace();
            }
        }

        loadDataTableview();
    }
    public void loadDataTableview(){
        StaffDAO staffDAO= new StaffDAO();
        List<Staff> staffs= new ArrayList<>();
        staffs=staffDAO.getList();
        tableview.getItems().clear();
        tableview.getItems().addAll(staffs);

    }
    public void initColumn(){
        columnStaffID.setCellValueFactory(new PropertyValueFactory<>("StaffID"));
        columnStaffCode.setCellValueFactory(new PropertyValueFactory<>("StaffCode"));
        columnRoleID.setCellValueFactory(new PropertyValueFactory<>("RoleID"));
        columnFName.setCellValueFactory(new PropertyValueFactory<>("FName"));
        columnLName.setCellValueFactory(new PropertyValueFactory<>("LName"));
        columnDOB.setCellValueFactory(new PropertyValueFactory<>("DOB"));
        columnAddress.setCellValueFactory(new PropertyValueFactory<>("Address"));
        columnSEX.setCellValueFactory(new PropertyValueFactory<>("SEX"));
        columnPhoneNo.setCellValueFactory(new PropertyValueFactory<>("PhoneNo"));
        columnUsername.setCellValueFactory(new PropertyValueFactory<>("Username"));
        columnPassword.setCellValueFactory(new PropertyValueFactory<>("Password"));
    }

}
