package application.user.login;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import pattern.dao.StaffDAO;

import java.io.IOException;

public class Login {

    @FXML
    private Label lbUsername;

    @FXML
    private Font x1;

    @FXML
    private Label lbPassword;

    @FXML
    private TextField txtUsername;

    @FXML
    private TextField txtPassword;

    @FXML
    private Button btnLogin;

    @FXML
    private Label lbWarnning;
    @FXML
    private AnchorPane archorPane;

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
            if (exist==true){
                Stage stage = (Stage) archorPane.getScene().getWindow();
                stage.close();
                Parent parent = FXMLLoader.load(getClass().getResource("/application/app/main.fxml"));
                Scene scene = new Scene(parent);
                stage.setScene(scene);
                stage.show();
            } else {
                lbWarnning.setText("Check username or password");
            }
        }
    }

}
