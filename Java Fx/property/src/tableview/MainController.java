package tableview;


import com.sun.org.apache.xpath.internal.operations.String;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {
@FXML
private TableView<Employee> table;
@FXML
private TableColumn<Employee,Integer> id;
@FXML
private TableColumn<Employee,String> firstname;
@FXML
private TableColumn<Employee,String> lastname;
@FXML
private TableColumn<Employee,Integer> age;
public ObservableList<Employee> list = FXCollections.observableArrayList(
  new Employee(1,"nguyen","Tinh",21),
  new Employee(2,"chu","cha",23),
        new Employee(2,"chu","chae",22),
        new Employee(2,"cha","cha",244),
        new Employee(3,"che","tui",223),
        new Employee(4,"chi","heu",233),
        new Employee(5,"abe","ha",234),
        new Employee(6,"vui","nua",253),
        new Employee(7,"kie","vai",263),
        new Employee(8,"mie","ne",237),
        new Employee(9,"vai","ig",283),
        new Employee(10,"chua","ca",2113),
        new Employee(11,"ha","vasd",2333),
        new Employee(12,"m","cchah",2223),
        new Employee(13,"oi","tui",2333)

);

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        id.setCellValueFactory(new PropertyValueFactory<Employee,Integer>("id"));
        firstname.setCellValueFactory(new PropertyValueFactory<Employee, String>("firstname"));
        lastname.setCellValueFactory(new PropertyValueFactory<Employee,String>("lastname"));
        age.setCellValueFactory(new PropertyValueFactory<Employee,Integer>("age"));
        table.setItems(list);

    }
}
