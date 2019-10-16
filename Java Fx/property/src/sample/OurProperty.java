package sample;
import javafx.beans.property.*;
import  java.net.URL;
import javafx.fxml.*;
import java.util.ResourceBundle;
public class OurProperty {
    private DoubleProperty property;

    public final double getProperty() {
        if(property !=null)
            return property.get();
            return  0;


    }

    public final void setProperty(double property) {
        this.propertyProperty().set(property);
    }
public final DoubleProperty propertyProperty(){
        if(property==null){
            property=new SimpleDoubleProperty();
        }
              return property;
    }


}
