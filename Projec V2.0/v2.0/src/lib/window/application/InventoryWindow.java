package lib.window.application;

import controller.application.InventoryController;
import controller.application.ProductController;

public class InventoryWindow {
    private static InventoryController instance;
    private InventoryWindow() throws Exception {}
    public static InventoryController getInstance() throws Exception {
        if(instance == null){
            instance = new InventoryController();
        }
        return instance;
    }
}
