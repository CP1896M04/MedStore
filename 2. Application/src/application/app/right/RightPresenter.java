package application.app.right;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class RightPresenter {
    @FXML
    private Button btnClick;
    public void clicked(){
        System.out.println("click");
    }
}
