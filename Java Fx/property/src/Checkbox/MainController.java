package Checkbox;

import javafx.fxml.*;
import javafx.event.ActionEvent;
import javafx.scene.control.*;

public class MainController {
    @FXML
    private CheckBox checkbox1;
    @FXML
    private CheckBox checkbox2;
    @FXML
    private CheckBox checkbox3;
    @FXML
    private Label mylabel1;
            @FXML
    private Label mylabel2;
    public void checkAction(ActionEvent event){
        String display="";
        int cnt=0;
   if(checkbox1.isSelected()){
        display+=checkbox1.getText()+"\n";
        cnt++;
   }
        if(checkbox2.isSelected()){
            display+=checkbox2.getText()+"\n";
            cnt++;
        }
        if(checkbox3.isSelected()){
            display+=checkbox3.getText()+"\n";
            cnt++;
        }
        mylabel1.setText("you select item(s)"+cnt);
        mylabel2.setText(display);
    }

}
