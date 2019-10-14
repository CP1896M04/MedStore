package user.application.controller;

import javafx.fxml.FXML;

import java.awt.*;
import java.awt.event.ActionEvent;

public class AppController {
@FXML
public TextField txtUser;
@FXML
    public TextField txtPass;
@FXML
    public Button btnAdd;
@FXML
    public Button btnRemove;
@FXML
    public Button btnDel;
public void buttonAdd(ActionEvent event){
    System.out.println("Hello");
}
}
