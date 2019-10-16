package Sliderproperty;

import  javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.text.NumberFormat;
import java.util.ResourceBundle;
import javafx.scene.control.*;

public class Controller implements Initializable {
    @FXML
   private Slider slider;
    @FXML
    private TextField textField;
    private static final double INT_VALUE=50;
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        slider.setValue(INT_VALUE);
        textField.setText(new Double(INT_VALUE).toString());
        textField.textProperty().bindBidirectional(slider.valueProperty(), NumberFormat.getNumberInstance());
    }
}

