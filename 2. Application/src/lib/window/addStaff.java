package lib.window;

import javafx.stage.Stage;

public class addStaff extends Stage {
    private static addStaff instance;
    public static synchronized addStaff getInstance() throws Exception {
        if(instance == null){
            instance = new addStaff();
        }
        instance.setTitle("Add Staff");
        return instance;
    }
}
