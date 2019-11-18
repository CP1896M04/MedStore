package lib.window;

import javafx.stage.Stage;

public class InventoryStatus extends Stage {
    private static InventoryStatus instance;

    public static synchronized InventoryStatus getInstance() throws Exception {
        if (instance == null) {
            instance = new InventoryStatus();
        }
        instance.setTitle("Inventory Status");
        return instance;
    }
}
