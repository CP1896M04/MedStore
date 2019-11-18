package lib.window;

import javafx.stage.Stage;

public class addRole extends Stage {
    private static addRole instance;
    private addRole() throws Exception {}
    public static synchronized  addRole getInstance() throws Exception {
        if(instance == null){
            instance = new  addRole();
        }
        instance.setTitle("Add Role");
        return instance;
    }
}
