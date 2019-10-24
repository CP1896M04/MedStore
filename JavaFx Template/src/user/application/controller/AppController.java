package user.application.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import user.dao.UserDao;
import user.model.User;


import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.scene.control.Button;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;


public class AppController implements Initializable  {
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
    loadDataFromDatabase();

}
public void buttonRemove(ActionEvent event){
    UserDao userDao = new UserDao();
    User user = new User(txtUser.getText(),txtPass.getText());
    userDao.remove(user);
    System.out.println("Da xoa"+ user.getUserName());
    loadDataFromDatabase();
}
public void buttonUpdate(ActionEvent event){
    UserDao userDao = new UserDao();
    User user = new User(txtUser.getText(),txtPass.getText());
    userDao.update(user);
    System.out.println("Da update"+ user.getUserName());
    loadDataFromDatabase();
}


//table
private Connection con = null;
    private PreparedStatement pst = null;
    private ResultSet rs = null;
    private ObservableList<TableList> data;
    @FXML
    private TableView<TableList> table;
    @FXML
    private TableColumn<?, ?> tableusername;
    @FXML
    private TableColumn<?, ?> tablepassword;

    @Override
    public void initialize(URL agr0, ResourceBundle agr1) {

            con = user.connection.ConnectionFactory.getConnection();

        data = FXCollections.observableArrayList();
        tableView();
        loadDataFromDatabase();
        table.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
//                System.out.println("hello");
//           data(""+table.getSelectionModel().getSelectedItem().getUsername(), table.getSelectionModel().getSelectedItems().g)
              TableList tableList  =table.getSelectionModel().getSelectedItem();
//                System.out.println(tableList.getPassword());
                txtUser.setText(tableList.getUsername());
                txtPass.setText(tableList.getPassword());
            }
        });
    }
    private void tableView() {
        tableusername.setCellValueFactory(new PropertyValueFactory<>("username"));
        tablepassword.setCellValueFactory(new PropertyValueFactory<>("password"));
    }

    private void loadDataFromDatabase() {

        data.clear();
        try {
            pst = con.prepareStatement("select username,password from users");
            rs = pst.executeQuery();
            while (rs.next()) {
                data.add(new TableList(rs.getString(1), rs.getString(2)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AppController.class.getName()).log(Level.SEVERE, null, ex);
        }
        table.setItems(data);
    }





}
