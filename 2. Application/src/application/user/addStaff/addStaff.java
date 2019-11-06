package application.user.addStaff;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;

import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.time.Instant;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

import javafx.scene.control.TextField;
import javafx.util.StringConverter;
import pattern.dao.RoleDAO;
import pattern.dao.StaffDAO;
import pattern.model.Role;
import pattern.model.Staff;


import static java.lang.Integer.parseInt;

public class addStaff implements Initializable {
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
    private TextField txtDOB;

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


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadData();
    }

    /**
     * @param
     * @return none
     */
    //Load data
    public void loadData() {

        RoleDAO roleDAO = new RoleDAO();
        ObservableList<Role> roles = roleDAO.getList();
        comboboxRoleID.setItems(roles);
        comboboxRoleID.getSelectionModel().select(1);
        comboboxRoleID.setConverter(new StringConverter<Role>() {
            @Override
            public String toString(Role role) {
                return role.getRoleName();
            }

            @Override
            public Role fromString(String s) {
                return comboboxRoleID.getItems().stream().filter(ap ->
                        ap.getRoleName().equals(s)).findFirst().orElse(null);
            }
        });

    }

    StaffDAO staffDAO = new StaffDAO();

    @FXML
    void btnAdd(ActionEvent event) {
        Staff staff = new Staff();
        try {
            staff.setStaffID(0);
            staff.setStaffCode(txtStaffCode.getText());
            staff.setRoleID(comboboxRoleID.getSelectionModel().getSelectedItem().getRoleID());
            staff.setFName(txtFName.getText());
            staff.setLName(txtLName.getText());
            staff.setDOB((Date.valueOf(txtDOB.getText())));
            ;
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

    @FXML
    void btnRemove(ActionEvent event) throws SQLException {
        Staff staff = new Staff();
        staffDAO.remove(txtStaffID.getText());
        System.out.println("Da xoa" + txtStaffCode.getText());
    }

    @FXML
    void btnUpdate(ActionEvent event) {
        Staff staff = new Staff();
        try {
            staff.setStaffID(parseInt(txtStaffID.getText()));
            staff.setStaffCode(txtStaffCode.getText());
            staff.setRoleID(comboboxRoleID.getSelectionModel().getSelectedItem().getRoleID());
            staff.setFName(txtFName.getText());
            staff.setLName(txtLName.getText());
            staff.setDOB((Date.valueOf(txtDOB.getText())));
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

}
