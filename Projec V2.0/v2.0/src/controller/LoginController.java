package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import pattern.dao.StaffDAO;
import pattern.model.Staff;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    @FXML
    private Label lbWarnning;

    @FXML
    private Button btnLogin;

    @FXML
    private TextField txtUsername;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private AnchorPane archorPane;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    @FXML
    void btnLogin(ActionEvent event) throws IOException {
        if (txtUsername.getText().trim().isEmpty() && txtPassword.getText().trim().isEmpty()) {
            lbWarnning.setText("Enter Username and Password ");
        } else if (txtUsername.getText().trim().isEmpty()) {
            lbWarnning.setText("Username error");
        } else if (txtPassword.getText().trim().isEmpty()) {
            lbWarnning.setText("Password error");
        }
        else  {
            StaffDAO staffDAO = new StaffDAO();
            boolean exist = staffDAO.checkExist(txtUsername.getText(),txtPassword.getText());
            Staff staff = staffDAO.search(txtUsername.getText(),txtPassword.getText());
            if (exist==true){
                Stage stage = (Stage) archorPane.getScene().getWindow();
                stage.close();
                ApplicationController applicationController = new ApplicationController();
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/view/Application.fxml"));
                loader.load();
                Parent parent = loader.getRoot();
                Scene adminPanelScene = new Scene(parent);
                Stage adminPanelStage = new Stage();
                ApplicationController apControl = loader.getController();
                apControl.setUsrNameMedia(staff);
                adminPanelStage.setScene(adminPanelScene);
                adminPanelStage.setTitle("Home");
                adminPanelStage.show();
            } else {
                lbWarnning.setText("Check username or password");
            }
        }
    }
}
