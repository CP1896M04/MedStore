package lib.window.application;

import controller.application.ReportController;
import controller.application.StaffController;
import pattern.model.Staff;

public class StaffWindow {
    private static StaffController instance;
    private StaffWindow() throws Exception {}
    public static StaffController getInstance() throws Exception {
        if(instance == null){
            instance = new StaffController();
        }
        return instance;
    }
}
