package sample;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.*;
import javafx.scene.control.*;




public class MainController implements Initializable {
final OurProperty ourProperty=new OurProperty();
@FXML
private Label mylabel;
@FXML
private ProgressBar pb;
@FXML
private ProgressIndicator pi;

    @Override
    public void initialize(URL ag0, ResourceBundle ag1) {
        ourProperty.setProperty(0);
        ourProperty.propertyProperty().addListener(new ChangeListener<Object>() {

            @Override
            public void changed(ObservableValue<? extends Object> observable, Object oldValue, Object newValue) {
                    mylabel.setText(new Double(ourProperty.getProperty()).toString());
                pb.progressProperty().bind(ourProperty.propertyProperty());
                pi.progressProperty().bind(ourProperty.propertyProperty());
            }

        });

    }
    public void ButtonClick(ActionEvent event){
        ourProperty.setProperty(ourProperty.getProperty()+0.1);
    }
    public void Button1Click(ActionEvent event){
        ourProperty.setProperty(ourProperty.getProperty()-0.1);
    }
}
