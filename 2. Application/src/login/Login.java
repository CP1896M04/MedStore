package login;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import pattern.model.Category;


public class Login implements Initializable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML

    @FXML
    private Button btnSignup;

    @FXML
    private Label lbPassword;

    @FXML
    private Label lbUsername;

    @FXML
    private TextField txtPassword;

    @FXML
    private TextField txtUsername;
    @FXML
    void btnLogin(ActionEvent event) {

        if (txtUsername.getText().trim().isEmpty() && txtPassword.getText().trim().isEmpty()) {
            System.out.println("error catname");
            System.out.println("error desc");
        } else if (txtUsername.getText().trim().isEmpty()) {
            System.out.println("error catname");
        } else if (txtPassword.getText().trim().isEmpty()) {
            System.out.println("error desc");
        }
        /
    }

    @FXML
    void btnSignup(ActionEvent event) {
    }




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
