package user.application.controller;

import javafx.fxml.FXML;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import user.dao.UserDao;
import user.model.User;

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
    public Button btnUpdate;
public void buttonAdd(ActionEvent event){
    UserDao userDao = new UserDao();
    User user = new User(txtUser.getText(),txtPass.getText());
    userDao.add(user);
    System.out.println("Da them"+ user.getUserName());

}
public void buttonRemove(ActionEvent event){
    UserDao userDao = new UserDao();
    User user = new User(txtUser.getText(),txtPass.getText());
    userDao.remove(user);
    System.out.println("Da xoa"+ user.getUserName());
}
public void buttonUpdate(ActionEvent event){
    UserDao userDao = new UserDao();
    User user = new User(txtUser.getText(),txtPass.getText());
    userDao.update(user);
    System.out.println("Da update"+ user.getUserName());
}

}
