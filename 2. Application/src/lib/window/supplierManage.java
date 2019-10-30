package lib.window;

import javafx.stage.Stage;

    public class supplierManage extends Stage {
    private static supplierManage instance;
    private supplierManage() throws Exception {}
    public static synchronized supplierManage getInstance() throws Exception {
        if(instance == null){
            instance = new supplierManage();
        }
        instance.setTitle("Supplier Manage");
        return instance;
    }
}
