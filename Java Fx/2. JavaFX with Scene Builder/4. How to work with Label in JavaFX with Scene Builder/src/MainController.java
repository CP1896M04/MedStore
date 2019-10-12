
import java.util.Random;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.fxml.*;
public class MainController {
@FXML
private Label mylabel;
    public void generateRandom(ActionEvent event){
        Random random= new Random();
        int rand= random.nextInt(100)+1;
        System.out.println(Integer.toString(rand));
        mylabel.setText(Integer.toString(rand));
    }
}
