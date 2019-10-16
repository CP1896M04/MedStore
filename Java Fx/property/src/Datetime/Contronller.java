package Datetime;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;

import javafx.event.ActionEvent;
import java.time.LocalDate;
import java.util.Locale;

public class Contronller {
    @FXML
    private DatePicker dp;
    @FXML
    private Label mylabel;
    public void DisplayDate(ActionEvent event){
        LocalDate date=dp.getValue();
        mylabel.setText(date.toString());
    }
}
