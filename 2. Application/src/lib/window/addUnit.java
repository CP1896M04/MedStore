package lib.window;

import javafx.stage.Stage;

public class addUnit extends Stage {
    private static addUnit instance;
    public static synchronized addUnit getInstance() throws Exception {
        if(instance == null){
            instance = new addUnit();
        }
        instance.setTitle("Add Unit");
        return instance;
    }
}
