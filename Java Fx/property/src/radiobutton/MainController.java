package radiobutton;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;

import javafx.event.ActionEvent;

public class MainController {
    @FXML
    private RadioButton radiobtn1;
    @FXML
    private RadioButton radiobtn2;
    @FXML
    private Label mylabel;
    public void RadioAction(ActionEvent event){
        String display="";
        if(radiobtn1.isSelected()){
            display+=radiobtn1.getText()+"\n";
        }
        if(radiobtn2.isSelected()){
            display+=radiobtn2.getText()+"\n";
        }
        mylabel.setText(display);

    }
}
