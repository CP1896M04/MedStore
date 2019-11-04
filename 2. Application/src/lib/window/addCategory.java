package lib.window;

import javafx.stage.Stage;

public class addCategory extends Stage {
    private static addCategory instance;
    private addCategory() throws Exception {}
    public static synchronized  addCategory getInstance() throws Exception {
        if(instance == null){
            instance = new  addCategory();
        }
        instance.setTitle("Add New Category");
        return instance;
    }
}
