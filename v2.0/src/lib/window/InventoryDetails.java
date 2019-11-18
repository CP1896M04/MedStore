package lib.window;

import javafx.stage.Stage;

public class InventoryDetails extends Stage {
    private static InventoryDetails instance;
    public static synchronized InventoryDetails getInstance() throws Exception {
        if(instance == null){
            instance = new InventoryDetails();
        }
        instance.setTitle("InventoryDetails");
        return instance;
    }
}
